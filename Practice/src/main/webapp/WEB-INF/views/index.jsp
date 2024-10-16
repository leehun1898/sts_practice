<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Hello world!  
	</h1>

	
	<c:forEach var="membername" items="${memberlist}"  begin="0" end="1">
	<tr>
	<td>${membername.name}</td>
	</tr>
	</c:forEach>
		
	<P>  The time on the server is ${serverTime}. </P>
	
</body>
</html>
