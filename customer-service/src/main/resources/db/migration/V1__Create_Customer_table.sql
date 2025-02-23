create sequence customer_id_seq
    start with 1
    increment by 1
    no minvalue
    maxvalue 2147483647
    cache 1;

create table customer (
    id integer not null default nextval('customer_id_seq'),
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255),
    primary key (id)
);

alter sequence customer_id_seq owned by customer.id;