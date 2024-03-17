create table account
(
    id               int primary key,
    name             varchar(32) not null,
    amount           int         not null default 0,
    create_timestamp timestamp            default current timestamp,
    create_date      date                 default current date,
    create_time      time                 default current time
);

insert into account(id, name)
values (1, 'admin');