create table code_skill (
    skill_code          number(3),
    skill_name          varchar2(20)            not null unique,
    primary key(skill_code)
);

create sequence code_skill_seq start with 1 increment by 1;


create table code_religion (
    religion_code       number(3),
    religion_name       varchar2(20)            not null unique,
    primary key(religion_code)
);

create sequence code_religion_seq start with 1 increment by 1;

create table code_school (
    school_code         number(3),
    school_name         varchar2(20)            not null unique,
    primary key(school_code)
);

create sequence code_school_seq start with 1 increment by 1;

create table staff (
    staff_no            number(3),
    staff_name          varchar2(14)            not null,
    jumin_no            char(14)                not null unique,
    school_code         number(3)               not null,
    religion_code       number(3)               not null,
    graduate_day        char(10)                not null,
    foreign key(religion_code) references code_religion(religion_code),
    foreign key(school_code) references code_school(school_code),
    primary key(staff_no)
);

create sequence staff_seq start with 1 increment by 1;

create table staff_skill (
    staff_skill_no       number(3),
    staff_no    number(3)       not null,
    skill_code  number(3)       not null,
    primary key(staff_skill_no),
    foreign key(staff_no) references staff(staff_no),
    foreign key(skill_code) references code_skill(skill_code)
);

create sequence staff_skill_seq start with 1 increment by 1;

insert into code_skill(code_skill_SEQ.NEXTVAL, skill_name) values('java');
insert into code_skill(code_skill_SEQ.NEXTVAL, skill_name) values('jsp');
insert into code_skill(code_skill_SEQ.NEXTVAL, skill_name) values('asp');
insert into code_skill(code_skill_SEQ.NEXTVAL, skill_name) values('php');
insert into code_skill(code_skill_SEQ.NEXTVAL, skill_name) values('delphi');

insert into code_religion(CODE_RELIGION_SEQ.NEXTVAL, religion_name) values('기독교');
insert into code_religion(CODE_RELIGION_SEQ.NEXTVAL, religion_name) values('천주교');
insert into code_religion(CODE_RELIGION_SEQ.NEXTVAL, religion_name) values('불교');
insert into code_religion(CODE_RELIGION_SEQ.NEXTVAL, religion_name) values('이슬람');
insert into code_religion(CODE_RELIGION_SEQ.NEXTVAL, religion_name) values('무교');

insert into code_school(CODE_SCHOOL_SEQ.NEXTVAL, school_name) values('고졸');
insert into code_school(CODE_SCHOOL_SEQ.NEXTVAL, school_name) values('전문대졸');
insert into code_school(CODE_SCHOOL_SEQ.NEXTVAL, school_name) values('일반대졸');













