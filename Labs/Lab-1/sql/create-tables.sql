create table if not exists person
(
    id     serial primary key,
    name   varchar(50) not null,
    gender varchar(20) not null,
    age    integer
);

create table if not exists city
(
    id   serial primary key,
    name varchar(50) not null
);

create table if not exists events
(
    id           serial primary key,
    description text    not null,
    person_id    integer
        references person (id),
    city_id      integer not null
        references city (id)
);

create table if not exists atmosphere
(
    city_id     integer primary key
        references city (id),
    status      text,
    temperature float
);

create table if not exists building
(
    id      serial primary key ,
    type    varchar(50) not null,
    address  varchar(50) not null UNIQUE,
    city_id integer
        references city (id)
);