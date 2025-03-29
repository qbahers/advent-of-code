with open('input') as f:
    lines = f.readlines()
def number_of_lights_on(grid, part_two=False):
    for _ in range(100):
        next_state = []
        for i in range(len(grid)):
            s = ""
            for j in range(len(grid)):
                count = 0
                for k in range(i - 1, i + 2):
                    for l in range(j - 1, j + 2):
                        if (k != i or l != j) and 0 <= k < len(grid) and 0 <= l < len(grid) and grid[k][l] == '#':
                            count += 1
                s += '#' if count == 3 or count == 2 and grid[i][j] == '#' else '.'
            next_state.append(s)
        grid = next_state
        if part_two:
            grid[0] = '#' + grid[0][1:-1] + '#'
            grid[-1] = '#' + grid[-1][1:-1] + '#'
    return sum([row.count('#') for row in grid])
print(number_of_lights_on(lines))
print(number_of_lights_on(lines, True))
