<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="str" value=" Hello JSTL!! "/>
<c:set var="arr" value="red,green,blue,yellow,cyan"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
str값:${str}<br>
str의 문자 갯수:${fn:length(str) }<br>
str공백문자 제거:${fn:trim(str) }<br>
str문자 제어:${fn:substring(str,1,6) }<br>
str문자 변경:${fn:replace(str," ","-")}<br>
<c:set var="color" value="${fn:split(arr,',') }"/>
<c:forEach var="cc" items="${color }">
  ${cc }<br>
</c:forEach>
</body>
</html>




