with open('input') as f:
    line = f.read()
for _ in range(50):
    d, k, l = line[0], 0, []
    for c in line:
        if c == d:
            k += 1
        else:
            l += [str(k), d]
            d, k = c, 1
    l += [str(k), d]
    line = ''.join(l)
print(len(line))
