
create database if not exists `bike_finder_api`;


create table `officer` (
	`id` int (11) not null auto_increment,
    `name` varchar (128) default null,
    `is_available` boolean default null,
	`last_mission` bigint default null,
    primary key(`id`)
    ) engine=InnoDB auto_increment=1 default charset=utf8;
    
    
    create table `client` (
	`id` int (11) not null auto_increment,
    `name` varchar (128) default null,
    `nation_code` varchar(45) default null,
	`phone_number` varchar(45) default null,
    primary key(`id`)
    ) engine=InnoDB auto_increment=1 default charset=utf8;
    
    
    
create table `case_table`(
	`id` int(11) not null auto_increment,
    `description` mediumtext default null,
    `isAlive` Boolean default null,
    `start_date` bigint default null ,
    `end_date` bigint default null ,
    `client_id` int(11) default null,
    `officer_id` int(11) default null,
    primary key(`id`),
    key `FK_CLIENT_idx` (`client_id`),
    constraint `FK_CLIENT` foreign key (`client_id`) references
    `client` (`id`) on delete no action on update no action,
    key `FK_OFFICER_idx` (`officer_id`),
    constraint `FK_OFFICER` foreign key (`officer_id`) references
    `officer` (`id`) on delete no action on update no action
    )engine=InnoDB auto_increment=1 default charset=utf8;
    
