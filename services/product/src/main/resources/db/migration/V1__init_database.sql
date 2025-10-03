create table if not exists category
(
    id integer not null primary key,
    name varchar(255),
    description varchar(255)
);

create table if not exists product
(
    id integer not null primary key,
    description varchar(255),
    name varchar(255),
    available_quantity double precision not null,
    price numeric(38, 2),
    category_id integer
        constraint fk1Kadri references category(id)
);

create sequence if not exists category_seq start with 1 increment by 1;
create sequence if not exists product_seq start with 1 increment by 1;
