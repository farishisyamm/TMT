USE `W2-2-4`;

CREATE TABLE supplier (
    id INT AUTO_INCREMENT PRIMARY KEY,
    supplier_name VARCHAR(255),
    city VARCHAR(255)
);

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255),
    category VARCHAR(255),
    price FLOAT,
    supplier_id INT,
    FOREIGN KEY (supplier_id) REFERENCES supplier(id)
);

CREATE TABLE `order` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    order_date DATE,
    quantity INT,
    FOREIGN KEY (product_id) REFERENCES product(id)
);


INSERT INTO supplier (id, supplier_name, city)
VALUES (1, 'PT Elektronik Jaya', 'Jakarta'),
       (2, 'CV Rumah Sejahtera', 'Bandung'),
       (3, 'UD Perkakas Nusantara', 'Surabaya');

INSERT INTO product (id, product_name, category, price, supplier_id)
VALUES (1, 'Smartphone', 'Elektronik', 4000000, 1),
       (2, 'Laptop', 'Elektronik', 10000000, 1),
       (3, 'Blender', 'Peralatan Rumah', 800000, 2),
       (4, 'Kipas Angin', 'Peralatan Rumah', 500000, 2),
       (5, 'Tang', 'Perkakas', 150000, 3),
       (6, 'Obeng', 'Perkakas', 50000, 3);

INSERT INTO `order` (id, product_id, order_date, quantity)
VALUES (1, 1, '2024-12-01', 3),
       (2, 2, '2024-12-02', 1),
       (3, 3, '2024-12-03', 5),
       (4, 5, '2024-12-04', 10);

-- 1
SELECT
    s.supplier_name,
    s.city AS supplier_city,
    SUM(p.price * o.quantity) AS total_value
FROM
    supplier s
JOIN
    product p ON s.id = p.supplier_id
JOIN
    `order` o ON p.id = o.product_id
WHERE
    p.category = 'Elektronik'
GROUP BY
    s.id, s.supplier_name, s.city
HAVING
    total_value > 10000000;

-- 2
SELECT
    p.id AS product_id,
    p.product_name,
    p.category AS product_category
FROM
    product p
LEFT JOIN
    `order` o ON p.id = o.product_id
WHERE
    o.id IS NULL;

-- 3
SELECT
    p.category,
    SUM(o.quantity) AS total_quantity
FROM
    product p
JOIN
    `order` o ON p.id = o.product_id
GROUP BY
    p.category;
