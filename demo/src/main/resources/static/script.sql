CREATE TABLE Course(course_Id INT PRIMARY KEY,course_Name varchar2(10),course_desc varchar2(30),no_of_days INT);

create table trainer (trainer_id INT primary key, trainer_name varchar2(30) , skill varchar2(30));

CREATE TABLE Program(program_Id INT PRIMARY KEY,
    start_date DATE,
    end_date DATE,
   course_Id INT,
   trainer_id INT,
   foreign key (course_Id) references course(course_id),
   foreign key (trainer_id) references trainer(trainer_id)
   );

CREATE TABLE Employee(employee_Id INT PRIMARY KEY,employee_Name varchar2(15),employee_Pass varchar2(8),Role varchar2(10));

CREATE TABLE Feedback(feedback_id INT primary key,
    FeedBack1 INT,
    FeedBack2 INT,
    FeedBack3 INT,
    FeedBack4 INT,
    FeedBack5 INT,
    comments varchar2(50),
    suggestions varchar2(40)
    );

create table program_participant (id INT primary key, participant_id INT, program_id INT , feedback_id INT,
foreign key (participant_id) references employee(employee_id),
foreign key (program_id) references program(program_id),
foreign key (feedback_id) references feedback(feedback_id),
);

create sequence emp_seq minvalue 401 maxvalue 10000 start with 401 increment by 1;

create sequence course_seq minvalue 101 maxvalue 201 start with 101 increment by 1;

create sequence program_seq minvalue 301 maxvalue 400 start with 301 increment by 1;

create sequence feedback_seq minvalue 10001 maxvalue 11000 start with 10001 increment by 1;

create sequence trainer_seq minvalue 11 maxvalue 50 start with 11 increment by 1;

