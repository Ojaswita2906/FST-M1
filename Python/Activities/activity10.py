
user_input = input("Enter numbers separated by commas: ")


numbers = tuple(int(x) for x in user_input.split(","))

print("\nNumbers divisible by 5:")
for num in numbers:
    if num % 5 == 0:
        print(num)
