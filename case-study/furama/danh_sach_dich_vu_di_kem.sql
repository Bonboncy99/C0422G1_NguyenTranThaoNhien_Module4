SELECT * FROM furama.contract;


selecemployeet af.* from attach_facility af
left join contract_detail ctdt on ctdt.attach_facility_id = af.attach_facility_id
left join contract ct on ct.contract_id = ctdt.contract_id
left join customer cu on cu.customer_id = ct.customer_id 
where cu.customer_id=1;