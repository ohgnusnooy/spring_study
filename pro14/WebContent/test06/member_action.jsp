<%@ page language="java" contentType="text/html; charset=UTF-8"
     import=" java.util.*,sec02.ex01.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%>    
<html>
<head>
<meta charset="TF-8">
<jsp:useBean  id="m" class="sec02.ex01.MemberBean" />
<jsp:setProperty name="m" property="*"  />
<%
   MemberDAO memDAO=new MemberDAO();
   memDAO.addMember(m);//회원 정보 추가
   List membersList =memDAO.listMembers();//회원 정보 조회
   request.setAttribute("membersList", membersList);//조회한 회원 정보를 request에 바인딩함
%> 
</head>
<body>
<jsp:forward  page="membersList.jsp" />
</body>
</html>
