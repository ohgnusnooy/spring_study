<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("utf-8");//request 내장 객체에 바인딩함
  request.setAttribute("id","hong");
  request.setAttribute("pwd", "1234");
  session.setAttribute("name", "홍길동");//session 내장 객체에 바인딩함
  application.setAttribute("email", "hong@test.com");//application 내장 객체에 바인딩함
%>    

<html>
<head>
<meta  charset=”UTF-8">
<title>forward1</title>
</head>
<body>
   <jsp:forward page="member1.jsp" />
</html>
