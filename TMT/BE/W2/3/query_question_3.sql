SELECT   
    co.country_name_eng,  
    COUNT(cd.id) AS calls  
FROM   
    call_detail cd
JOIN   
    customer cu ON cd.customer_id = cu.id  
JOIN   
    city ci ON cu.city_id = ci.id  
JOIN   
    country co ON ci.country_id = co.id  
GROUP BY   
    co.country_name_eng  
ORDER BY   
    calls DESC;