<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><title>글 등록 결과</title></head>
<body>
	<h1>글 등록 결과</h1><br>
	<h2>등록 성공</h2><br>
	<a href="<c:url value='/BoardServlet?cmd=CMD_LIST' />">글 목록으로 이동</a>
</body>
</html>