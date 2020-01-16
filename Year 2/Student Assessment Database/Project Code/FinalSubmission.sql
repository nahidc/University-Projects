SET TERMOUT ON
PROMPT Building demonstration tables.  Please wait.
-- SET TERMOUT OFF

ALTER TABLE STUDENT
DROP CONSTRAINT FK_stu;

ALTER TABLE SUBJECT
DROP CONSTRAINT FK_sub;

ALTER TABLE COURSEWORK
DROP CONSTRAINT FK_cour;

ALTER TABLE EXAM
DROP CONSTRAINT FK_examo;

ALTER TABLE QUESTIONS
DROP CONSTRAINT FK_queso;

ALTER TABLE QUESTIONS
DROP CONSTRAINT FK_quest;

ALTER TABLE EXAM
DROP CONSTRAINT FK_examst;

DROP TABLE STUDENT;
DROP TABLE COURSEWORK;
DROP TABLE EXAM;
DROP TABLE QUESTIONS;
DROP TABLE SUBJECT;
DROP TABLE LECTURER;

-- TABLE LECTURER
CREATE TABLE LECTURER(
  LECTURERID int NOT NULL PRIMARY KEY,
  FIRSTNAME VARCHAR2(9),
  LASTNAME VARCHAR2(15)
);

-- LECTURER DATA
INSERT INTO LECTURER (LECTURERID, FIRSTNAME, LASTNAME) VALUES (101, 'CAHILL', 'SARAH');
INSERT INTO LECTURER (LECTURERID, FIRSTNAME, LASTNAME) VALUES (102, 'SMITH', 'MICHELLE');
INSERT INTO LECTURER (LECTURERID, FIRSTNAME, LASTNAME) VALUES (103, 'PATEL', 'JOSE');
INSERT INTO LECTURER (LECTURERID, FIRSTNAME, LASTNAME) VALUES (104, 'LUKAKU', 'DAVID');
INSERT INTO LECTURER (LECTURERID, FIRSTNAME, LASTNAME) VALUES (105, 'DON', 'JAMES');
INSERT INTO LECTURER (LECTURERID, FIRSTNAME, LASTNAME) VALUES (106, 'RAJ', 'SIMRANL');


-- STUDENT TABLE
CREATE TABLE STUDENT(
	STUDENTID int NOT NULL,
	FIRSTNAME VARCHAR2(10) NOT NULL,
    	LASTNAME VARCHAR2(10),
  	DOB DATE,
	YEARENROLLED NUMBER(4),
  	SUBJECTID int NOT NULL,-- FOREIGN KEY
	PRIMARY KEY(STUDENTID)-- PRIMARY KEY
);

-- STUDENT DATA
INSERT INTO STUDENT (STUDENTID, FIRSTNAME, LASTNAME, DOB, YEARENROLLED, SUBJECTID) VALUES (111, 'MANISH', 'DON', '17-DEC-1980', 2016, 110);
INSERT INTO STUDENT (STUDENTID, FIRSTNAME, LASTNAME, DOB, YEARENROLLED, SUBJECTID) VALUES (222, 'DAVID', 'SMITH', '20-JAN-1978', 2016, 120);
INSERT INTO STUDENT (STUDENTID, FIRSTNAME, LASTNAME, DOB, YEARENROLLED, SUBJECTID) VALUES (333, 'JAMES', 'JONES', '12-APR-1980', 2015, 130);
INSERT INTO STUDENT (STUDENTID, FIRSTNAME, LASTNAME, DOB, YEARENROLLED, SUBJECTID) VALUES (444, 'TERRY', 'JOHN', '05-MAY-1980', 2014, 140);
INSERT INTO STUDENT (STUDENTID, FIRSTNAME, LASTNAME, DOB, YEARENROLLED, SUBJECTID) VALUES (555, 'MO', 'SALAH', '06-FEB-1980', 2013, 150);
INSERT INTO STUDENT (STUDENTID, FIRSTNAME, LASTNAME, DOB, YEARENROLLED, SUBJECTID) VALUES (666, 'ALEX', 'KLOPP', '16-FEB-1980', 2013, 160);



-- SUBJECT TABLE
CREATE TABLE SUBJECT(
	SUBJECTID int NOT NULL PRIMARY KEY,
	NAME VARCHAR2(14),
  	NUMBEROFCOURSEWORKS NUMBER(1),
  	SEMESTER NUMBER(1),
  	ACADEMICYEAR VARCHAR2(10),
  	LECTURERID int NOT NULL -- foreign key
);

-- SUBJECT DATA
INSERT INTO SUBJECT (SUBJECTID, NAME, NUMBEROFCOURSEWORKS, SEMESTER, ACADEMICYEAR, LECTURERID) VALUES (110, 'ACCOUNTING', 4, 1, '2015/2016', 101);
INSERT INTO SUBJECT (SUBJECTID, NAME, NUMBEROFCOURSEWORKS, SEMESTER, ACADEMICYEAR, LECTURERID) VALUES (120, 'COMPUTING', 5, 1, '2016/2017', 102);
INSERT INTO SUBJECT (SUBJECTID, NAME, NUMBEROFCOURSEWORKS, SEMESTER, ACADEMICYEAR, LECTURERID) VALUES (130, 'ECONOMICS', 6, 2, '2017/2018', 103);
INSERT INTO SUBJECT (SUBJECTID, NAME, NUMBEROFCOURSEWORKS, SEMESTER, ACADEMICYEAR, LECTURERID) VALUES (140, 'HISTORY', 4, 2, '2013/2015', 104);
INSERT INTO SUBJECT (SUBJECTID, NAME, NUMBEROFCOURSEWORKS, SEMESTER, ACADEMICYEAR, LECTURERID) VALUES (150, 'MEDICINE', 7, 3, '2015/2016', 105);
INSERT INTO SUBJECT (SUBJECTID, NAME, NUMBEROFCOURSEWORKS, SEMESTER, ACADEMICYEAR, LECTURERID) VALUES (160, 'LAW', 3, 4, '2016/2017', 106);

-- COURSEWORK TABLE
CREATE TABLE COURSEWORK(
  COURSEWORKID int NOT NULL PRIMARY KEY,
  MAXMARKS NUMBER(3),
  MARKSGAINED NUMBER(3),
  SUBJECTID int NOT NULL, -- FOREIGN KEY FROM
  COURSEWORKNUMBER NUMBER(1),
  STATUSOFSUBMISSION VARCHAR2(15), -- COULD BE A BOOLEAN
  MODULEPERCENTAGE VARCHAR2(4)
);

-- COURSEWORK DATA
INSERT INTO COURSEWORK (COURSEWORKID, MAXMARKS, MARKSGAINED, SUBJECTID, COURSEWORKNUMBER, STATUSOFSUBMISSION, MODULEPERCENTAGE) VALUES (7, 50, 25, 110, 2, 'COMPLETE', '10%');
INSERT INTO COURSEWORK (COURSEWORKID, MAXMARKS, MARKSGAINED, SUBJECTID, COURSEWORKNUMBER, STATUSOFSUBMISSION, MODULEPERCENTAGE) VALUES (8, 60, 35, 120, 4, 'INCOMPLETE', '20%');
INSERT INTO COURSEWORK (COURSEWORKID, MAXMARKS, MARKSGAINED, SUBJECTID, COURSEWORKNUMBER, STATUSOFSUBMISSION, MODULEPERCENTAGE) VALUES (9, 75, 60, 130, 1, 'COMPLETE', '15%');
INSERT INTO COURSEWORK (COURSEWORKID, MAXMARKS, MARKSGAINED, SUBJECTID, COURSEWORKNUMBER, STATUSOFSUBMISSION, MODULEPERCENTAGE) VALUES (10, 80, 40, 140, 5, 'INCOMPLETE', '20%');
INSERT INTO COURSEWORK (COURSEWORKID, MAXMARKS, MARKSGAINED, SUBJECTID, COURSEWORKNUMBER, STATUSOFSUBMISSION, MODULEPERCENTAGE) VALUES (11, 60, 30, 150, 3, 'COMPLETE', '25%');
INSERT INTO COURSEWORK (COURSEWORKID, MAXMARKS, MARKSGAINED, SUBJECTID, COURSEWORKNUMBER, STATUSOFSUBMISSION, MODULEPERCENTAGE) VALUES (12, 50, 35, 160, 3, 'COMPLETE', '15%');

-- EXAM TABLE
CREATE TABLE EXAM(
  EXAMID int NOT NULL PRIMARY KEY,
  MAXMARKS NUMBER(3),
    MARKSGAINED NUMBER(3),
  ATTEMPTNUMBER NUMBER(1),
  LECTURERID  int NOT NULL,
  SUBJECTID int NOT NULL -- FOREIGN KEY
);


-- EXAM DATA
INSERT INTO EXAM (EXAMID, MAXMARKS, MARKSGAINED, ATTEMPTNUMBER, LECTURERID, SUBJECTID) VALUES (111, 50, 28, 1, 101, 110);
INSERT INTO EXAM (EXAMID, MAXMARKS, MARKSGAINED, ATTEMPTNUMBER, LECTURERID, SUBJECTID) VALUES (222, 40, 30, 2, 102, 120);
INSERT INTO EXAM (EXAMID, MAXMARKS, MARKSGAINED, ATTEMPTNUMBER, LECTURERID, SUBJECTID) VALUES (333, 25, 20, 1, 103, 130);
INSERT INTO EXAM (EXAMID, MAXMARKS, MARKSGAINED, ATTEMPTNUMBER, LECTURERID, SUBJECTID) VALUES (444, 20, 15, 2, 104, 140);
INSERT INTO EXAM (EXAMID, MAXMARKS, MARKSGAINED, ATTEMPTNUMBER, LECTURERID, SUBJECTID) VALUES (555, 40, 18, 1, 105, 150);
INSERT INTO EXAM (EXAMID, MAXMARKS, MARKSGAINED, ATTEMPTNUMBER, LECTURERID, SUBJECTID) VALUES (666, 50, 40, 1, 106, 160);

-- QUESTIONS TABLE
CREATE TABLE QUESTIONS(
  QUESTIONID int NOT NULL PRIMARY KEY,
  MAXMARKS NUMBER(2),
  QUESTIONNUMBER NUMBER(2),
  EXAMID int NOT NULL, -- FOREIGN KEY
  MARKSGAINED NUMBER(2),
  LECTURERID int NOT NULL -- FOREIGN KEY FROM LECTURER TABLE (WHO SET THE QUESTIONS)
);

-- QUESTIONS DATA
INSERT INTO QUESTIONS (QUESTIONID, MAXMARKS, QUESTIONNUMBER, EXAMID, MARKSGAINED, LECTURERID) VALUES (50, 25, 1, 111, 20, 101);
INSERT INTO QUESTIONS (QUESTIONID, MAXMARKS, QUESTIONNUMBER, EXAMID, MARKSGAINED, LECTURERID) VALUES (51, 30, 2, 222, 25, 102);
INSERT INTO QUESTIONS (QUESTIONID, MAXMARKS, QUESTIONNUMBER, EXAMID, MARKSGAINED, LECTURERID) VALUES (52, 15, 3, 333, 10, 103);
INSERT INTO QUESTIONS (QUESTIONID, MAXMARKS, QUESTIONNUMBER, EXAMID, MARKSGAINED, LECTURERID) VALUES (53, 20, 4, 444, 15, 104);
INSERT INTO QUESTIONS (QUESTIONID, MAXMARKS, QUESTIONNUMBER, EXAMID, MARKSGAINED, LECTURERID) VALUES (54, 10, 5, 555, 5, 105);
INSERT INTO QUESTIONS (QUESTIONID, MAXMARKS, QUESTIONNUMBER, EXAMID, MARKSGAINED, LECTURERID) VALUES (55, 35, 6, 666, 30, 106);

-- COURSEWORK FOREIGN KEY
alter table STUDENT
add CONSTRAINT FK_stu FOREIGN KEY (SUBJECTID) REFERENCES SUBJECT(SUBJECTID);


-- COURSEWORK FOREIGN KEY
alter table COURSEWORK
add CONSTRAINT FK_cour FOREIGN KEY (SUBJECTID) REFERENCES SUBJECT(SUBJECTID);

-- EXAM
alter table EXAM
add CONSTRAINT FK_examo FOREIGN KEY (SUBJECTID) REFERENCES SUBJECT(SUBJECTID);

alter table EXAM
add CONSTRAINT FK_examst FOREIGN KEY(LECTURERID) REFERENCES LECTURER(LECTURERID);

-- QUESTIONS
alter table QUESTIONS
add CONSTRAINT FK_queso FOREIGN KEY (LECTURERID) REFERENCES LECTURER(LECTURERID);

alter table QUESTIONS
add CONSTRAINT FK_quest FOREIGN KEY (EXAMID) REFERENCES EXAM(EXAMID);

-- ADDING FOREIGN KEYS TO SUBJECT TABLE
alter table SUBJECT
add CONSTRAINT FK_sub FOREIGN KEY(LECTURERID) REFERENCES LECTURER(LECTURERID);

COMMIT;

SET TERMOUT ON
PROMPT Demonstration table build is complete.
