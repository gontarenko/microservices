create table if not exists customer (
    id serial primary key not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    email varchar(255) not null unique
);