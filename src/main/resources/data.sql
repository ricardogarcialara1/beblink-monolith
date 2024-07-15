insert into blinker (username, name, password, role) values ('ricgarc', 'ricardo garcia', '$2a$10$eXgFYt5Sft2NU68BLDsDVOaoRQoC/xI.Ta9fjpTVA9FswmJYJMIkK', 'CUSTOMER');
insert into blinker (username, name, password, role) values ('admin', 'pepe botella', '$2a$10$eXgFYt5Sft2NU68BLDsDVOaoRQoC/xI.Ta9fjpTVA9FswmJYJMIkK', 'ADMINISTRATOR');

insert into business (name, latitude, longitude, address, c_address, zip_code, province_id) values ('Business Name 1', 40.712776, -74.005974, '123 Main St', 'Suite 100', '10001', 'NY');
insert into business (name, latitude, longitude, address, c_address, zip_code, province_id) values ('Business Name 2', 34.052235, -118.243683, '456 Elm St', 'Suite 200', '90001', 'CA');

insert into business_role (name, business_id) values ('Role Prueba', 1);
insert into business_role (name, business_id) values ('Role Test', 1);

insert into product (name, price, image) values ('Product Prueba', 10, 'image1.jpg');
insert into product (name, price, image) values ('Product Test', 20, 'image2.jpg');