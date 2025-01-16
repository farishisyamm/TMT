USE `w2-4-1`;
CREATE TABLE customer (
	id INT PRIMARY KEY,
	customer_name VARCHAR(255),
	phone VARCHAR(255)
);

CREATE TABLE product (
	id INT PRIMARY KEY,
	product_name VARCHAR(255),
	price DECIMAL
);

CREATE TABLE orders (
	id INT PRIMARY KEY,
	customer_id INT,
	order_date DATE,
	FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE order_details (
	id INT PRIMARY KEY,
	order_id INT,
	product_id INT,
	quantity INT,
	FOREIGN KEY (order_id) REFERENCES orders(id),
	FOREIGN KEY (product_id) REFERENCES product(id)
);


INSERT INTO customer (id, customer_name, phone)
VALUES (1, 'Alice', '123-456-7890'),
       (2, 'Bob', '987-654-3210'),
       (3, 'Charlie', '555-123-4567'),
       (4, 'Fawwaz', '0896-333-4444');

INSERT INTO product (id, product_name, price)
VALUES (1, 'Laptop', 1000.00),
       (2, 'Smartphone', 700.00),
       (3, 'Headphones', 150.00),
       (4, 'Mouse', 50.00),
       (5, 'Keyboard', 70.00);

INSERT INTO orders (id, customer_id, order_date)
VALUES (1, 1, '2023-01-15'),
       (2, 2, '2023-02-10'),
       (3, 3, '2023-02-20'),
	   (4, 1, '2023-02-20')

INSERT INTO order_details (id, order_id, product_id, quantity)
VALUES (1, 1, 1, 1),
       (2, 1, 3, 2),
       (3, 2, 2, 1),
       (4, 2, 4, 3),
       (5, 4, 1, 1)

-- 1
SELECT 
    p.id AS product_id,
    p.product_name,
    COALESCE(SUM(od.quantity), 0) AS total_ordered
FROM 
    product p
LEFT JOIN 
    order_details od ON p.id = od.product_id
GROUP BY 
    p.id

-- 2
SELECT 
    c.customer_name,
    c.phone,
    p.product_name,
    COALESCE(SUM(od.quantity), 0) AS total_ordered
FROM 
    product p
LEFT JOIN 
    order_details od ON p.id = od.product_id
LEFT JOIN 
    orders o ON od.order_id = o.id
LEFT JOIN 
    customer c ON o.customer_id = c.id
WHERE 
    p.product_name = "Keyboard"
GROUP BY
	c.id

-- 3
SELECT 
    o.id AS order_id,
    o.order_date,
    c.customer_name,
    od.product_id AS product_id,
    od.quantity AS quantity
FROM 
    orders o
LEFT JOIN 
    customer c ON o.customer_id = c.id
LEFT JOIN 
    order_details od ON o.id = od.order_id;

-- 4
SELECT 
    c.customer_name,
    p.product_name,
    od.quantity,
    o.order_date
FROM 
    customer c
LEFT JOIN 
    orders o ON c.id = o.customer_id
LEFT JOIN 
    order_details od ON o.id = od.order_id
LEFT JOIN
	product p ON od.product_id = p.id
ORDER BY
	o.order_date IS NULL DESC, quantity IS NULL DESC

-- 5
SELECT 
    p.id AS product_id,
    p.product_name,
    COALESCE(SUM(od.quantity), 0) AS total_ordered
FROM 
    product p
LEFT JOIN 
    order_details od ON p.id = od.product_id
GROUP BY 
    p.id, p.product_name, p.price
HAVING 
    CASE 
        WHEN (SELECT COUNT(*) FROM order_details) > 0 THEN 
            SUM(od.quantity) = (
                SELECT MAX(total_ordered)
                FROM (
                    SELECT 
                        p.id,
                        COALESCE(SUM(od.quantity), 0) AS total_ordered
                    FROM 
                        product p
                    LEFT JOIN 
                        order_details od ON p.id = od.product_id
                    GROUP BY 
                        p.id
                ) AS subquery
            )
        ELSE 
            TRUE
    END;