CREATE DATABASE IF NOT EXISTS employeew3;  
  
USE employeew3;  
  
CREATE TABLE IF NOT EXISTS employees (  
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  
    name VARCHAR(255) NOT NULL,  
    position VARCHAR(255) NOT NULL,
    salary DOUBLE NOT NULL
);  

INSERT INTO employees (name, position, salary) 
VALUES 
('Faris', 'Backend Engineer', 50000000),
('Razan', 'Backend Engineer', 50000000),
('Adil', 'Frontend Engineer', 50000000),
('Kevin', 'Mobile Engineer', 50000000),
('Gilang', 'QA Engineer', 50000000);
