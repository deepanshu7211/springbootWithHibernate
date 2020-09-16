--For Course class
insert into course(id, name,created_date,last_updated_date) values(10001,'JPA in 50 Steps',sysdate,sysdate);
insert into course(id, name,created_date,last_updated_date) values(10002,'Spring in 50 Steps',sysdate,sysdate);

--for Passport
insert into passport(id, number) values(40001,'IND1234');
insert into passport(id, number) values(40002,'IND4567');

--For student class
insert into student(id, name,passport_id) values(20001,'Java Student',40001);
insert into student(id, name,passport_id) values(20002,'Database student',40002);

--For Review
insert into review(id, rating,description,course_id) values(50001,'5','Good Review',10001);
insert into review(id, rating,description,course_id) values(50002,'2','Bad Review',10002);

--For Student_course
insert into STUDENT_COURSE(STUDENT_ID,COURSE_ID) values (20001,10001);
insert into STUDENT_COURSE(STUDENT_ID,COURSE_ID) values (20002,10002);