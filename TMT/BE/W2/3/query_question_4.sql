SELECT 
	co.country_name,  
    TIMEDIFF(cd.end_time, cd.start_time) AS duration  
FROM 
	call_detail cd  
JOIN 
	customer cu ON cd.customer_id = cu.id  
JOIN 
	city ci ON cu.city_id = ci.id  
JOIN 
	country co ON ci.country_id = co.id  
WHERE 
	TIMEDIFF(cd.end_time, cd.start_time) > '00:02:00'
ORDER BY 
	duration DESC;  
