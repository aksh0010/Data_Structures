def bubble(list):
    for i in range(len(list) - 1, 0, -1):
        no_swap = True
        for j in range(i):
            if list[j] > list[j + 1]:
                list[j], list[j + 1] = list[j + 1], list[j]
                no_swap = False
        if no_swap:
            break
    return list

list = [64, 34, 25, 12, 22, 11, 90]
print(bubble(list))
