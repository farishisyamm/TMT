
CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255),
    city VARCHAR(255)
);

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255),
    category VARCHAR(255),
    price FLOAT
);

CREATE TABLE sales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    product_id INT,
    sale_date DATE,
    quantity INT,
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

INSERT INTO customer (id, customer_name, city) VALUES
(1, 'Razan', 'Aceh'),
(2, 'Adil', 'Jakarta'),
(3, 'Kevin', 'Purwokerto'),
(4, 'Gilang', 'Karawang'),
(5, 'Faris', 'Jakarta');

INSERT INTO product (id, product_name, category, price) VALUES
(1, 'Laptop', 'Elektronik', 15000000),
(2, 'Smartphone', 'Elektronik', 8000000),
(3, 'Meja', 'Furnitur', 500000),
(4, 'Kursi', 'Furnitur', 300000),
(5, 'AC', 'Elektronik', 2000000),
(6, 'Lemari', 'Furnitur', 800000),
(7, 'PlayStation 2', 'Elektronik', 2000000);

INSERT INTO sales (id, customer_id, product_id, sale_date, quantity) VALUES
(1, 1, 1, '2025-01-01', 1), -- Razan beli 1 laptop
(2, 1, 2, '2025-01-01', 2), -- Razan beli 2 smartphone
(3, 2, 3, '2025-01-02', 4), -- Adil beli 4 meja
(4, 2, 4, '2025-01-02', 6), -- Adil beli 6 kursi
(5, 3, 5, '2025-01-03', 3), -- Kevin beli 3 AC
(6,	1, 2, '2025-01-04', 1), -- Razan beli 1 smartphone
(7,	4, 3, '2025-01-05',	2), -- Gilang beli 2 meja
(8,	5, 2, '2025-01-05',	1); -- Faris beli 1 smartphone

-- 1
SELECT
	c.id AS customer_id,
    c.customer_name,
    SUM(s.quantity * p.price) AS total_sales
FROM customer c
JOIN sales s ON c.id = s.customer_id
JOIN product p ON p.id = s.product_id
WHERE p.category = 'Elektronik'
GROUP BY c.id, c.customer_name

-- 2
SELECT 
    p.id AS product_id,
    p.product_name,
    p.category AS product_category
FROM product p
WHERE p.id NOT IN (
    SELECT DISTINCT s.product_id
    FROM sales s
);

-- 3
SELECT 
    c.city AS customer_city,
    SUM(s.quantity) AS total_units_sold
FROM customer c
JOIN sales s ON c.id = s.customer_id
GROUP BY c.city
ORDER BY total_units_sold DESC
LIMIT 1;