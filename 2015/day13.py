from itertools import permutations

with open('input') as f:
    lines = [l.strip().split() for l in f.readlines()]
d = {}
for l in lines:
    d[l[0], l[-1][:-1]] = int(l[3]) if l[2] == 'gain' else -int(l[3])
l = list(set(k[0] for k in d.keys()))
def max_change():
    res = -float('inf')
    for p in permutations(l):
        change = d[p[0], p[-1]] + d[p[-1], p[0]]
        for i in range(len(p) - 1):
            change += d[p[i], p[i + 1]] + d[p[i + 1], p[i]]
        res = max(res, change)
    return res
print(max_change())
l.append('myself')
for e in l:
    d[e, 'myself'] = 0
    d['myself', e] = 0
print(max_change())
