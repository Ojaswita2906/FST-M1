fruits = {
    "apple": 120,
    "banana": 40,
    "mango": 150,
    "orange": 80,
    "grapes": 90
}

fruit = input("Enter the fruit you want to check: ").lower()

if fruit in fruits:
    print(f"{fruit.capitalize()} is available and costs {fruits[fruit]} units.")
else:
    print(f"Sorry, {fruit} is not available.")
