SET lc_messages = 'C';

DROP TABLE IF EXISTS authorities;

create table authorities(
  userName varchar(128) not null,
  authority varchar(128) not null
);
insert into users (userName,password,enabled) VALUES 
('admin','admin',true);

insert into authorities (userName,authority) VALUES('admin','ROLE_ADMIN');

Create Unique index idx_auth_username on authorities(userName,authority);




