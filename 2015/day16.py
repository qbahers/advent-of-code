import re

with open('input') as f:
    lines = f.readlines()
d = {'children': 3, 'cats': 7, 'samoyeds': 2, 'pomeranians': 3, 'akitas': 0, 'vizslas': 0, 'goldfish': 5, 'trees': 3,
     'cars': 2, 'perfumes': 1}
for line in lines:
    found = True
    for k, v in d.items():
        num = re.search(rf"{k}: (\d+)", line)
        if num is not None and v != int(num.group(1)):
            found = False
    if found:
        print(line)
for line in lines:
    found = True
    for k, v in d.items():
        num = re.search(rf"{k}: (\d+)", line)
        if num is None:
            continue
        elif ((k in ['cats', 'trees'] and v >= int(num.group(1))) or
              (k in ['pomeranians', 'goldfish'] and v <= int(num.group(1))) or
              (k in ['children', 'samoyeds', 'akitas', 'vizslas', 'cars', 'perfumes'] and v != int(num.group(1)))):
            found = False
    if found:
        print(line)
