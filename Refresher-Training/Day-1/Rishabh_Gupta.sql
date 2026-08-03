CREATE DATABASE company_db;

USE company_db;


CREATE TABLE department(
    dept_id INT PRIMARY KEY AUTO_INCREMENT,
    dept_name VARCHAR(50) UNIQUE NOT NULL
);


INSERT INTO department(dept_name)
VALUES
('IT'),
('HR'),
('Finance'),
('Sales');


CREATE TABLE employee(
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    age INT,
    salary DOUBLE DEFAULT 30000,
    dept_id INT,
    FOREIGN KEY(dept_id) REFERENCES department(dept_id)
);


INSERT INTO employee(emp_name,email,age,salary,dept_id)
VALUES
('Ravi','ravi@gmail.com',25,50000,1),
('Amit','amit@gmail.com',30,60000,2),
('Neha','neha@gmail.com',24,45000,1),
('Priya','priya@gmail.com',28,70000,3);



SELECT * FROM employee;


SELECT emp_name,salary
FROM employee
WHERE salary > 50000;


SELECT e.emp_name,d.dept_name
FROM employee e
INNER JOIN department d
ON e.dept_id=d.dept_id;



SELECT e.emp_name,d.dept_name
FROM employee e
LEFT JOIN department d
ON e.dept_id=d.dept_id;



SELECT *
FROM employee
WHERE salary >
(
    SELECT AVG(salary)
    FROM employee
);



SELECT dept_id,COUNT(*) 
FROM employee
GROUP BY dept_id;



UPDATE employee
SET salary=80000
WHERE emp_id=1;



DELETE FROM employee
WHERE emp_id=3;



CREATE INDEX emp_name_index
ON employee(emp_name);



EXPLAIN
SELECT *
FROM employee
WHERE emp_name='Ravi';



START TRANSACTION;

UPDATE employee
SET salary=90000
WHERE emp_id=1;

ROLLBACK;



CREATE VIEW employee_view AS
SELECT 
e.emp_name,
e.salary,
d.dept_name
FROM employee e
JOIN department d
ON e.dept_id=d.dept_id;


SELECT * FROM employee_view;



WITH salary_data AS
(
SELECT *
FROM employee
WHERE salary>50000
)

SELECT *
FROM salary_data;



SELECT
emp_name,
salary,
RANK() OVER(ORDER BY salary DESC) AS rank_no
FROM employee;



CREATE TABLE users(
id INT PRIMARY KEY,
name VARCHAR(50),
details JSON
);


INSERT INTO users
VALUES
(1,'Rahul',
'{"city":"Varanasi","age":25}');


SELECT
name,
details->>'$.city'
FROM users;