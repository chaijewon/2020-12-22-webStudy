<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
     Date date=new Date();
     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
     String today=sdf.format(date);
%>
<c:set var="day" value="<%=date %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  오늘 날짜:<%=date %><br>
  변환 : <%=today %><br>
  <h3>JSTL이용</h3>
  오늘 날짜:${day }<br>
  변환 : <fmt:formatDate value="${day }" pattern="yyyy-MM-dd hh:mm:ss"/>
  <br>
  <fmt:formatNumber value="10000"
    currencySymbol="￦" type="currency"
  />
  <br>
  <fmt:formatNumber value="10000"
    type="percent" groupingUsed="false"
  />
  <br>

</body>
</html>


