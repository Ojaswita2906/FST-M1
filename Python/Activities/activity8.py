# Ask for user input
values = input("Enter a list of numbers separated by commas: ")

# Convert to a list of integers
numbers = [int(n.strip()) for n in values.split(",")]

# Check first and last
if numbers[0] == numbers[-1]:
    print(True)
else:
    print(False)
