<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3>Java이용</h3>
  <%
      for(int i=1;i<=10;i++)
      {
    	  if(i%2==0)
    	  {
  %>
              <%=i %>는 짝수입니다<br>       
  <%  
    	  }
    	  else
    	  {
  %>
              <%=i %>는 홀수입니다<br>
  <% 
    	  }
      }
  %>
  <%--
       태그가 XML형식으로 만들어져 있다 
       속성="" , '' 대소문 구분 
       여는 태그와 닫는 태그가 명확해야 된다 
   --%>
  <h3>JSTL이용</h3>
  <c:forEach var="i" begin="1" end="10" step="1">
    <c:if test="${i%2 eq 0 }">
       ${i }는 짝수입니다<br>
    </c:if>
    <c:if test="${i%2 ne 0 }">
       ${i }는 홀수입니다<br>
    </c:if>
  </c:forEach>
</body>
</html>




