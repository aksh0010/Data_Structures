def tortoise_hare(arr):
    """
    This function detects if there is a cycle in the given array using the tortoise and hare algorithm.
    """
    tortoise = arr[0]
    hare = arr[0]
    
    while True:
        tortoise = arr[tortoise]
        hare = arr[arr[hare]]
        
        if tortoise == hare:
            return True
        
        if hare == len(arr):
            return False

arr = [2, 1, 3, 4, 2]  # an array with a cycle
has_cycle = tortoise_hare(arr)
print(has_cycle)  # prints True

arr = [1, 2, 3, 4, 5]  # an array without a cycle
has_cycle = tortoise_hare(arr)
print(has_cycle)  # prints False
