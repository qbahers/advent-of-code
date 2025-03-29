with open('input') as f:
    lines = [l.split() for l in f.readlines()]
def f(calories=None):
    res = 0
    for x in range(101):
        for y in range(101 - x):
            for z in range(101 - x - y):
                a = b = c = d = e = 0
                l = [x, y, z, 100 - x - y - z]
                for k in range(4):
                    a += l[k] * int(lines[k][2][:-1])
                    b += l[k] * int(lines[k][4][:-1])
                    c += l[k] * int(lines[k][6][:-1])
                    d += l[k] * int(lines[k][8][:-1])
                    e += l[k] * int(lines[k][-1])
                if calories is None or e == calories:
                    res = max(res, max(a, 0) * max(b, 0) * max(c, 0) * max(d, 0))
    return res
print(f())
print(f(500))
