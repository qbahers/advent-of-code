with open('input') as f:
    lines = [l.split() for l in f.readlines()]
l = [0] * len(lines)
ll = [0] * len(lines)
for i in range(2503):
    for j in range(len(lines)):
        x, y, z = int(lines[j][3]), int(lines[j][6]), int(lines[j][-2])
        l[j] += x if i % (y + z) < y else 0
    for j in range(len(lines)):
        if l[j] == max(l):
            ll[j] += 1
print(max(l))
print(max(ll))
