with open('input') as f:
    line = f.read()
print(line.count('(') - line.count(')'))
res = 0
for i, c in enumerate(line):
    res += 1 if c == '(' else -1
    if res == -1:
        print(i + 1)
        break
