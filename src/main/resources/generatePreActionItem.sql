create table connections
(
  id int auto_increment
    primary key,
  linkedIn_id varchar(45) not null,
  interests varchar(5000) null,
  notes varchar(5000) null,
  user_id int not null,
  first_name varchar(50) null,
  last_name varchar(50) null,
  company varchar(255) null
)
;

create index fk_connections_user_idx
  on connections (user_id)
;

create table role
(
  id int auto_increment
    primary key,
  role_name varchar(45) null,
  email varchar(45) null,
  user_id int null,
  constraint email_UNIQUE
  unique (email)
)
;

create index role_user_id_fk
  on role (user_id)
;

create table user
(
  id int auto_increment
    primary key,
  first_name varchar(25) null,
  last_name varchar(30) null,
  email varchar(50) null,
  password varchar(30) null,
  constraint users_user_name_uindex
  unique (email)
)
;

alter table connections
  add constraint fk_connections_user
foreign key (user_id) references user (id)
;

alter table role
  add constraint role_user_id_fk
foreign key (user_id) references user (id)
;

