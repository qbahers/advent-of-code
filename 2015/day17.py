import itertools

with open('input') as f:
    lines = [int(l) for l in f.readlines()]
def f(containers, liters_to_store):
    count = [0] * (len(containers) + 1)
    for i in range(1, len(containers) + 1):
        for c in itertools.combinations(containers, i):
            if sum(c) == liters_to_store:
                count[len(c)] += 1
    return sum(count), next(e for e in count if e > 0)
print(f(lines, 150))
