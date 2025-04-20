with open('input') as f:
    lines = [int(l.split()[-1]) for l in f.readlines()]

def mana_spent(spells, part_two=False):
    amount = 0
    boss = lines.copy()
    player = [50, 500]
    poison_timer = recharge_timer = shield_timer = 0
    turn = 'Player'
    while True:
        print(f'{turn} turn: {player, boss}')

        if poison_timer > 0:
            boss[0] -= 3
            poison_timer -= 1
        if recharge_timer > 0:
            player[1] += 101
            recharge_timer -= 1
        if shield_timer > 0:
            shield_timer -= 1

        if boss[0] < 1 or player[0] < 1:
            return amount

        if turn == 'Player':
            if part_two:
                player[0] -= 1

            spell = next(spells)
            if spell == 'Magic Missile':
                player[1] -= 53
                amount += 53
                boss[0] -= 4
            elif spell == 'Drain':
                player[1] -= 73
                amount += 73
                boss[0] -= 2
                player[0] += 2
            elif spell == 'Shield':
                player[1] -= 113
                amount += 113
                shield_timer = 6
            elif spell == 'Poison':
                player[1] -= 173
                amount += 173
                poison_timer = 6
            else:
                player[1] -= 229
                amount += 229
                recharge_timer = 5
        else:
            player[0] -= boss[1] if shield_timer == 0 else max(1, boss[1] - 7)

        turn = 'Boss' if turn == 'Player' else 'Player'

print(mana_spent(iter(['Poison', 'Recharge', 'Shield', 'Poison', 'Magic Missile', 'Magic Missile', 'Magic Missile', 'Magic Missile', 'Magic Missile'])))
print(mana_spent(iter(['Poison', 'Recharge', 'Shield', 'Poison', 'Recharge', 'Drain', 'Poison', 'Drain', 'Magic Missile']), True))
