<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
      JSP에서 주로 사용하는 내장(기본) 객체
      = request : getParameter() , getParameterValues()
                  setCharacterEncoding()
      = response : setHeader()=>다운로드 , sendRedirect()
      ***= application : web.xml에 등록된 데이터 읽기 : getInitParameter()
                      실제 경로명 : getRealPath()
      = out : println()
      = pageContext : include,forward
            <jsp:include> <jsp:forward>
      = session VS cookie
      
      사용자가 보낸 데이터 활용
      = 받은 jsp에서만 사용 : request => 화면 변경시 초기화
      = 데이터를 모든 JSP에서 사용  => session 
      
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>