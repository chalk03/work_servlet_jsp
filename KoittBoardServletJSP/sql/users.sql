#no : 회원번호
#email : 이메일(아이디 용도)
#password : 비밀번호
#name : 이름

DROP TABLE users;

CREATE TABLE users (
	no 			INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	email		VARCHAR(255) NOT NULL,
	password	VARCHAR(255) NOT NULL,
	name		VARCHAR(255) NOT NULL,
	UNIQUE (email)
);

SELECT * FROM users;

INSERT INTO users (email, password, name)
	VALUES ('dongmin01@naver.com', '1122', '강동민1호');
	
INSERT INTO users (email, password, name)
	VALUES ('dongmin02@naver.com', '3344', '강동민2호');

INSERT INTO users (email, password, name)
	VALUES ('dongmin03@naver.com', '5566', '강동민3호');