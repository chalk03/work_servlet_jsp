
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.TreeMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	// Servlet 대신해서 JSP에서 표현
	TreeMap<String, Object> mapData = new TreeMap<String, Object>();
	mapData.put("name", "최범균");
	mapData.put("today", new java.util.Date());
%>
<!-- var에 설정한 변수명에 value에 설정한 값을 넣는다. -->
<c:set var="intArray" value="<%= new int[] {1,2,3,4,5} %>" />
<c:set var="map" value="<%= mapData %>" />
<!DOCTYPE html>
<html>
<head>
<title>forEach 태그</title>
</head>
<body>
	<h4>1부터 100까지 홀수의 합</h4>
	<c:set var="sum" value="0" />
	<c:forEach var="i" begin="1" end="100" step="2">
	<c:set var="sum" value="${sum + i}" />
	</c:forEach>
	결과 = ${sum}

	<h4>구구단</h4>
	<ul>
		<c:forEach var="i" begin="2" end="9">
			<c:forEach var="j" begin="1" end="9">
			<li>${i} * ${j} = ${i * j}</li>
		</c:forEach>
		<br>
		</c:forEach>
	</ul>

	<h4>int형 배열</h4>
	<c:forEach var="i" items="${intArray}" begin="2" end="4" varStatus="status">
		${status.index}-${status.count}-[${i}] <br />
	</c:forEach>

	<h4>Map</h4>
	
	<c:forEach var="i" items="${map}">
	${i.key} = ${i.value} <br />
	</c:forEach>
</body>
</html>