USE `W2-2-2`;

CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255),
    city VARCHAR(255)
);


CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    total_amount FLOAT,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

INSERT INTO customer (id, customer_name, city)
VALUES (1, 'Alice', 'New York'),
       (2, 'Bob', 'Los Angeles'),
       (3, 'Charlie', 'Chicago');

INSERT INTO orders (id, customer_id, order_date, total_amount)
VALUES (1, 1, '2024-01-01', 200.00),
       (2, 1, '2024-01-10', 300.00),
       (3, 2, '2024-01-05', 150.00),
       (4, 2, '2024-01-15', 250.00),
       (5, 3, '2024-01-20', 100.00);

SELECT 
	c.customer_name
FROM customer c
JOIN orders o ON c.id = o.customer_id
GROUP BY 
    c.id
HAVING 
    SUM(o.total_amount) > (
        SELECT 
            AVG(total_per_customer)
        FROM 
            (SELECT 
                customer_id, SUM(total_amount) AS total_per_customer
             FROM 
                orders
             GROUP BY 
                customer_id) AS subquery
    );