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
   <table class="table">
     <tr>
      <td class="text-center">
       <c:forEach var="i" begin="1" end="10">
         <span class="btn btn-sm btn-warning">${i }</span>
       </c:forEach>
         <span class="btn btn-sm btn-warning">단체</span>
      </td>
     </tr>
   </table>
</body>
</html>