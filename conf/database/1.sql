create table em_user (
  user_id                   SERIAL not null,
  display_name              varchar(255),
  user_name					varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  mobile                    varchar(255),
  first_name                varchar(255),
  last_name                 varchar(255),
  gender                    varchar(255),
  age                       integer,
  role                      varchar(255),
  last_updated              timestamp,
  updated_by                varchar(255),
  created_by                varchar(255),
  date_created              timestamp,
constraint pk_em_user primary key (user_id));


create table person (
  id BIGINT NOT NULL PRIMARY KEY,
  name` TEXT NOT NULL
)

  
  
insert into em_user(display_name, user_name, email, password, mobile, first_name, last_name, gender, age, role, last_updated, updated_by, created_by, date_created) 
values('Venkatesh', 'venkateshv', 'venkatesh.vangala1989@gmail.com', 'password', '9642648488', 'Venkatesh', 'Kumar', 'Male', 26, 'Senior Developer', '2016-04-03 01:15:06', 'Venkatesh', 'Venkatesh', '2016-04-03 01:05:06');


insert into em_user(display_name, user_name, email, password, mobile, first_name, last_name, gender, age, role, last_updated, updated_by, created_by, date_created) 
values('Srinivas', 'srinivask', 'srinivas.kummari@imaginea.com', 'password', '9059086871', 'Srinivas', 'Kummari', 'Male', 26, 'Principle Engineer', '2016-04-03 01:15:06', 'Srinivas', 'Venkatesh', '2016-04-03 01:05:06');



insert into em_user(display_name, user_name, email, password, mobile, first_name, last_name, gender, age, role, last_updated, updated_by, created_by, date_created) 
values('Vinod', 'vinodk', 'vinod.kakarla@imaginea.com', 'password', '9030646406', 'Vinod', 'Kakarla', 'Male', 26, 'Principle Engineer', '2016-04-03 01:15:06', 'Vinod', 'Vinod', '2016-04-03 01:05:06');


insert into person values(1, "Person1");

insert into person values(2, "Person2");
