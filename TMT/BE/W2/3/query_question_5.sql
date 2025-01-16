SELECT 
	ci.city_name,  
    e.first_name AS employee_name,
    TIMEDIFF(cd.end_time, cd.start_time) AS duration  
FROM 
	call_detail cd  
JOIN 
	employee e ON cd.employee_id = e.id  
JOIN 
	customer cu ON cd.customer_id = cu.id  
JOIN 
	city ci ON cu.city_id = ci.id  
WHERE 
	TIMEDIFF(cd.end_time, cd.start_time) < '00:06:00' AND TIMEDIFF(cd.end_time, cd.start_time) > '00:02:00'
ORDER BY 
	duration DESC;  