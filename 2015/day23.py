with open('input') as f:
    lines = [l.replace(',', '').split() for l in f.readlines()]
def run(registers):
    i = 0
    while i < len(lines):
        line = lines[i]
        if line[0] == 'hlf':
            registers[line[1]] //= 2
        elif line[0] == 'tpl':
            registers[line[1]] *= 3
        elif line[0] == 'inc':
            registers[line[1]] += 1
        elif line[0] == 'jmp':
            i += int(line[1]) - 1
        elif line[0] == 'jie':
            if registers[line[1]] % 2 == 0:
                i += int(line[2]) - 1
        else:
            if registers[line[1]] == 1:
                i += int(line[2]) - 1
        i += 1
    return registers['b']
print(run({'a': 0, 'b': 0}))
print(run({'a': 1, 'b': 0}))
