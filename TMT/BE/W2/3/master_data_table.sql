CREATE TABLE country (
	id INT AUTO_INCREMENT PRIMARY KEY,
	country_name VARCHAR(255) UNIQUE NOT NULL,
	country_name_eng VARCHAR(255) UNIQUE NOT NULL,
	country_code VARCHAR(8) UNIQUE NOT NULL
);

CREATE TABLE city (
	id INT AUTO_INCREMENT PRIMARY KEY,
	city_name VARCHAR(128) NOT NULL,
	lat DECIMAL(9,6) NOT NULL,
	lon DECIMAL(9,6) NOT NULL,
	country_id INT NOT NULL,
	FOREIGN KEY (country_id) REFERENCES country (id)
);

CREATE TABLE employee (
	id INT AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL
);

CREATE TABLE customer (
	id INT AUTO_INCREMENT PRIMARY KEY,
	city_id INT NOT NULL,
	customer_name VARCHAR(255) NOT NULL,
	customer_address VARCHAR(255) NOT NULL,
	next_call_date date,
	ts_inserted datetime NOT NULL,
	FOREIGN KEY (city_id) REFERENCES city(id)
);

CREATE TABLE call_outcome (
	id INT AUTO_INCREMENT PRIMARY KEY,
	outcome_text VARCHAR(128) NOT NULL
);

CREATE TABLE call_detail (
	id INT AUTO_INCREMENT PRIMARY KEY,
	employee_id INT NOT NULL,
	customer_id INT NOT NULL,
	start_time DATETIME NOT NULL,
	end_time DATETIME,
	call_outcome_id INT,
	FOREIGN KEY (employee_id) REFERENCES employee(id),
	FOREIGN KEY (customer_id) REFERENCES customer(id),
	FOREIGN KEY (call_outcome_id) REFERENCES call_outcome(id)
);

INSERT INTO country (id, country_name, country_name_eng, country_code) VALUES
(1, 'Deutschland', 'Germany', 'DEU'),
(2, 'Srbija', 'Serbia', 'SRB'),
(3, 'Hrvatska', 'Croatia', 'HRV'),
(4, 'United Stated of America', 'United Stated of America', 'USA'),
(5, 'Polska', 'Poland', 'POL'),
(6, 'Indonesia', 'Indonesia', 'INA');

INSERT INTO city (id, city_name, lat, lon, country_id) VALUES
(1, 'Berlin', 52.520008, 13.404954, 1),
(2, 'Belgrade', 44.787197, 20.457273, 2),
(3, 'Zagreb', 45.815399, 15.966568, 3),
(4, 'New York', 40.73061, -73.935242, 4),
(5, 'Los Angeles', 34.052235, -118.243683, 4),
(6, 'Warsaw', 52.237049, 21.017532, 5),
(7, 'Jakarta', -6.2, 106.816666, 6);

INSERT INTO employee (id, first_name, last_name) VALUES
(1, 'Thomas (Neo)', 'Anderson'),
(2, 'Agent', 'Smith');

INSERT INTO customer (id, customer_name, city_id, customer_address, next_call_date, ts_inserted) VALUES
(1, 'Jewelry Store', 4, 'Long Street 120', '2020-01-21', '2020-01-09 14:01:20'),
(2, 'Bakery', 1, 'Kurfürstendamm 25', '2020-02-21', '2020-01-09 17:52:15'),
(3, 'Café', 1, 'Tauentzienstraße 44', '2020-01-21', '2020-01-10 08:02:49'),
(4, 'Warkop', 7, 'BNI 46', '2020-01-21', '2020-01-10 08:02:49'),
(5, 'Restaurant', 3, 'Ulica lipa 15', '2020-01-21', '2020-01-10 09:20:21');

INSERT INTO call_outcome (id, outcome_text) VALUES
(1, 'call started'),
(2, 'finished - successfully'),
(3, 'finished - unsuccessfully');

INSERT INTO call_detail (id, employee_id, customer_id, start_time, end_time, call_outcome_id) VALUES  
(1, 1, 4, '2020-01-11 09:00:15', '2020-01-11 09:12:22', 2),  
(2, 1, 2, '2020-01-11 09:14:50', '2020-01-11 09:20:01', 2),  
(3, 2, 3, '2020-01-11 09:02:20', '2020-01-11 09:18:05', 3),  
(4, 1, 1, '2020-01-11 09:24:15', '2020-01-11 09:25:05', 3),  
(5, 1, 3, '2020-01-11 09:26:23', '2020-01-11 09:33:45', 2),  
(6, 1, 2, '2020-01-11 09:40:31', '2020-01-11 09:42:32', 2),  
(7, 2, 4, '2020-01-11 09:41:17', '2020-01-11 09:45:21', 2),  
(8, 1, 1, '2020-01-11 09:42:32', '2020-01-11 09:46:53', 3),  
(9, 2, 1, '2020-01-11 09:46:00', '2020-01-11 09:48:02', 2),  
(10, 2, 2, '2020-01-11 09:50:12', '2020-01-11 09:55:35', 2),  
(11, 2, 4, '2020-01-11 09:55:12', '2020-01-11 09:55:35', 3);  
