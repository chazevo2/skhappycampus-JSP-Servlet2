/*
 * 회원 테이블 : member.sql
 * 
 * ## 회원 속성정보
 * 1. 아이디	member_id	varchar2(20) 식별키
 * 2. 비밀번호	member_pw	varchar2(30) not null
 * 3. 이름	member_name	varchar2(20) not null
 * 4. 휴대폰	mobile		varchar2(13) not null 010-1234-5678
 * 5. 이메일	email		varchar2(30) not null
 * 6. 가입일	entry_date	date => varchar2(10) 2019.01.01
 * 7. 등급	grade		varchar2(1)  G,S,A
 * 8. 마일리지	milage		number(6)
 * 9. 담당자	manager		varchar2(20)
 * 
 */
drop table members;
create table members (
    member_id varchar2(20) primary key,
    member_pw varchar2(30) not null,
    member_name varchar2(30) not null,
    mobile varchar2(13) not null,
    email varchar2(30) not null,
    entry_date varchar2(10),
    -- entry_date date,
    grade char(1),
    mileage number(6),
    manager varchar2(30)
);
insert into members values('user01', 'password01', '홍길동', '010-1111-1111', 'user01@work.com', '2019.03.15', 'G', 500, '');
insert into members values('user02', 'password02', '이순신', '010-2222-2222', 'user02@work.com', '2019.04.20', 'S', 0, '송중기');
insert into members values('admin01', 'password01', '김유신', '010-3333-3333', 'user03@work.com', '2018.12.25', 'A', 0, '');

select * from members;

-- select member_id, member_pw, member_name, mobile, email, to_char(entry_date, 'yyyy.mm.dd'), grade, mileage, manager from members where member_id='user01';