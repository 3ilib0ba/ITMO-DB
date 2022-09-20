create table if not exists balance_type
(
    id   serial primary key,
    type varchar(20) not null unique
);

create table if not exists balance
(
    id              serial primary key,
    value           float,
    balance_type_id int not null
        references balance_type (id),
    entity_id       int unique
);

create table if not exists role
(
    id   serial primary key,
    role varchar(20) not null unique
);

create table if not exists client
(
    id         serial primary key,
    name       varchar(50) not null,
    mail       varchar(50) not null,
    phone      varchar(20) not null,
    gender     varchar(20) not null,
    role_id    int         not null
        references role (id),
    balance_id int         not null unique
        references balance (id)
);

create table if not exists legal_info
(
    id               serial primary key,
    full_description text,
    contact_phone    varchar(20),
    mail             varchar(50) not null,
    TIN              varchar(20) not null
);

create table if not exists studio
(
    id            serial primary key,
    name          varchar(50) not null,
    description   text,
    role_id       int         not null
        references role (id),
    legal_info_id int         not null
        references legal_info (id),
    balance_id    int         not null
        references balance (id)
);

create table if not exists pos
(
    id            serial primary key,
    address       varchar(100) not null,
    working_hours varchar(50)  not null,
    studio_id     int          not null
        references studio (id)
);




