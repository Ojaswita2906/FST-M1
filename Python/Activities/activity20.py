import pandas as pd

# Read data from the Excel file
df = pd.read_excel("sample.xlsx")

# 1. Print the number of rows and columns
rows, cols = df.shape
print("Number of rows:", rows)
print("Number of columns:", cols)

# 2. Print only the emails column
print("\nEmails column:")
print(df["Email"])

# 3. Sort data by FirstName in ascending order and print
sorted_df = df.sort_values(by="FirstName", ascending=True)

print("\nData sorted by FirstName (ascending):")
print(sorted_df)
