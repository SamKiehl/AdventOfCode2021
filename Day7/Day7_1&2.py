def part1(nums):
    tests = []
    for i in range(min(nums), max(nums)):
        fuelUsed = 0
        for j  in nums:
            fuelUsed += abs(j - i)
        tests.append(fuelUsed)
        #print(f'num: {i}: fuelUesed: {fuelUsed}')
    print(f'\n\n\nMin: {min(tests)}')

def part2(nums):
    tests = []
    for i in range(min(nums), max(nums)):
        fuelUsed = 0
        for j  in nums:
            dS = abs(j - i)
            fuelUsed += ((dS * (dS + 1)) / 2)
        tests.append(fuelUsed)
        #print(f'num: {i}: fuelUesed: {fuelUsed}')
    print(f'\n\n\nMin: {min(tests)}')

with open('input.txt') as f:
    nums = list(map(int, f.readline().split(",")))
    # print(nums)
    # print(f'\n\n\nMax: {max(nums)}')
    # print(f'\n\n\nMin: : {min(nums)}')
    part1(nums)
    part2(nums)
    
