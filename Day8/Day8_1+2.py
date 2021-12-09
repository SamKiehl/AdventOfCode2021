# 0 : abcef, 1 : cf, 2 : acdeg, 3 : acdfg, 4 : bcdf, 5 : abdfg, 6 : abdefg, 7 : acf, 8 : abcdef : 9: abcdf


def part1(arr):
    count = 0
    for i in arr:
        for j in i[1]:
            if(len(j) == 2 or len(j) == 4 or len(j) == 3 or len(j) == 7):
                print(j)
                count += 1
    return count

# def part2(arr):
#     alpha = [[]]
#     for i in arr:
#         od = []
#         for j in i[1]:
#             s = ''.join(sorted(j))
#             od.append(s)
#         alpha.append(od)
    



with open('input.txt') as f:
    lines = f.readlines()
    pairs = []
    for l in lines:
        pairs.append(l.replace('\n', '').split(' | ')) #2d array: one line = i array => [left, right]
    for i in range(len(pairs)):
        for j in range(len(pairs[i])):
            pairs[i][j] = pairs[i][j].split(' ')
    print(part1(pairs))
    # print(part2(pairs))

    #print(pairs)

# pairs is now a 3d array: pairs[row][left0 / right1 side][letter group]
