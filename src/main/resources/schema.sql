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

CREATE INDEX car_detail_name ON car_detail(name);
CREATE INDEX car_detail_manufacture_name ON car_detail(manufacture_name);
CREATE INDEX car_detail_model ON car_detail(model);
CREATE INDEX car_detail_color ON car_detail(color);
CREATE INDEX car_detail_manufacture_year ON car_detail(manufacture_year);

