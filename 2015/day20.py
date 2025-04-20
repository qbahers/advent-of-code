with open('input') as f:
    n = int(f.read())
presents = [0] * (n // 10)
for elf in range(1, n // 10):
    for house in range(elf, n // 10, elf):
        presents[house] += 10 * elf
print(next(i for i, p in enumerate(presents) if p >= n))
presents = [0] * (n // 10)
for elf in range(1, n // 10):
    for house in range(elf, min(n // 10, 50 * elf), elf):
        presents[house] += 11 * elf
print(next(i for i, p in enumerate(presents) if p >= n))
