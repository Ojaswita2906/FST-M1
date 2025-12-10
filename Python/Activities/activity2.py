#Ask the user for a number.Depending on what number they enter, tell them if the number is an even or odd number.
num=int(input("Enter a number"))
if(num%2==0):
    print(f"The number {num} you entered is even")
else:
    print(f"The number {num} you entered is odd")