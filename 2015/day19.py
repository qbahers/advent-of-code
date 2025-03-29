import re

with open('input') as f:
    lines = f.readlines()
molecule = lines[-1]
replacements = [l.strip().split(' => ') for l in lines[:-2]]
s = set()
for r in replacements:
    for m in re.finditer(r[0], molecule):
        s.add(molecule[:m.start()] + r[1] + molecule[m.end():])
print(len(s))
steps = 0
while molecule != 'e':
    for r in replacements:
        if r[1] in molecule:
            molecule = molecule.replace(r[1], r[0], 1)
            steps += 1
print(steps)
