with open('input') as f:
    line = f.read()
p = 0
s = {p}
for c in line:
    if c == '>':
        p += 1
    elif c == '<':
        p -= 1
    elif c == '^':
        p += 1j
    else:
        p -= 1j
    s.add(p)
print(len(s))
p1 = p2 = 0
s = {p1}
for i, c in enumerate(line):
    if i % 2:
        if c == '>':
            p1 += 1
        elif c == '<':
            p1 -= 1
        elif c == '^':
            p1 += 1j
        else:
            p1 -= 1j
        s.add(p1)
    else:
        if c == '>':
            p2 += 1
        elif c == '<':
            p2 -= 1
        elif c == '^':
            p2 += 1j
        else:
            p2 -= 1j
        s.add(p2)
print(len(s))
