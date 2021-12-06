def iterate(arr, times):
    for i in range(0, times):
        # scuffed
        newFish = arr[0]
        arr[0] = arr[1]
        arr[1] = arr[2]
        arr[2] = arr[3]
        arr[3] = arr[4]
        arr[4] = arr[5]
        arr[5] = arr[6]
        arr[6] = arr[7] + newFish
        arr[7] = arr[8]
        arr[8] = newFish
    return sum(arr)

with open('input.txt') as f:
    nums = list(map(int, f.readline().split(",")))
    sorted = []
    for i in range(0, 8): # Get array of occurrances of digits 0-8 from input
        count = 0
        for j in nums:
            if(j == i):
                count += 1
        sorted.append(count)
    sorted.append(0)

    print(iterate(sorted, 256))