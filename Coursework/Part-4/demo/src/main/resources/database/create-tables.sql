create table if not exists role
(
    id   serial primary key,
    role varchar(20) not null unique
);

create table if not exists balance
(
    id        serial primary key,
    value     float
        CHECK (value >= 0),
    role_id   int not null
        references role (id)
);

create table if not exists client
(
    id         serial primary key,
    name       varchar(50) not null,
    mail       varchar(50) not null unique,
    phone      varchar(20) not null unique,
    gender     varchar(20) not null,
    role_id    int         not null
        references role (id),
    balance_id int         not null unique
        references balance (id)
);

create table if not exists legal_info
(
    id               serial primary key,
    full_description text   not null,
    contact_phone    varchar(20),
    mail             varchar(50) not null unique,
    TIN              varchar(20) not null unique
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

create table if not exists class
(
    id         serial      not null primary key,
    name       varchar(32) not null,
    date_of    date        not null,
    start_time time        not null,
    end_time   time        not null,
    amount     float       not null
        CHECK ( amount >= 0 ),
    pos_id     int         not null
        references pos (id)
);

create table if not exists booking
(
    id        serial not null primary key,
    client_id int    not null
        references client (id),
    class_id  int    not null
        references class (id)
);

create table if not exists instructor
(
    id     serial      not null primary key,
    name   varchar(50) not null,
    mail   varchar(50) not null unique,
    phone  varchar(20) not null unique,
    gender varchar(20) not null
);

create table if not exists instructor_class_relation
(
    id            serial not null primary key,
    instructor_id int    not null
        references instructor (id),
    class_id      int    not null
        references class (id)
);

create table if not exists classifier
(
    id               serial      not null primary key,
    classifier_value varchar(50) not null,
    classifier_name  text        not null
);

create table if not exists class_classifier_relation
(
    id            serial not null primary key,
    class_id      int    not null
        references class (id),
    classifier_id int    not null
        references classifier (id)
);

create table if not exists instructor_classifier_relation
(
    id            serial not null primary key,
    instructor_id int    not null
        references instructor (id),
    classifier_id int    not null
        references classifier (id)
);

create table if not exists pos_classifier_relation
(
    id            serial not null primary key,
    pos_id        int    not null
        references pos (id),
    classifier_id int    not null
        references classifier (id)
);



-- Вспомогательная таблица
create table if not exists ping
(
  id                serial not null primary key,
  time_of_ping      time not null
);
