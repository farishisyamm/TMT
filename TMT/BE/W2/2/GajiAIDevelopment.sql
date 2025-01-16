USE `W2-2-5`;

CREATE TABLE department (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dept_name VARCHAR(255),
    location VARCHAR(255)
);

CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    emp_name VARCHAR(255),
    dept_id INT,
    salary FLOAT,
    FOREIGN KEY (dept_id) REFERENCES department(id)
);

CREATE TABLE project (
    id INT AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(255),
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES department(id)
);


INSERT INTO department (id, dept_name, location)
VALUES (1, 'IT', 'New York'),
       (2, 'HR', 'Los Angeles'),
       (3, 'Finance', 'Chicago');

INSERT INTO employee (id, emp_name, dept_id, salary)
VALUES (1, 'Alice', 1, 80000),
       (2, 'Bob', 1, 75000),
       (3, 'Charlie', 2, 60000),
       (4, 'David', 2, 65000),
       (5, 'Eve', 3, 90000);

INSERT INTO project (id, project_name, dept_id)
VALUES (1, 'AI Development', 1),
       (2, 'Recruitment Portal', 2),
       (3, 'Budget Analysis', 3);

SELECT 
    e.emp_name AS employee_name,
    e.salary AS employee_salary,
    d.dept_name AS department_name
FROM 
    employee e
JOIN 
    department d ON e.dept_id = d.id
JOIN 
    project p ON d.id = p.dept_id
WHERE 
    p.project_name = 'AI Development'
    AND e.salary > (
        SELECT 
            AVG(e2.salary)
        FROM 
            employee e2
        WHERE 
            e2.dept_id = e.dept_id
    );

