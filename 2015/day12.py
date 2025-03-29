import json

with open('input') as f:
    line = json.load(f)
def sum_numbers(d, ignore=None):
    if isinstance(d, dict):
        return 0 if ignore in d.values() else sum(sum_numbers(e, ignore) for e in d.values())
    if isinstance(d, list):
        return sum(sum_numbers(e, ignore) for e in d)
    if isinstance(d, int):
        return d
    return 0
print(sum_numbers(line))
print(sum_numbers(line, "red"))
