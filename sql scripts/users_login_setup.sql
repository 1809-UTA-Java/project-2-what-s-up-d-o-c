create table DOCTOR_LOGIN (
    dl_id number(*,0) primary key,
    dl_username varchar2(30) unique,
    dl_password varchar2(30)
);

create table PATIENT_LOGIN (
    pl_id number(*,0) primary key,
    pl_username varchar2(30) unique,
    pl_password varchar2(30)
);

insert all
    into DOCTOR_LOGIN values (1, 'mehrabMD', 'pass')
    into DOCTOR_LOGIN values (2, 'dariaMD', 'pass')
    into DOCTOR_LOGIN values (3, 'suMD', 'pass')
    into DOCTOR_LOGIN values (4, 'brianMD', 'pass')
    into DOCTOR_LOGIN values (5, 'nandaMD', 'pass')
    into DOCTOR_LOGIN values (6, 'loremMD', 'pass')
    into DOCTOR_LOGIN values (7, 'timMD', 'pass')
    into DOCTOR_LOGIN values (8, 'davidMD', 'pass')
    into DOCTOR_LOGIN values (9, 'josephMD', 'pass')
    into DOCTOR_LOGIN values (10, 'anotherMD', 'pass')
    into PATIENT_LOGIN values (1, 'tim', 'pass')
    into PATIENT_LOGIN values (2, 'su', 'pass')
SELECT * FROM dual;
COMMIT