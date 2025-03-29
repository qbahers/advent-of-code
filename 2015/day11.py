from string import ascii_lowercase

with open('input') as f:
    line = f.read()
def increment(s):
    return increment(s[:-1]) + 'a' if s[-1] == 'z' else s[:-1] + chr(ord(s[-1]) + 1)
line = increment(line)
while (not any(c + chr(ord(c) + 1) + chr(ord(c) + 2) in line for c in ascii_lowercase) or not
    all(c not in line for c in 'iol') or not
    sum(2 * c in line for c in ascii_lowercase) > 1):
    line = increment(line)
print(line)
