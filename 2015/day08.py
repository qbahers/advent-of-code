import re

with open('input') as f:
    lines = [l.strip() for l in f.readlines()]
a = b = c = 0
for line in lines:
    a += len(line)
    b += len(re.sub(r'(\\\\)|(\\")|(\\x[0-9a-f]{2})', '.', line)) - 2
    c += len(re.sub(r'(\\)|(")', '..', line)) + 2
print(a - b, c - a)
