from hashlib import md5

with open('input') as f:
    line = f.read()
i = 0
while not md5((line + str(i)).encode()).hexdigest().startswith(5 * '0'):
    i += 1
print(i)
i = 0
while not md5((line + str(i)).encode()).hexdigest().startswith(6 * '0'):
    i += 1
print(i)
