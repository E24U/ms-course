create table course
(
    id serial primary key ,
    name varchar (444) not null unique,
    description varchar (2000) not null
);
