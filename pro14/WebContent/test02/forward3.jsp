<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, sec01.ex01.*" pageEncoding="UTF-8" 
    isELIgnored="false"  %>
<%
   request.setCharacterEncoding("UTF-8");
   List membersList = new ArrayList();//ArrayList 객체를 생성
   
   //MemberBean 객체를 생성한 후 두  명의 회원 정보를 저장함
   MemberBean m1 = new MemberBean("lee", "1234", "이순신", "lee@test.com");
   MemberBean m2 = new MemberBean("son", "1234", "손흥민", "son@test.com");
   
   //두 개의 MemberBean 객체를 ArrayList에 저장
   membersList.add(m1);
   membersList.add(m2);
   
   request.setAttribute("membersList", membersList);//request 내장 객체에 ArrayList속성 이름 memberList로 바인딩함
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward3</title>
</head>
<body>
  <jsp:forward page="member3.jsp" />
</body>
</html>