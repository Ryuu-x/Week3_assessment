create database fil_db1;
use fil_db1;

CREATE TABLE faculty (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    pass VARCHAR(255),
    mob VARCHAR(20)
);

CREATE TABLE course (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    duration VARCHAR(50)
);

CREATE TABLE faculty_course (
    id INT AUTO_INCREMENT PRIMARY KEY,
    faculty_id INT,
    course_id INT,
    FOREIGN KEY (faculty_id) REFERENCES faculty(id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES course(id) ON DELETE CASCADE
);

INSERT INTO Faculty (id, name, email, pass, mob) 
VALUES 
(1, 'Dr. Akarsh', 'a@fil.com', '123', '9876543210'),
(2, 'Prof. Jagrath', 'j@fil.com', '456', '9123456789'),
(3, 'Assistant. Saurav', 's@fil.com', '789', '9234567890');

INSERT INTO Course (id, name, duration) 
VALUES 
(101, 'Data Structures', '4 Months'),
(102, 'Database Management', '3 Months'),
(103, 'Operating Systems', '5 Months');

INSERT INTO Faculty_Course (faculty_id, course_id) 
VALUES 
(1, 101), 
(1, 102), 
(2, 103), 
(3, 101); 

select * from Faculty;