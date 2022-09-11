use furama;

delimiter //
drop procedure if exists `total` //
create procedure total()
begin
SELECT 
    ct.contract_id AS id,
    f.facility_name AS facilityName,
    c.customer_name AS customerName,
    ct.start_date AS startDate,
    ct.end_date AS endDate,
    ct.deposit,
    f.cost + IFNULL(SUM(af.price * ctdt.quantity), 0) AS total
FROM
    contract ct
        LEFT JOIN
    contract_detail ctdt ON ctdt.contract_id = ct.contract_id
        LEFT JOIN
    attach_facility af ON af.attach_facility_id = ctdt.attach_facility_id
        LEFT JOIN
    customer c ON c.customer_id = ct.customer_id
        LEFT JOIN
    facility f ON f.facility_id = ct.facility_id
GROUP BY ct.contract_id;
end //
delimiter ;
 
 
 select af.*
from attach_facility af
left join contract_detail ctdt on ctdt.attach_facility_id= af.attach_facility_id
left join contract ct on ct.contract_id = ctdt.contract_id
where ct.contract_id =2;
-- group by ct.contract_id;
