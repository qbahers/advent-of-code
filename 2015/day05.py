import re
from string import ascii_lowercase

with open('input') as f:
    lines = f.readlines()
res = 0
for line in lines:
    if (len(re.findall('[aeiou]', line)) > 2 and
        any(2 * c in line for c in ascii_lowercase) and
        not any(s in line for s in ['ab', 'cd', 'pq', 'xy'])):
        res += 1
print(res)
res = 0
for line in lines:
    if (any(line.rfind(c1 + c2) - line.find(c1 + c2) > 1 for c1 in ascii_lowercase for c2 in ascii_lowercase) and
        any(re.search(f"{c}.{c}", line) for c in ascii_lowercase)):
        res += 1
print(res)
