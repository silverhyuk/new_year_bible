

drop user `nyb-user`;
create database nyb_db;

create user 'nyb_user'@'localhost' identified by 'nyb-user000';
create user 'nyb_user'@'%' identified by 'nyb-user000';

grant all privileges on nyb_db.* to nyb_user@'localhost';
grant all privileges on nyb_db.* to nyb_user@'%';

use nyb_db;
create table member (                        id bigint not null auto_increment,
                        created datetime,
                        updated datetime,
                        image varchar(50),
                        name varchar(20),
                        password varchar(64),
                        primary key (id)
) engine=InnoDB