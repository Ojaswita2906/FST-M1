numbers = input("Enter comma-separated numbers: ").split(",")

total = 0
for n in numbers:
    n = n.strip()        # remove surrounding spaces
    if n:                # skip empty strings
        total += int(n)

print(total)
