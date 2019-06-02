drop table if exists machine;
create table machine (
    id int not null auto_increment primary key,
    serial_number varchar(64),
    kind varchar(32),
    bmc_ip varchar(32),
    business_ip varchar(128),
    address varchar(2048),
    owner varchar(64),
    user varchar(64),
    usages varchar(1024)
) charset=utf8;

drop table if exists virtual_machine;
create table virtual_machine (
    machine_id int,
    ip not null varchar(128),
    usages varchar(1024),
    index(machine_id)
) charset=utf8;