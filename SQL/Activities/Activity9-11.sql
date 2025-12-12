desc orders;
desc salesman;
desc customers;

--Activity 9 
--SQL statement to know which salesman are working for which customer.
SELECT s.salesman_name, c.customer_name FROM salesman s inner join customers c on s.salesman_id = c.salesman_id; 

--SQL statement to make a list of customers in ascending order with a salesman that have a grade less than 300
SELECT c.customer_name, s.salesman_name, c.grade from salesman s inner join customers c on s.salesman_id = c.salesman_id WHERE c.grade <300 order by c.customer_name ASC;

--SQL statement to find the list of customers who appointed a salesman who gets a commission of more than 12%
SELECT c.customer_name, s.salesman_name, s.commission FROM salesman s inner join customers c on s.salesman_id = c.salesman_id where s.commission>12;

--SQL statement to find the following details of an order - order number, order date, purchase amount of order, 
--which customer gives the order and which salesman works for that customer and commission rate they get for the order.
SELECT o.order_no, o.order_date, o.purchase_amount, c.customer_name,s.salesman_name,s.commission FROM orders o inner join salesman s on o.salesman_id=s.salesman_id inner join customers c on o.customer_id = c.customer_id; 

--Activity 10
--a query to find all the orders issued against the salesman who may works for customer whose id is 3007
SELECT * FROM orders WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);


--a query to find all orders attributed to a salesman in New York.
SELECT * FROM orders WHERE salesman_id = (SELECT salesman_id FROM salesman WHERE salesman_city = 'New York');

--a query to count the customers with grades above New York's average
SELECT count(customer_id) FROM customers where grade > (SELECT avg(grade) from customers where city ='New York');

--query to extract the data from the orders table for those salesman who earned the maximum commission
SELECT order_no, purchase_amount, order_date, salesman_id FROM orders WHERE salesman_id IN( SELECT salesman_id FROM salesman WHERE commission=( SELECT MAX(commission) FROM salesman));


--Activity 11

-- a query that produces the name and number of each salesman and each customer with more than one current order. Put the results in alphabetical order.
SELECT customer_id, customer_name FROM customers a WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id)
UNION
SELECT salesman_id, salesman_name FROM salesman a WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id) ORDER BY customer_name;

--a query to make a report of which salesman produce the largest and smallest orders on each date
SELECT a.salesman_id, a.salesman_name, o.order_no, 'highest on', o.order_date, o.purchase_amount FROM salesman a, orders o WHERE a.salesman_id=o.salesman_id AND o.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = o.order_date)
UNION
SELECT a.salesman_id, a.salesman_name, o.order_no, 'lowest on', o.order_date, o.purchase_amount FROM salesman a, orders o WHERE a.salesman_id=o.salesman_id AND o.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = o.order_date) ORDER BY order_date;
