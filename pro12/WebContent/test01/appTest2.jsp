<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%//첫번째 페이지에서 저장한 데이터를 session, application 내장객체에서 가지고 온다.
    String name=(String)session.getAttribute("name");
    String address=(String )application.getAttribute("address");
%>    

<!DOCTYPE html>     
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 스코프 테스트2</title>
</head>
<body>
<h1>이름은 <%=name %>입니다.</h1>
<h1>주소는 <%=address %>입니다.</h1>
</body>
</html>
