CREATE DATABASE event_manager;

USE event_manager;

CREATE TABLE user_(
	id CHAR(36) PRIMARY KEY, 
    name_user VARCHAR(60),
    email VARCHAR(60) NOT NULL,
	password_user VARCHAR(20) NOT NULL,
    type_user INT 
);

CREATE TABLE host_(
	id CHAR(36) PRIMARY KEY, 
    name_user VARCHAR(60),
    email VARCHAR(60) NOT NULL,
	password_user VARCHAR(20) NOT NULL,
    type_user INT 
);

CREATE TABLE event_(
	id CHAR(36) PRIMARY KEY,
    name_event VARCHAR(60),
	date_time_event DATETIME,
    final_date_event DATETIME,
    images VARCHAR(120),
    limit_of_people int
);

CREATE TABLE addresses(
	id INT PRIMARY KEY auto_increment,
    state VARCHAR(30),
    city VARCHAR(30),
    street VARCHAR(30),
    number_house INT,
    complement VARCHAR(10),
    district VARCHAR(30),
    user_id CHAR(36) UNIQUE,
    event_id CHAR(36) UNIQUE,
    host_id CHAR(36) UNIQUE,
    FOREIGN KEY(user_id) REFERENCES user_(id),
    FOREIGN KEY(event_id) REFERENCES event_(id),
    FOREIGN KEY(host_id) REFERENCES host_(id)
);
