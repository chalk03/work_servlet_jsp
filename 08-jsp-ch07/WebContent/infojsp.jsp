<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Info</title>
</head>
<body>
	<!-- table 표: 너비가 화면 전체, 선두께는 1, 칸 안쪽여백 0, 칸밖여백 0 -->
	<table width="100%" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>제품번호</td>
			<td>XXXX</td>
		</tr>
		<tr>
			<td>가격</td>
			<td>10,000원</td>
		</tr>
	</table>

	<%--/infoSub.jsp?type=A --%>
	<jsp:include page="infoSub.jsp" flush="false">
		<jsp:param name="type" value="A" />
	</jsp:include>

</body>
</html>