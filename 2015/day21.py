from math import inf

with open('input') as f:
    enemy = [int(l.split()[-1]) for l in f.readlines()]
weapons = [[8, 4, 0], [10, 5, 0], [25, 6, 0], [40, 7, 0], [74, 8, 0]]
armor = [[0, 0, 0], [13, 0, 1], [31, 0, 2], [53, 0, 3], [75, 0, 4], [102, 0, 5]]
rings = [[0, 0, 0], [25, 1, 0], [50, 2, 0], [100, 3, 0], [20, 0, 1], [40, 0, 2], [80, 0, 3]]
def player_wins(boss, player):
    while True:
        boss[0] -= max(player[1] - boss[2], 1)
        if boss[0] < 1:
            return True
        player[0] -= max(boss[1] - player[2], 1)
        if player[0] < 1:
            return False
min_gold, max_gold = inf, -inf
for i in range(len(weapons)):
    for j in range(len(armor)):
        for k in range(len(rings)):
            for l in range(len(rings)):
                me = [100, 0, 0]
                me[1] += weapons[i][1] + armor[j][1] + rings[k][1] + rings[l][1]
                me[2] += weapons[i][2] + armor[j][2] + rings[k][2] + rings[l][2]
                if k != l:
                    if player_wins(enemy.copy(), me.copy()):
                        min_gold = min(min_gold, weapons[i][0] + armor[j][0] + rings[k][0] + rings[l][0])
                    else:
                        max_gold = max(max_gold, weapons[i][0] + armor[j][0] + rings[k][0] + rings[l][0])
print(min_gold, max_gold)
