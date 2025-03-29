from itertools import permutations
from math import inf

with open('input') as f:
    lines = [l.split() for l in f.readlines()]
d = {}
for l in lines:
    d[l[0], l[2]] = int(l[4])
    d[l[2], l[0]] = int(l[4])
l = list(set(e[0] for e in d.keys()))
shortest, longest = inf, -inf
for p in permutations(l):
    shortest = min(shortest, sum(d[p[i], p[i + 1]] for i in range(len(p) - 1)))
    longest = max(longest, sum(d[p[i], p[i + 1]] for i in range(len(p) - 1)))
print(shortest, longest)
