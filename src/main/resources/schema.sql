DROP TABLE car_detail;

create table car_detail
(
    id integer not null auto_increment,
    name varchar(50) not null,
    manufacture_name varchar(50) not null,
    model varchar(50) not null ,
    manufacture_year integer not null,
    color varchar(50) not null,
    primary key(id)
);