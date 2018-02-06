INSERT INTO users (email, password, name)
	VALUES ('1111@naver.com', '1111', '1호');
	
SELECT * FROM users ORDER BY no DESC;

INSERT INTO board (title, content, user_no, regdate)
	VALUES ('제목-55', '내용-55', 8, CURDATE());
	
SELECT * FROM board ORDER BY no DESC;

SELECT b.no, b.title, b.content, u.email, b.regdate FROM board b, users u WHERE b.user_no = u.no;