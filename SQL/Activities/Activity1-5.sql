--Activity1 : Create salesman table

CREATE TABLE SALESMAN(salesman_id int PRIMARY KEY,salesman_name varchar(20), salesman_city varchar(20),commission int);
DESCRIBE salesman


--Activity2 : Insert data into salesman table

INSERT ALL
	INTO salesman VALUES (5001,'Anmol','Gurgaon',11)
	INTO salesman VALUES (5002,'Aman','Delhi',14)
	INTO salesman VALUES (5003,'Arav','Bangalore',21)
	INTO salesman VALUES (5004,'Amay','Hyderabad',15)	
	INTO salesman VALUES (5005,'Abhay','Solan',23)
	INTO salesman VALUES (5006,'Atharv','Chandigrh',17)
SELECT 1 FROM DUAL;

--DISPLAY

SELECT *FROM salesman;


--Activity 3 Display data from salesman

--Show data from the salesman_id and salesman_city columns
SELECT salesman_id, salesman_city FROM salesman;

--Show data of salesman from Paris(DELHI)
SELECT * FROM salesman WHERE salesman_city = 'Delhi';

--Show salesman_id and commission of Paul Adam (Arav)

SELECT salesman_id,commission FROM salesman where salesman_name = 'Arav'

--Activity 4: add a column
ALTER TABLE salesman ADD (grade int);
DESC salesman;
UPDATE salesman SET grade=100;

--Activity 5: To modify values

--Update the grade score of salesmen from Rome(Gurgaon) to 200.
UPDATE salesman SET grade = 200 WHERE salesman_city = 'Gurgaon'

--Update the grade score of James Hoog to 300.
UPDATE salesman SET grade = 300 WHERE salesman_name = 'Atharv'

--Update the name McLyon(Amay) to Pierre (Atul).
UPDATE salesman SET salesman_name = 'Atul' WHERE salesman_name = 'Amay'

--Display Table
Select * from salesman;
	