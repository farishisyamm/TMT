
CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    city VARCHAR(255)
);

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255),
    category VARCHAR(255),
    price DECIMAL
);

CREATE TABLE `order` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE order_detail (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (order_id) REFERENCES `order`(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

INSERT INTO customer (id, name, city) VALUES
(1, 'Razan', 'Aceh'),
(2, 'Adil', 'Jakarta'),
(3, 'Kevin', 'Purwokerto'),
(4, 'Gilang', 'Karawang');

INSERT INTO product (id, product_name, category, price) VALUES
(1, 'Laptop', 'Elektronik', 15000000),
(2, 'Smartphone', 'Elektronik', 8000000),
(3, 'Meja', 'Furnitur', 500000),
(4, 'Kursi', 'Furnitur', 300000),
(5, 'AC', 'Elektronik', 2000000);

INSERT INTO `order` (id, customer_id, order_date) VALUES
(1, 1, '2025-01-01'),
(2, 2, '2025-01-02'),
(3, 3, '2025-01-03'),
(4, 1, '2025-01-04'),
(5, 4, '2025-01-05');

INSERT INTO order_detail (id, order_id, product_id, quantity) VALUES
(1, 1, 1, 1), -- Razan beli 1 laptop
(2, 1, 2, 2), -- Razan beli 2 smartphone
(3, 2, 3, 4), -- Adil beli 4 meja
(4, 2, 4, 6), -- Adil beli 6 kursi
(5, 3, 5, 3), -- Kevin beli 3 AC
(6, 4, 2, 1), -- Razan beli 1 smartphone
(7, 5, 3, 2); -- Gilang beli 2 meja

-- 1
SELECT 
    c.name AS customer_name,
    c.city AS customer_city,
    SUM(od.quantity) AS total_products_bought,
    SUM(od.quantity * p.price) AS total_spent
FROM customer c
JOIN `order` o ON c.id = o.customer_id
JOIN order_detail od ON o.id = od.order_id
JOIN product p ON od.product_id = p.id
GROUP BY c.id, c.name, c.city
ORDER BY total_spent DESC;

-- 2
SELECT 
    c.name AS customer_name,
    c.city AS customer_city
FROM customer c
WHERE c.id NOT IN (
    SELECT DISTINCT o.customer_id
    FROM `order` o
    JOIN order_detail od ON o.id = od.order_id
    JOIN product p ON od.product_id = p.id
    WHERE p.category = 'Elektronik'
);

-- 3
SELECT 
    p.product_name,
    SUM(od.quantity) AS total_units_sold,
    SUM(od.quantity * p.price) AS total_revenue
FROM product p
JOIN order_detail od ON p.id = od.product_id
GROUP BY p.id, p.product_name
HAVING total_units_sold > 5
ORDER BY total_revenue DESC;