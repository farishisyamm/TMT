SELECT   
    co.country_name_eng,  
    ci.city_name,  
    cu.customer_name,  
    cd.start_time,  
    cd.end_time  
FROM   
    call_detail cd  
JOIN   
    customer cu ON cd.customer_id = cu.id  
JOIN   
    city ci ON cu.city_id = ci.id  
JOIN  
    country co ON ci.country_id = co.id
WHERE   
    cd.call_outcome_id = '3' 
ORDER BY country_name_eng
