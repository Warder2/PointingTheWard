SELECT * FROM TAB;
SELECT * FROM MEMBER_TB;
SELECT * FROM FRIEND_TB;
SELECT * FROM GROUP_TB;
SELECT * FROM EVENT_TB;
SELECT * FROM E_PARTICIPANT_TB;
SELECT * FROM G_PARTICIPANT_TB;

SELECT * FROM MEMBER_VIEW;
SELECT * FROM MEMBER_O_VIEW;
SELECT * FROM MEMBER_P_VIEW;
SELECT * FROM FRIEND_VIEW;
SELECT * FROM GROUP_VIEW;
SELECT * FROM EVENT_VIEW;

SELECT * FROM E_PARTICIPANT_INFO_VIEW where email = 'jangsb7113@naver.com';
SELECT * FROM E_PARTICIPANT_VIEW;
SELECT * FROM G_PARTICIPANT_INFO_VIEW;
SELECT * FROM G_PARTICIPANT_VIEW;
SELECT * FROM FRIEND_INFO_VIEW;

DROP VIEW G_PARTICIPANT_VIEW;
DROP VIEW E_PARTICIPANT_VIEW;
DROP VIEW G_PARTICIPANT_INFO_VIEW;
DROP VIEW E_PARTICIPANT_INFO_VIEW;
DROP VIEW FRIEND_VIEW;
DROP VIEW FRIEND_INFO_VIEW;
DROP VIEW GROUP_VIEW;
DROP VIEW EVENT_VIEW;
DROP VIEW MEMBER_VIEW;
DROP VIEW MEMBER_N_VIEW;
DROP VIEW MEMBER_O_VIEW;
DROP SEQUENCE GROUP_SEQUENCE;
DROP SEQUENCE EVENT_SEQUENCE;
DROP TABLE G_PARTICIPANT_TB;
DROP TABLE E_PARTICIPANT_TB;
DROP TABLE GROUP_TB;
DROP TABLE EVENT_TB;
DROP TABLE FRIEND_TB;
DROP TABLE MEMBER_TB;
DROP TRIGGER GROUP_DELETE_TRIGGER;


CREATE SEQUENCE GROUP_SEQUENCE
INCREMENT BY 1
START WITH 0
NOMAXVALUE
MINVALUE 0
NOCYCLE;

CREATE SEQUENCE EVENT_SEQUENCE
INCREMENT BY 1
START WITH 0
NOMAXVALUE
MINVALUE 0
NOCYCLE;

CREATE TABLE MEMBER_TB(
	EMAIL VARCHAR2(255) CONSTRAINT MEMBER_TB_EMAIL_PK PRIMARY KEY,
	NAME VARCHAR2(30) CONSTRAINT MEMBER_TB_NAME_NN NOT NULL,
	PWD VARCHAR2(50) CONSTRAINT MEMBER_TB_PWD_NN NOT NULL,
	LOCATION VARCHAR2(1000) CONSTRAINT MEMBER_TB_LOCATION_NN NOT NULL,
	TRANSPORTATION VARCHAR2(255) check(transportation in ('transit', 'driving')) NOT NULL
);

CREATE TABLE GROUP_TB(
	G_CODE NUMBER CONSTRAINT GROUP_TB_G_CODE_PK PRIMARY key,
	NAME VARCHAR2(255) CONSTRAINT GROUP_TB_NAME_NN NOT NULL,
	OWNER VARCHAR2(255) CONSTRAINT GROUP_TB_OWNER_FK REFERENCES MEMBER_TB(EMAIL)
);

CREATE TABLE FRIEND_TB(
	EMAIL VARCHAR2(255) CONSTRAINT FRIEND_TB_EMAIL_FK REFERENCES MEMBER_TB(EMAIL),
	F_EMAIL VARCHAR2(255) CONSTRAINT FRIEND_TB_F_EMAIL_FK REFERENCES MEMBER_TB(EMAIL),
	PRIMARY KEY(EMAIL ,F_EMAIL)
);

CREATE TABLE EVENT_TB(
	E_CODE NUMBER CONSTRAINT EVENT_TB_E_CODE_PK PRIMARY KEY,
	TITLE VARCHAR2(255) CONSTRAINT EVENT_TB_TITLE_NN NOT NULL,
	S_DATE VARCHAR2(50) CONSTRAINT EVENT_TB_S_DATE_NN NOT NULL,
	E_DATE VARCHAR2(50) CONSTRAINT EVENT_TB_E_DATE_NN NOT NULL,
	S_TIME VARCHAR2(50) CONSTRAINT EVENT_TB_S_TIME_NN NOT NULL,
	E_TIME VARCHAR2(50) CONSTRAINT EVENT_TB_E_TIME_NN NOT NULL,
	CONTENT VARCHAR2(4000) CONSTRAINT EVENT_TB_CONTENT_NN NOT NULL,
	PLACE VARCHAR2(1000) CONSTRAINT EVENT_TB_PLACE_NN NOT NULL
);

CREATE TABLE G_PARTICIPANT_TB(
	G_CODE NUMBER CONSTRAINT G_PARTICIPANT_TB_G_CODE_FK REFERENCES GROUP_TB(G_CODE),
	EMAIL VARCHAR2(255) CONSTRAINT G_PARTICIPANT_TB_EMAIL_FK REFERENCES MEMBER_TB(EMAIL),
	CONSTRAINT G_PARTICIPANT_pk PRIMARY KEY(G_CODE, EMAIL )
);
CREATE TABLE E_PARTICIPANT_TB(
	E_CODE NUMBER CONSTRAINT E_PARTICIPANT_TB_E_CODE_FK REFERENCES EVENT_TB(E_CODE),
	EMAIL VARCHAR2(255) CONSTRAINT E_PARTICIPANT_TB_EMAIL_FK REFERENCES MEMBER_TB(EMAIL),
	CONSTRAINT E_PARTICIPANT_pk PRIMARY KEY(E_CODE, EMAIL )
);

CREATE VIEW MEMBER_VIEW
AS
SELECT * FROM MEMBER_TB with check option;

CREATE VIEW MEMBER_N_VIEW
AS
SELECT EMAIL, PWD, NAME FROM MEMBER_TB with check option;

CREATE VIEW MEMBER_O_VIEW
AS
SELECT EMAIL, NAME, LOCATION,TRANSPORTATION FROM MEMBER_TB with check option;

CREATE VIEW FRIEND_VIEW
AS
SELECT * FROM FRIEND_TB with check option;

CREATE VIEW FRIEND_INFO_VIEW(email, f_email, f_name, f_location, f_transportation)
AS 
SELECT FT.EMAIL,FT.F_EMAIL,MT.NAME,MT.LOCATION,MT.TRANSPORTATION
FROM MEMBER_TB MT, FRIEND_TB FT
WHERE
FT.F_EMAIL = MT.EMAIL;

CREATE VIEW GROUP_VIEW
AS 
SELECT * FROM GROUP_TB with check option;

CREATE VIEW EVENT_VIEW
AS
SELECT * FROM EVENT_TB with check option;

CREATE VIEW G_PARTICIPANT_VIEW
AS
SELECT * FROM G_PARTICIPANT_TB with check option;

CREATE VIEW E_PARTICIPANT_VIEW
AS
SELECT * FROM E_PARTICIPANT_TB with check option;

CREATE VIEW G_PARTICIPANT_INFO_VIEW(email, name, location, transportation, g_code, g_name, owner)
AS
SELECT MT.EMAIL, MT.NAME, MT.LOCATION, MT.TRANSPORTATION,GT.G_CODE, GT.NAME, GT.OWNER
FROM GROUP_TB GT, MEMBER_TB MT, G_PARTICIPANT_TB PT
WHERE 
GT.G_CODE = PT.G_CODE AND PT.EMAIL = MT.EMAIL;


CREATE VIEW E_PARTICIPANT_INFO_VIEW(e_code, email, title, s_date, e_date, s_time, e_time, content, place, name, location, transportation)
AS
SELECT ET.E_CODE, MT.EMAIL, ET.TITLE,ET.S_DATE,ET.E_DATE,ET.S_TIME,ET.E_TIME,ET.CONTENT,ET.PLACE, MT.NAME, MT.LOCATION, MT.TRANSPORTATION
FROM EVENT_TB ET, E_PARTICIPANT_TB PT,MEMBER_TB MT
WHERE 
ET.E_CODE = PT.E_CODE AND PT.EMAIL = MT.EMAIL;


insert into member_tb(email, name, pwd, location, transportation) 
values('jangsb7113@naver.com', '성봉', '1111', '경기도 시흥시 은행동 대우 4차 푸르지오', 'transit');
insert into member_tb(email, name, pwd, location, transportation) 
values('nj186@naver.com', '장해', '1111', '수원시 인계동 무궁화 아파트', 'transit');
insert into member_tb(email, name, pwd, location, transportation) 
values('akjin47@naver.com', '대진', '1111', '인천광역시 연수구 옥련동 럭키아파트', 'transit');

insert into member_tb(email, name, pwd, location, transportation) 
values('testMail@naver.com', '네이버', '1111', '네이버', 'transit');

insert into FRIEND_TB(EMAIL,F_EMAIL)
VALUES('jangsb7113@naver.com','akjin47@naver.com');
insert into FRIEND_TB(EMAIL,F_EMAIL)
VALUES('jangsb7113@naver.com','nj186@naver.com');
insert into FRIEND_TB(EMAIL,F_EMAIL)
VALUES('akjin47@naver.com','jangsb7113@naver.com');
insert into FRIEND_TB(EMAIL,F_EMAIL)
VALUES('akjin47@naver.com','nj186@naver.com');
insert into FRIEND_TB(EMAIL,F_EMAIL)
VALUES('nj186@naver.com','jangsb7113@naver.com');
insert into FRIEND_TB(EMAIL,F_EMAIL)
VALUES('nj186@naver.com','akjin47@naver.com');

select * from FRIEND_TB;
insert into group_tb(g_code, name, owner)
values(group_sequence.nextval, '성봉그룹1', 'jangsb7113@naver.com');
insert into group_tb(g_code, name, owner)
values(group_sequence.nextval, '성봉그룹2', 'jangsb7113@naver.com');
insert into group_tb(g_code, name, owner)
values(group_sequence.nextval, '대진그룹1', 'akjin47@naver.com');
insert into group_tb(g_code, name, owner)
values(group_sequence.nextval, '장해그룹1', 'nj186@naver.com');

insert into g_participant_tb(g_code, email)
values(0, 'akjin47@naver.com');
insert into g_participant_tb(g_code, email)
values(0, 'nj186@naver.com');
insert into g_participant_tb(g_code, email)
values(1, 'akjin47@naver.com');
insert into g_participant_tb(g_code, email)
values(2, 'jangsb7113@naver.com');
insert into g_participant_tb(g_code, email)
values(2, 'nj186@naver.com');
insert into g_participant_tb(g_code, email)
values(3, 'jangsb7113@naver.com');
insert into g_participant_tb(g_code, email)
values(3, 'akjin47@naver.com');


INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'성봉일정1','2016-01-24','2016-01-24','09:00','12:00','데이트','신사동 가로수 길');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'성봉일정2','2016-01-24','2016-01-24','15:00','16:00','데이트','압구정 로데오');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'성봉일정3','2016-01-24','2016-01-24','17:30','19:30','동아리 회의','교대역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'성봉일정4','2016-01-25','2016-01-25','06:00','08:00','개인용무','부천역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'성봉일정5','2016-01-25','2016-01-25','10:00','12:00','데이트','신사동 가로수 길');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'성봉일정6','2016-01-25','2016-01-25','17:30','19:30','친구만남','시흥시 은행동');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'성봉일정7','2016-01-26','2016-01-26','06:00','10:00','미팅','논현역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'성봉일정8','2016-01-27','2016-01-27','10:00','14:00','데이트','서울특별시 반포4동 107-27번지');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'성봉일정9','2016-01-27','2016-01-27','17:30','19:30','데이트','고속터미널 센트럴');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'성봉일정10','2016-01-28','2016-01-28','09:30','12:30','데이트','서울특별시 반포4동 107-27번지');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'성봉일정11','2016-01-28','2016-01-28','21:00','22:00','동아리 세션','신도림역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'성봉일정12','2016-01-29','2016-01-29','09:00','12:00','동네친구만남','시흥시 은행동');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'성봉일정13','2016-01-26','2016-01-26','07:00','10:00','동아리 회의','신도림역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'성봉일정14','2016-01-26','2016-01-26','18:00','20:00','데이트','서울특별시 반포4동 107-27번지');

INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'장해일정1','2016-01-24','2016-01-24','08:00','10:00','스터디','강남역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'장해일정2','2016-01-24','2016-01-24','12:00','13:00','미팅','논현역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'장해일정3','2016-01-24','2016-01-24','17:00','19:00','여자친구','고속터미널');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'장해일정4','2016-01-24','2016-01-24','21:00','22:00','학교','천안시 안서동 단국대학교');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'장해일정5','2016-01-25','2016-01-25','06:00','08:00','친구','수원역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'장해일정6','2016-01-25','2016-01-25','11:00','01:00','조회의','사당역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'장해일정7','2016-01-25','2016-01-25','16:00','18:00','친구','논현역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'장해일정8','2016-01-26','2016-01-27','18:00','06:00','MT','대성리역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'장해일정9','2016-01-28','2016-01-28','10:00','13:00','여자친구','부평역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'장해일정10','2016-01-28','2016-01-28','15:00','17:00','미팅','강남역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'장해일정11','2016-01-29','2016-01-29','07:30','18:00','학교','천안시 안서동 단국대학교');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'장해일정12','2016-01-26','2016-01-26','07:30','09:30','여자친구','부평역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'장해일정13','2016-01-26','2016-01-26','16:00','19:00','조 회의','사당역');

INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'대진일정1','2016-01-24','2016-01-24','09:00','11:00','미팅','역삼역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'대진일정2','2016-01-24','2016-01-24','17:00','19:00','친구','부평역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'대진일정3','2016-01-25','2016-01-25','16:00','20:00','데이트','수원역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'대진일정4','2016-01-26','2016-01-26','06:00','08:00','스터디','강남역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'대진일정5','2016-01-26','2016-01-26','08:30','10:30','스터디','강남역');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'대진일정6','2016-01-28','2016-01-28','09:00','11:00','데이트','영통');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'대진일정7','2016-01-28','2016-01-28','10:00','12:00','친구','옥련동 럭키아파트');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'대진일정8','2016-01-29','2016-01-29','06:00','15:00','데이트','영통');
INSERT INTO EVENT_TB(E_CODE,TITLE,S_DATE,E_DATE,S_TIME,E_TIME,CONTENT,PLACE)
VALUES(EVENT_SEQUENCE.NEXTVAL,'대진일정9','2016-01-26','2016-01-26','06:00','08:30','친구','옥련동 럭키아파트');



INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(0,'jangsb7113@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(1,'jangsb7113@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(2,'jangsb7113@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(3,'jangsb7113@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(4,'jangsb7113@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(5,'jangsb7113@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(6,'jangsb7113@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(7,'jangsb7113@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(8,'jangsb7113@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(9,'jangsb7113@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(10,'jangsb7113@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(11,'jangsb7113@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(12,'jangsb7113@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(13,'jangsb7113@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(14,'nj186@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(15,'nj186@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(16,'nj186@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(17,'nj186@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(18,'nj186@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(19,'nj186@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(20,'nj186@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(21,'nj186@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(22,'nj186@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(23,'nj186@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(24,'nj186@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(25,'nj186@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(26,'nj186@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(27,'akjin47@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(28,'akjin47@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(29,'akjin47@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(30,'akjin47@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(31,'akjin47@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(32,'akjin47@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(33,'akjin47@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(34,'akjin47@naver.com');
INSERT INTO E_PARTICIPANT_TB(E_CODE,EMAIL)
VALUES(35,'akjin47@naver.com');

select * from e_participant_info_view 