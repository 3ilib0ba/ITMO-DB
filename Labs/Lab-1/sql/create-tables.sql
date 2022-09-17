create table if not exists person
(
    id     integer PRIMARY KEY,
    name   varchar(50) not null,
    gender varchar(20) not null,
    age    integer
);

create table if not exists city
(
    id   integer PRIMARY KEY,
    name varchar(50) not null
);

create table if not exists events
(
    id           integer PRIMARY KEY,
    description text    not null,
    person_id    integer
        references person (id),
    city_id      integer not null
        references city (id)
);

create table if not exists atmosphere
(
    city_id     integer PRIMARY KEY
        references city (id),
    status      text,
    temperature float
);

create table if not exists building
(
    id      integer PRIMARY KEY,
    type    varchar(50) not null,
    address  varchar(50) not null UNIQUE,
    city_id integer
        references city (id)
);