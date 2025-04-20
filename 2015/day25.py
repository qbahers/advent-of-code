import re

with open('input') as f:
    row, col = [int(e) for e in re.findall(r'\d+', f.read())]
r = c = 1
k = 1
code = 20151125
while r != row or c != col:
    if c == k:
        k += 1
        r, c = k, 1
    else:
        r, c = r - 1, c + 1
    code = 252533 * code % 33554393
print(code)
