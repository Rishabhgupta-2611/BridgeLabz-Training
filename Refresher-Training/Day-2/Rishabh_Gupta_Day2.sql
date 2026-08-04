CREATE DATABASE college_db;

USE college_db;

CREATE TABLE department(
    dept_id INT PRIMARY KEY AUTO_INCREMENT,
    dept_name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE student(
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    age INT CHECK(age>=18),
    dept_id INT,
    FOREIGN KEY(dept_id) REFERENCES department(dept_id)
);

CREATE TABLE instructor(
    instructor_id INT PRIMARY KEY AUTO_INCREMENT,
    instructor_name VARCHAR(50),
    dept_id INT,
    FOREIGN KEY(dept_id) REFERENCES department(dept_id)
);

CREATE TABLE course(
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(50),
    credits INT,
    dept_id INT,
    FOREIGN KEY(dept_id) REFERENCES department(dept_id)
);

CREATE TABLE enrollment(
    student_id INT,
    course_id INT,
    enroll_date DATE,
    PRIMARY KEY(student_id,course_id),
    FOREIGN KEY(student_id) REFERENCES student(student_id),
    FOREIGN KEY(course_id) REFERENCES course(course_id)
);

INSERT INTO department(dept_name)
VALUES
('Computer Science'),
('Mechanical'),
('Civil'),
('Electronics');

INSERT INTO student(student_name,email,age,dept_id)
VALUES
('Rishabh','rishabh@gmail.com',22,1),
('Rahul','rahul@gmail.com',21,2),
('Priya','priya@gmail.com',23,1),
('Anjali','anjali@gmail.com',20,3),
('Amit','amit@gmail.com',24,4);

INSERT INTO instructor(instructor_name,dept_id)
VALUES
('Raj',1),
('Kiran',2),
('Meera',3),
('Aakash',4);

INSERT INTO course(course_name,credits,dept_id)
VALUES
('Java',4,1),
('DBMS',3,1),
('Thermodynamics',4,2),
('Surveying',3,3),
('Digital Electronics',4,4);

INSERT INTO enrollment
VALUES
(1,1,'2026-01-10'),
(1,2,'2026-01-10'),
(2,3,'2026-01-11'),
(3,2,'2026-01-12'),
(4,4,'2026-01-13'),
(5,5,'2026-01-14');

SELECT * FROM department;

SELECT * FROM student;

SELECT * FROM course;

SELECT * FROM enrollment;

SELECT student_name,email
FROM student;

SELECT *
FROM student
WHERE age>21;

SELECT *
FROM student
ORDER BY student_name;

SELECT *
FROM student
ORDER BY age DESC;

SELECT COUNT(*) FROM student;

SELECT AVG(age) FROM student;

SELECT MAX(age) FROM student;

SELECT MIN(age) FROM student;

SELECT dept_id,COUNT(*)
FROM student
GROUP BY dept_id;

SELECT dept_id,COUNT(*)
FROM student
GROUP BY dept_id
HAVING COUNT(*)>1;

SELECT s.student_name,d.dept_name
FROM student s
INNER JOIN department d
ON s.dept_id=d.dept_id;

SELECT s.student_name,d.dept_name
FROM student s
LEFT JOIN department d
ON s.dept_id=d.dept_id;

SELECT d.dept_name,c.course_name
FROM department d
RIGHT JOIN course c
ON d.dept_id=c.dept_id;

SELECT *
FROM student
CROSS JOIN department;

SELECT s.student_name,c.course_name
FROM student s
JOIN enrollment e
ON s.student_id=e.student_id
JOIN course c
ON e.course_id=c.course_id;

SELECT *
FROM student
WHERE age>(
SELECT AVG(age)
FROM student
);

SELECT *
FROM student
WHERE age=(
SELECT MAX(age)
FROM student
);

SELECT course_name
FROM course
WHERE dept_id IN(
SELECT dept_id
FROM department
WHERE dept_name='Computer Science'
);

SELECT dept_name
FROM department d
WHERE EXISTS(
SELECT *
FROM student s
WHERE s.dept_id=d.dept_id
);

WITH cs_students AS
(
SELECT *
FROM student
WHERE dept_id=1
)
SELECT *
FROM cs_students;

SELECT
student_name,
age,
ROW_NUMBER() OVER(ORDER BY age DESC) AS row_num
FROM student;

SELECT
student_name,
age,
RANK() OVER(ORDER BY age DESC) AS rank_no
FROM student;

SELECT
student_name,
age,
DENSE_RANK() OVER(ORDER BY age DESC) AS dense_rank
FROM student;

CREATE INDEX idx_student_name
ON student(student_name);

CREATE UNIQUE INDEX idx_student_email
ON student(email);

CREATE INDEX idx_course_dept
ON course(course_name,dept_id);

EXPLAIN
SELECT *
FROM student
WHERE student_name='Rishabh';

CREATE VIEW student_department AS
SELECT
s.student_name,
d.dept_name
FROM student s
JOIN department d
ON s.dept_id=d.dept_id;

SELECT *
FROM student_department;

START TRANSACTION;

UPDATE student
SET age=25
WHERE student_id=1;

ROLLBACK;

START TRANSACTION;

UPDATE student
SET age=25
WHERE student_id=1;

COMMIT;

ALTER TABLE student
ADD phone VARCHAR(15);

ALTER TABLE student
DROP COLUMN phone;

CREATE TABLE student_profile(
    profile_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT UNIQUE,
    address VARCHAR(100),
    FOREIGN KEY(student_id) REFERENCES student(student_id)
);

INSERT INTO student_profile(student_id,address)
VALUES
(1,'Varanasi'),
(2,'Lucknow'),
(3,'Delhi');

SELECT s.student_name,p.address
FROM student s
JOIN student_profile p
ON s.student_id=p.student_id;

CREATE TABLE books(
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    details JSON
);

INSERT INTO books(title,details)
VALUES
('DBMS',
'{"author":"Navathe","price":550,"language":"English"}');

SELECT
title,
details->>'$.author'
FROM books;

SELECT
title,
details->>'$.price'
FROM books;

SELECT *
FROM student
LIMIT 3;

SELECT *
FROM student
LIMIT 2 OFFSET 2;

SELECT DISTINCT dept_id
FROM student;

SELECT *
FROM student
WHERE student_name LIKE 'R%';

SELECT *
FROM student
WHERE age BETWEEN 20 AND 23;

SELECT *
FROM student
WHERE dept_id IN(1,2);

SELECT *
FROM student
WHERE email IS NOT NULL;

SELECT *
FROM student
WHERE dept_id NOT IN(3);

SELECT dept_id,SUM(age)
FROM student
GROUP BY dept_id;