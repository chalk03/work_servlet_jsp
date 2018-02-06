<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><title>회원가입 페이지</title></head>
<body>
	<h1>회원가입 페이지</h1>

	<form action="<c:url value='/UsersServlet' />" method="post">
		<input type="hidden" name="cmd" value="CMD_JOIN">
		<label>이메일 : <input type="email" name="email"></label><br>
		<label>비밀번호 : <input type="password" name="password"></label><br>
		<label>비밀번호확인 : <input type="password" name="password-confirm"></label><br>
		<label>이름 : <input type="text" name="name"></label><br>
		<input type="submit" value="회원가입">
	</form>
	<c:if test="${ param.error == 'password' }">
		<div style="color: #FF0000">패스워드 입력을 다시 확인해주세요.</div>
	</c:if>
	<c:if test="${ param.error == 'email' }">
		<div style="color: #FF0000">이메일이 중복되었습니다.</div>
	</c:if>
</body>
</html>

