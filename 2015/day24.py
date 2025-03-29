from itertools import combinations
from math import inf, prod

with open('input') as f:
    lines = [int(l) for l in f.readlines()]
def solve(part_two=False):
    res = inf
    for k in range(len(lines)):
        for c in combinations(lines, k):
            if sum(c) == sum(lines) // (4 if part_two else 3):
                res = min(res, prod(set(c)))
        if res < inf:
            return res
print(solve())
print(solve(True))
