CREATE TABLE blinker (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    name VARCHAR(100),
    password VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL
);

insert into blinker (username, name, password, role) values ('ricgarc', 'ricardo garcia', '$2a$10$eXgFYt5Sft2NU68BLDsDVOaoRQoC/xI.Ta9fjpTVA9FswmJYJMIkK', 'CUSTOMER');
insert into blinker (username, name, password, role) values ('admin', 'pepe botella', '$2a$10$eXgFYt5Sft2NU68BLDsDVOaoRQoC/xI.Ta9fjpTVA9FswmJYJMIkK', 'ADMINISTRATOR');
