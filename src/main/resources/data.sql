--create table person
--(
--    id integer not null,
--    name varchar(255) not null,
--    location varchar(255),
--    birth_date timestamp,
--    primary key(id)
--);                //Table is auto created by schema update in hibernate

insert into person
(id,name,location,birth_date)
values
(101,'Shruti','Satna','2002-02-02 15:20:30');

insert into person
(id,name,location,birth_date)
values
(102,'Swati','MP','2002-02-02 15:20:30');

insert into person
(id,name,location,birth_date)
values
(103,'Shiv','Unchehara','2002-02-02 15:20:30');