def sum_list(numlist):
    total = 0
    for item in numlist:
        total += item
    print("Sum of all elements:", total)


user_input = input("Enter numbers separated by commas: ")

numbers = [int(x) for x in user_input.split(",")]
sum_list(numbers)
