with open('input') as f:
    res1 = res2 = 0
    for line in f:
        l, w, h = [int(e) for e in line.split('x')]
        res1 += 2 * (l * w + l * h + w * h) + min(l * w, l * h, w * h)
        res2 += 2 * min(l + w, l + h, w + h) + l * w * h
print(res1, res2)
