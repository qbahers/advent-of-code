with open('input') as f:
    lines = f.readlines()
m = [[0 for x in range(1000)] for y in range(1000)]
for line in lines:
    a = line.removeprefix('turn ').split(' ')
    x1, y1 = [int(e) for e in a[1].split(',')]
    x2, y2 = [int(e) for e in a[3].split(',')]
    for x in range(x1, x2 + 1):
        for y in range(y1, y2 + 1):
             if a[0] == 'on':
                m[x][y] = 1
             elif a[0] == 'off':
                m[x][y] = 0
             else:
                m[x][y] ^= 1
res = 0
for x in range(1000):
    for y in range(1000):
        res += m[x][y]
print(res)
m = [[0 for x in range(1000)] for y in range(1000)]
for line in lines:
    a = line.removeprefix('turn ').split(' ')
    x1, y1 = [int(e) for e in a[1].split(',')]
    x2, y2 = [int(e) for e in a[3].split(',')]
    for x in range(x1, x2 + 1):
        for y in range(y1, y2 + 1):
            if a[0] == 'on':
                m[x][y] += 1
            elif a[0] == 'off':
                m[x][y] -= 1 if m[x][y] > 0 else 0
            else:
                m[x][y] += 2
res = 0
for x in range(1000):
    for y in range(1000):
        res += m[x][y]
print(res)
