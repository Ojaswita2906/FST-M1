import pandas as pd

data = {
    'FirstName': ["Satvik", "Avinash", "Lahri"],
    'LastName': ["Shah", "Kati", "Rath"],
    'Email': ["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
    'PhoneNumber': ["4537829158", "4892184058", "4528727830"]
}

df = pd.DataFrame(data)

print(df)

# Write to Excel using context manager
with pd.ExcelWriter('sample.xlsx') as writer:
    df.to_excel(writer, sheet_name='Sheet1', index=False)
