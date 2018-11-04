/* Create database and user */
CREATE USER appointments
IDENTIFIED BY whatsupdoc
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

/* Grant permissions to user */
GRANT connect to appointments;
GRANT resource to appointments;
GRANT create session to appointments;
GRANT create table to appointments;
GRANT create view to appointments;

