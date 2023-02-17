<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="sec01.ex01.*"  pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("utf-8");
  MemberBean member = new MemberBean("lee", "1234", "이순신", "lee@test.com"); //MemberBean 객체 생성 후 회원 정보를 속성에 설정함
  request.setAttribute("member", member);//속성 이름을 member로 MemberBean객체에 바인딩함
%>    

<html>
<head>
<meta  charset=”UTF-8">
<title>forward2</title>
</head>
<body>
   <jsp:forward page="member2.jsp" />
</html>
