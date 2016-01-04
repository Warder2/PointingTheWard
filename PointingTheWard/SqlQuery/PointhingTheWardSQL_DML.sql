insert into member_view(email, name, pwd, location, transportation) 
values('email', 'name', 'pwd', 'location', 'transit');
insert into member_view(email, name, pwd, location, transportation) 
values('email1', 'name1', 'pwd1', 'location1', 'transit');
insert into member_view(email, name, pwd, location, transportation) 
values('email2', 'name2', 'pwd2', 'location2', 'driving');

select * from member_view;
select * from member_view where email='email';

delete from member_view where email = 'email2';

insert into member_view(email, name, pwd, location, transportation) 
values('email2', 'name2', 'pwd2', 'location2', 'driving');

update member_view
set name='name1', pwd='pwd1', location ='location1', transportation='driving'
where email='email';



select * from member_p_view;
select * from member_p_view where email='email'and pwd='pwd';

update member_p_view set name='name2', pwd='pwd2' where email='email';

select * from member_o_view;
select * from member_o_view where email='email';

update member_o_view
set name='name', location ='location', transportation='driving'
where email='email';





insert into friend_view(email, f_email) values('email', 'email2');
insert into friend_view(email, f_email) values('email', 'email1');

select * from friend_view;
select * from friend_view where email='email';

delete from friend_view where email='email';

insert into friend_view(email, f_email) values('email', 'email1');

delete from friend_view where email='email' and f_email='email1';

insert into friend_view(email, f_email) values('email', 'email2');
insert into friend_view(email, f_email) values('email', 'email1');


select * from friend_info_view;
select * from friend_info_view where email='email';
select * from friend_info_view where email='email' and f_email='email1';



insert into group_view(g_code, name, owner)
values(group_sequence.nextval, 'name', 'email');

select * from group_view;
select * from group_view where g_code=0;
select * from group_view where owner='email';
select * from group_view where name='name';

update group_view set name='name1' where g_code=0;

delete from group_view where g_code=0;

insert into group_view(g_code, name, owner)
values(group_sequence.nextval, 'name', 'email');
insert into group_view(g_code, name, owner)
values(group_sequence.nextval, 'name1', 'email');





insert into g_participant_view(g_code, email)
values(1, 'email');
insert into g_participant_view(g_code, email)
values(1, 'email1');
insert into g_participant_view(g_code, email)
values(2, 'email');
insert into g_participant_view(g_code, email)
values(2, 'email2');

select * from g_participant_view;
select * from g_participant_view where email='email' and g_code=1;

delete from g_participant_view where email='email' and g_code=1;

insert into g_participant_view(g_code, email)
values(1, 'email');

select * from g_participant_info_view;
select * from g_participant_info_view where g_name='name' and owner='email';
select * from g_participant_info_view where owner='email';
select * from g_participant_info_view where email='email' and g_name='name';
select * from g_participant_info_view where email='email';
select * from g_participant_info_view where g_code=1;





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

delete from event_view where e_code=0;

insert into event_view(e_code, title, s_date, e_date, s_time, e_time, content, place)
values(event_sequence.nextval, 'title', '2016-01-01', '2016-01-02', '13:00', '15:00', 'content', 'place');
insert into event_view(e_code, title, s_date, e_date, s_time, e_time, content, place)
values(event_sequence.nextval, 'title1', '2016-01-02', '2016-01-02', '15:00', '18:00', 'content1', 'place1');



insert into e_participant_view(e_code, email)
values(1, 'email');
insert into e_participant_view(e_code, email)
values(2, 'email');

select * from e_participant_view;

delete from e_participant_view where email='email' and e_code=1;

insert into e_participant_view(e_code, email)
values(1, 'email');

select * from e_participant_info_view;
select * from e_participant_info_view where email='email';
select * from e_participant_info_view where email='email' and e_code=1;



drop trigger member_delete_trigger;
drop trigger e_participant_delete_trigger;
	
	
insert into member_view(email, name, pwd, location, transportation) 
values('email', 'name', 'pwd', 'location', 'transit');
insert into member_view(email, name, pwd, location, transportation) 
values('email1', 'name1', 'pwd1', 'location1', 'transit');
insert into member_view(email, name, pwd, location, transportation) 
values('email2', 'name2', 'pwd2', 'location2', 'driving');


insert into friend_view(email, f_email) values('email', 'email2');
insert into friend_view(email, f_email) values('email', 'email1');

insert into event_view(e_code, title, s_date, e_date, s_time, e_time, content, place)
values(event_sequence.nextval, 'title', '2016-01-01', '2016-01-02', '13:00', '15:00', 'content', 'place');

insert into e_participant_view(e_code, email)
values(0, 'email');

select count(*) from e_participant_view where e_code=0

select * from member_view;
select * from friend_view;
select * from event_view;
select * from e_participant_view;

delete from member_view;

select * from all_triggers;