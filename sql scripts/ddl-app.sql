CREATE TABLE DOC_APPOINTMENTS(
appointment_id integer primary key,
patient_id integer not null,
doctor_id integer not null,
dateandtime timestamp not null);


Insert into doc_appointments
Values(1, 12, 21, current_timestamp);
Insert into doc_appointments
Values(2, 1, 1, current_timestamp);
Insert into doc_appointments
Values(3, 1, 1, current_timestamp);
Insert into doc_appointments
Values(4, 2, 2, current_timestamp);
Insert into doc_appointments
Values(5, 2, 2, current_timestamp);
commit;

DROP TABLE DOC_APPOINTMENTS;

TRUNCATE TABLE DOC_APPOINTMENTS;