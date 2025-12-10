
n = int(input("How many Fibonacci numbers would you like to generate? "))

fib_sequence = []

a, b = 1, 1

for i in range(n):
    fib_sequence.append(a)
    a, b = b, a + b


print("Fibonacci sequence:")
print(fib_sequence)
