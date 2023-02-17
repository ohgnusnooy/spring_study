<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%//첫번째 jsp 페이지에서 포워딩된 requet  객체에서 getAttribute()를 이용해서 정보를 가지고옴
   String name=(String)request.getAttribute("name");
   String address=(String )request.getAttribute("address");
%> 

<!DOCTYPE html>      
<html>
<head>
<meta charset="UTF-8">
<title>두 번째 JSP</title>
</head>
<body>
   <h1>이름은 <%=name %>입니다.</h1>
   <h1>주소는 <%=address %>입니다.</h1>
</body>
</html>
