def part1(nums):
    tests = []
    for i in range(min(nums), max(nums)):
        fuelUsed = 0
        for j  in nums:
            fuelUsed += abs(j - i)
        tests.append(fuelUsed)
    print(f'Min: {min(tests)}')

def part2(nums):
    tests = []
    for i in range(min(nums), max(nums)):
        fuelUsed = 0
        for j  in nums:
            dS = abs(j - i)
            fuelUsed += ((dS * (dS + 1)) / 2) # General equation for sum of (+) integers from 1 => n.
        tests.append(fuelUsed)
    print(f'Min: {min(tests)}')

with open('input.txt') as f:
    nums = list(map(int, f.readline().split(",")))
    part1(nums)
    part2(nums)
    
