USE `W2-2-3`;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255),
    username VARCHAR(255),
    active boolean
);

CREATE TABLE user_profile (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fullname VARCHAR(255),
    address VARCHAR(255),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE category (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255)
);

CREATE TABLE book (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255),
	author VARCHAR(255),
	category_id INT,
	FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE student_books (
    user_id INT,
    book_id INT,
    borrow_date DATE,
    return_date DATE,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (book_id) REFERENCES book(id)
);

INSERT INTO users (id, username, email, active)
VALUES 
(1, 'PinkyFoxie', 'pinkyFoxie@yopmail.com', 1),
(2, 'Winn', 'winn@yopmail.com', 1),
(3, 'Silences', 'silencer@yopmail.com', 1),
(4, 'Destroyer', 'nerd@yopmail.com', 0);

INSERT INTO user_profile (id, fullname, address, user_id)
VALUES
(3, 'Julinar', 'Bendungan Hilir, Tanah Abang', 1),
(4, 'Fajar Rifai', 'Bekasi', 2),
(5, 'Tirta Prana Bhakti', NULL, 3);

INSERT INTO category (id, name)
VALUES (1, 'Science'), (2, 'History'), (3, 'Fiction');

INSERT INTO book (id, name, author, category_id)
VALUES 
(1, 'The Hobbit', 'J.R.R. Tolkien', 1),
(2, 'A Brief History of Time', 'Stephen Hawking', 2),
(3, 'Sapiens', 'Yuval Noah Harari', NULL),
(4, 'Asal usul Bendungan Hilir', 'Julinar', 3),
(5, 'Jafar Allahuakbar', 'Yono', NULL);

INSERT INTO student_books (user_id, book_id, borrow_date, return_date)
VALUES 
(1, 1, '2025-01-01', '2025-01-10'),
(1, 2, '2025-01-09', NULL),
(2, 3, '2025-01-05', '2025-01-11'),
(3, 5, '2025-01-01', NULL);


-- 1
SELECT
	u.id AS userId,
    up.fullname AS fullname,
    u.username AS username,
    u.email AS email,
    up.address AS address,
    u.active as statusAccount
FROM
	users u
LEFT JOIN user_profile up ON u.id = user_id

-- 2
SELECT
	u.id AS user_id,
    up.fullname AS user_fullname,
    u.username AS user_username,
    u.email AS user_email,
    COUNT(sb.book_id) AS totalBook
FROM
	users u
JOIN 
    user_profile up ON u.id = up.user_id
LEFT JOIN 
    student_books sb ON u.id = sb.user_id
WHERE 
    u.active = 1
GROUP BY 
    u.id, up.fullname, u.username, u.email;
    

-- 3
SELECT
	u.id AS user_id,
    up.fullname AS user_fullname,
    u.username AS user_username,
    u.email AS user_email,
    b.name AS book_name,
    c.name AS book_category
FROM
	users u
JOIN 
    user_profile up ON u.id = up.user_id
JOIN 
    student_books sb ON u.id = sb.user_id
JOIN
    book b ON sb.book_id = b.id
LEFT JOIN
    category c ON b.category_id = c.id
WHERE 
     sb.return_date IS NULL; 
    
-- 4
SELECT 
    u.id AS user_id,
    up.fullname AS user_fullname,
    u.username AS user_username,
    u.email AS user_email,
    b.name AS book_name,
    sb.borrow_date AS book_borrow_date
FROM
    users u
JOIN
    user_profile up ON u.id = up.user_id
JOIN 
    student_books sb ON u.id = sb.user_id
JOIN
    book b ON sb.book_id = b.id
WHERE 
    b.category_id IS NULL;

-- 5
SELECT
    u.id AS user_id,
    up.fullname AS user_fullname,
    u.username AS user_username,
    u.email AS user_email,
    b.name AS book_name,
    DATEDIFF(IFNULL(sb.return_date, NOW()), sb.borrow_date) AS days
FROM
    users u
JOIN
    user_profile up ON u.id = up.user_id
JOIN
    student_books sb ON u.id = sb.user_id
JOIN
    book b ON sb.book_id = b.id
WHERE
    DATEDIFF(IFNULL(sb.return_date, NOW()), sb.borrow_date) > 7;




	