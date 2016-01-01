create table member_tb(
	email VARCHAR2(255) PRIMARY KEY,
	name VARCHAR2(30) NOT NULL,
	pwd VARCHAR2(50) NOT NULL,
	location VARCHAR2(1000) NOT NULL,
	transportation VARCHAR2(255) check(transportation in ('transit', 'driving')) NOT NULL
);

create view member_view(email, name, pwd, location, transportation)
as select * from member_tb;

create view member_p_view(email, pwd, name)
as select email, pwd, name from member_tb with check option;

create view member_o_view(email, name, location, transportation) 
as select email, name, location, transportation from member_tb with check option;

CREATE TABLE friend_tb(
	email VARCHAR2(255) NOT NULL,
	f_email VARCHAR2(255) NOT NULL,
	FOREIGN KEY(email) REFERENCES member_tb(email),
	FOREIGN KEY(f_email) REFERENCES member_tb(email)
);

create view friend_view(email, f_email)
as select * from friend_tb with check option;

create view friend_info_view(email, f_email, f_name, f_location, f_transportation) as
select f.email, f.f_email, m.name, m.location, m.transportation from friend_tb f, member_tb m
where f.f_email=m.email 
with read only;

create sequence group_sequence
increment by 1
start with 0
nomaxvalue
minvalue 0
nocycle;

create table group_tb(
	g_code NUMBER PRIMARY KEY,
	name VARCHAR2(255) NOT NULL
);

create view group_view
as select * from group_tb with check option;

create table g_participant_tb(
	g_code NUMBER NOT NULL,
	email VARCHAR2(255) NOT NULL,
	FOREIGN KEY(g_code) REFERENCES group_tb(g_code),
	FOREIGN KEY(email) REFERENCES member_tb(email)
);

create view g_participant_view(g_code, email)
as select * from g_participant_tb with check option;

create view g_participant_info_view(email, name, location, transportation, g_code, g_name)
as select g_p.email, m.name, m.location, m.transportation, g.g_code, g.name from g_participant_tb g_p, group_tb g, member_tb m
where g_p.g_code=g.g_code and g_p.email=m.email with read only;

create sequence event_sequence
increment by 1
start with 0
nomaxvalue
minvalue 0
nocycle;

create table event_tb(
	e_code NUMBER PRIMARY KEY,
	title VARCHAR2(255) NOT NULL,
	s_date VARCHAR2(50) NOT NULL,
	e_date VARCHAR2(50) NOT NULL,
	s_time VARCHAR2(50) NOT NULL,
	e_time VARCHAR2(50) NOT NULL,
	content VARCHAR2(4000) NOT NULL,
	place VARCHAR2(1000) NOT NULL
);

create view event_view
as select * from event_tb with check option;

create table e_participant_tb(
	e_code NUMBER NOT NULL,
	email VARCHAR2(255) NOT NULL,
	FOREIGN KEY(e_code) REFERENCES event_tb(e_code),
	FOREIGN KEY(email) REFERENCES member_tb(email)
);

create view e_participant_view
as select * from e_participant_tb with check option;

create view e_participant_info_view(e_code, email, title, s_date, e_date, s_time, e_time, content, place)
as select e_p.e_code, e_p.email, e.title, e.s_date, e.e_date, e.s_time, e.e_time, e.content, e.place 
from e_participant_tb e_p, event_tb e
where e_p.e_code=e.e_code with read only;





drop view e_participant_info_view;
drop view e_participant_view;
drop table e_participant_tb;
drop view event_view;
drop table event_tb;
drop sequence event_sequence;

drop view g_participant_info_view;
drop view g_participant_view;
drop table g_participant_tb;

drop view group_view;
drop table group_tb;
drop sequence group_sequence;

drop view friend_info_view;
drop view friend_view;
drop table friend_tb;

drop view member_o_view;
drop view member_p_view;
drop view member_view;
drop table member_tb;



select * from tab;
select * from user_sequences;