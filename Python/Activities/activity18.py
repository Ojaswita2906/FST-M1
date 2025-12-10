import pandas as pd

# Read the CSV file
df = pd.read_csv("sample.csv")

# 1. Print only the Usernames column
print("Usernames column:")
print(df["Usernames"])
print()

# 2. Print username and password of the second row
print("Second row username and password:")
print("Username:", df.loc[1, "Usernames"])
print("Password:", df.loc[1, "Passwords"])
print()

# 3. Sort the Usernames column in ascending order and print
print("Usernames sorted in ascending order:")
print(df.sort_values("Usernames"))
print()

# 4. Sort the Passwords column in descending order and print
print("Passwords sorted in descending order:")
print(df.sort_values("Passwords", ascending=False))
