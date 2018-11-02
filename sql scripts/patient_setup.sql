-- create and populate genders table
create table genders (
    g_id number(*,0) primary key,
    g_gender varchar2(50) unique
);

insert into genders values (1, 'MALE');
insert into genders values (2, 'FEMALE');
insert into genders values (3, 'OTHER');

-- create and populate blood_types table
create table blood_types (
    bt_id number(*,0) primary key,
    bt_blood_type varchar2(50) unique
);

insert into blood_types values (1, 'O_NEGATIVE');
insert into blood_types values (2, 'O_POSITIVE');
insert into blood_types values (3, 'A_NEGATIVE');
insert into blood_types values (4, 'A_POSITIVE');
insert into blood_types values (5, 'B_NEGATIVE');
insert into blood_types values (6, 'B_POSITIVE');
insert into blood_types values (7, 'AB_NEGATIVE');
insert into blood_types values (8, 'AB_POSITIVE');

-- create and populate conditions table
create table conditions (
    c_id number(*,0) primary key,
    c_condition varchar2(100)
);

insert into conditions values (1, 'NONE');
insert into conditions values (2, 'ALLERGIES');
insert into conditions values (3, 'DIABETES');
insert into conditions values (4, 'MISSING LIMB');
insert into conditions values (5, 'STRESSED');

-- create patients table
create table patients (
    p_id number(*,0) primary key,
    p_firstname varchar2(50),
    p_lastname varchar2(50),
    p_height number(*,2) check (p_height > 0),
    p_weight number(*,2) check (p_weight > 0),
    p_dob date,
    g_id number(*,0) references genders(g_id),
    bt_id number(*,0) references blood_types(bt_id),
    c_id number(*,0) references conditions(c_id)
);

-- create sequence for generating patient id
create sequence patient_sequence
start with 0
increment by 1
minvalue 000000
maxvalue 999999
nocycle ;


insert all
    into patients values (1, 'tim', 'dee', 100, 100, to_date('01012007','MMDDYYYY'), 1, 2, 1)
    into patients values (2, 'su', 'ean', 100, 100, to_date('01012007','MMDDYYYY'), 2, 2, 1)
select * from dual;

commit;