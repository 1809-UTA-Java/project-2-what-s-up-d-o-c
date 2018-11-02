-- create and populate genders table
create table genders (
    g_id number(*,0) primary key,
    g_gender varchar2(50) unique
);

insert into genders values (001, 'MALE');
insert into genders values (002, 'FEMALE');
insert into genders values (003, 'OTHER');

-- create and populate blood_types table
create table blood_types (
    bt_id number(*,0) primary key,
    bt_blood_type varchar2(50) unique
);

insert into blood_types values (001, 'O_NEGATIVE');
insert into blood_types values (002, 'O_POSITIVE');
insert into blood_types values (003, 'A_NEGATIVE');
insert into blood_types values (004, 'A_POSITIVE');
insert into blood_types values (005, 'B_NEGATIVE');
insert into blood_types values (006, 'B_POSITIVE');
insert into blood_types values (007, 'AB_NEGATIVE');
insert into blood_types values (008, 'AB_POSITIVE');

-- create and populate conditions table
create table conditions (
    c_id number(*,0) primary key,
    c_condition varchar2(100)
);

insert into conditions values (001, 'ALLERGIES');
insert into conditions values (002, 'DIABETES');
insert into conditions values (003, 'MISSING LIMB');
insert into conditions values (004, 'STRESSED');

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
    into patients (p_id, p_firstname, p_lastname) values (1, 'tim', 'dim')
    into patients (p_id, p_firstname, p_lastname) values (2, 'su', 'ean')
select * from dual;

commit;