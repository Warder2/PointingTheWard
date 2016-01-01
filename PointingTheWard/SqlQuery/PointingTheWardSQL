create table member_tb(
	email VARCHAR2(255) PRIMARY KEY,
	name VARCHAR2(30) NOT NULL,
	pwd VARCHAR2(50) NOT NULL,
	location VARCHAR2(1000) NOT NULL,
	transportation VARCHAR2(255) check(transportation in ('transit', 'driving')) NOT NULL
);
insert into member_tb(email, name, pwd, location, transportation) 
values('email', 'name', 'pwd', 'location', 'transit');
insert into member_tb(email, name, pwd, location, transportation) 
values('email1', 'name1', 'pwd1', 'location1', 'transit');
insert into member_tb(email, name, pwd, location, transportation) 
values('email2', 'name2', 'pwd2', 'location2', 'driving');

select * from member_tb;
select * from member_tb where email='email';
select email, name from member_tb where email='email';

delete from member_tb where email = 'email';

update member_tb 
set name='name1', pwd='pwd1', location ='location1', transportation='driving'
where email='email';

//member views
<!-----------------------------------------!>
create view member_view(email, name, pwd, location, transportation)
as select * from member_tb;

insert into member_view(email, name, pwd, location, transportation) 
values('email', 'name', 'pwd', 'location', 'transit');
insert into member_view(email, name, pwd, location, transportation) 
values('email1', 'name1', 'pwd1', 'location1', 'transit');
insert into member_view(email, name, pwd, location, transportation) 
values('email2', 'name2', 'pwd2', 'location2', 'driving');

select * from member_view;
select * from member_view where email='email';
select email, name from member_view where email='email';

delete from member_view where email = 'email';

update member_view 
set name='name1', pwd='pwd1', location ='location1', transportation='driving'
where email='email';

<!-----------------------------------------!>
create view member_p_view(email, pwd, name)
as select email, pwd, name from member_tb with check option;

select * from member_p_view;
select * from member_p_view where email='email'and pwd='pwd';

update member_p_view set name='name1', pwd='pwd1' where email='email';

<!-----------------------------------------!>
create view member_o_view(email, name, location, transportation) 
as select email, name, location, transportation from member_tb with check option;

select * from member_view where email='email';



//friend table
CREATE TABLE friend_tb(
	email VARCHAR2(255) NOT NULL,
	f_email VARCHAR2(255) NOT NULL,
	FOREIGN KEY(email) REFERENCES member_tb(email),
	FOREIGN KEY(f_email) REFERENCES member_tb(email)
);

//friend views
<!-----------------------------------------!>
create view friend_view(email, f_email)
as select * from friend_tb with check option;

insert into friend_view(email, f_email) values('email', 'email2');
insert into friend_view(email, f_email) values('email', 'email1');

select * from friend_view;
select * from friend_view where email='email';

delete from friend_view where email='email';
delete from friend_view where email='email' and f_email='email2';

create view friend_info_view(email, f_email, f_name, f_location, f_transportation) as
select f.email, f.f_email, m.name, m.location, m.transportation from friend_tb f, member_tb m
where f.f_email=m.email 
with read only;

select * from friend_info_view;
<!-----------------------------------------!>

//group sequence
<!-----------------------------------------!>
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

insert into group_tb(g_code, name)
values(group_sequence.nextval, 'name');

select * from group_tb;

update group_tb set name='name1' where g_code='0';

delete from group_tb where g_code='0';
<!-----------------------------------------!>
//group view
<!-----------------------------------------!>
create view group_view
as select * from group_tb with check option;

insert into group_view(g_code, name)
values(group_sequence.nextval, 'name');

select * from group_view;

update group_view set name='name1' where g_code='0';

delete from group_view where g_code='0';
<!-----------------------------------------!>

create table g_participant_tb(
	g_code NUMBER NOT NULL,
	email VARCHAR2(255) NOT NULL,
	FOREIGN KEY(g_code) REFERENCES group_tb(g_code),
	FOREIGN KEY(email) REFERENCES member_tb(email)
);
<!-----------------------------------------!>

//g_participant view
<!-----------------------------------------!>
create view g_participant_view(g_code, email)
as select * from g_participant_tb with check option;

insert into g_participant_view(g_code, email)
values(20, 'email');

select * from g_participant_view;
select * from g_participant_view where email='email' and g_code=20;


create view g_participant_info_view(email, name, location, transportation, g_code, g_name)
as select g_p.email, m.name, m.location, m.transportation, g.g_code, g.name from g_participant_tb g_p, group_tb g, member_tb m
where g_p.g_code=g.g_code and g_p.email=m.email with read only;

select * from g_participant_info_view;
select * from g_participant_info_view where g_name='name';
select * from g_participant_info_view where email='email';
select * from g_participant_info_view where email='email' and g_name='name';
select * from g_participant_info_view where email='email' and g_code=20;
select * from g_participant_info_view where g_code=20;

<!--------------------------------------------------!>

//event sequence
create sequence event_sequence
increment by 1
start with 0
nomaxvalue
minvalue 0
nocycle;

//event
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


//event view
create view event_view
as select * from event_tb with check option;

insert into event_view(e_code, title, s_date, e_date, s_time, e_time, content, place)
values(event_sequence.nextval, 'title', '2016-01-01', '2016-01-02', '13:00', '15:00', 'content', 'place');

select * from event_view;
select * from event_view where e_code=0;
select * from event_view where title='title';
select * from event_view where s_date='2016-01-01';
select * from event_view where s_date='2016-01-01' and e_date='2016-01-02';

update event_view 
set title='title1', s_date='2016-01-02', e_date='2016-01-03', s_time='09:00', e_time='10:00', content='content1', place='place1'
where e_code=0;
<!--------------------------------------!>


//e_participant
create table e_participant_tb(
	e_code NUMBER NOT NULL,
	email VARCHAR2(255) NOT NULL,
	FOREIGN KEY(e_code) REFERENCES event_tb(e_code),
	FOREIGN KEY(email) REFERENCES member_tb(email)
);

//e_participant_view
create view e_participant_view
as select * from e_participant_tb with check option;

insert into e_participant_view(e_code, email)
values(0, 'email');

select * from e_participant_view;

delete from e_participant_view where email='email' and e_code=0;


create view e_participant_info_view(e_code, email, title, s_date, e_date, s_time, e_time, content, place)
as select e_p.e_code, e_p.email, e.title, e.s_date, e.e_date, e.s_time, e.e_time, e.content, e.place 
from e_participant_tb e_p, event_tb e
where e_p.e_code=e.e_code with read only;

select * from e_participant_info_view;
select * from e_participant_info_view where email='email';
select * from e_participant_info_view where email='email' and e_code=0;
select * from e_participant_info_view where e_code=0;

