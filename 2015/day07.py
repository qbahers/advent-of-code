from functools import cache

with open('input') as f:
    lines = f.readlines()
d = {}
for line in lines:
    v, k = line.strip().split(' -> ')
    d[k] = v
@cache
def evaluate(c):
    if c.isnumeric():
        return int(c)
    if 'AND' in c:
        l, r = c.split(' AND ')
        return evaluate(l) & evaluate(r)
    if 'OR' in c:
        l, r = c.split(' OR ')
        return evaluate(l) | evaluate(r)
    elif 'LSHIFT' in c:
        l, r = c.split(' LSHIFT ')
        return evaluate(l) << int(r)
    elif 'RSHIFT' in c:
        l, r = c.split(' RSHIFT ')
        return evaluate(l) >> int(r)
    elif 'NOT' in c:
        return (1 << 16) - 1 - evaluate(c.removeprefix('NOT '))
    else:
        return evaluate(d[c])
print(evaluate('a'))
