create table account
(
    id          int primary key,
    name        varchar(32) not null,
    amount      int         not null default 0,
    create_date timestamp            default current timestamp
);

insert into account(id, name)
values (1, 'admin');