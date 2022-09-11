use furama;
-- select af.* from attach_facility af
--  left join contract_detail ctdt on ctdt.attach_facility_id = af.attach_facility_id
--  left join contract ct on ct.contract_id = ctdt.contract_id
--  left join customer cu on cu.customer_id = ct.customer_id 
--  where cu.customer_id= 1;


DELIMITER //
CREATE PROCEDURE getAttachFacility
(IN customerId INT(11))
BEGIN
select af.* from attach_facility af
 left join contract_detail ctdt on ctdt.attach_facility_id = af.attach_facility_id
 left join contract ct on ct.contract_id = ctdt.contract_id
 left join customer cu on cu.customer_id = ct.customer_id 
 where cu.customer_id= customerId;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getCustomer
(IN customerId INT(11))	employeecustomer
BEGIN
select * from customer 
where customer_id = customerId;
END //
DELIMITER ;
