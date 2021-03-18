<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
       1. 404 : 파일이 존재하지 않는 경우
       2. 500 : 자바 변경 => 컴파일 , 인터프리터 : 오류가 있는 경우 
                ?no= 1   " 1"
      ===================================================
       3. 403 : 접속거부 
       4. 405 : 데이터를 잘못 보내는 경우  ==> 스프링 
       
       response : 내장객체(기본 객체) = 미리 만들어 놓은 객체
       화면이 변경 (request.jsp === output.jsp) => request,response는 초기화
       JSP : 메소드
          _jspService(HttpServletRequest request,HttpServletResponse response) => 사용자가 요청시마다 화면을 출력 
          {
                final javax.servlet.jsp.PageContext pageContext;
			    javax.servlet.http.HttpSession session = null;
			    final javax.servlet.ServletContext application;
			    final javax.servlet.ServletConfig config;
			    javax.servlet.jsp.JspWriter out = null;
			    final java.lang.Object page = this;
              영역에 들어가는 화면단을 만등어 준다 
          }
          
       요청 => 화면으로 이동
       ================
       1. header처리 ==> 데이터를 보내기전에 먼저 실행할 내용
                        다운로드 (파일명,파일크기)
                        *****setHeader()
       2. 화면 이동  ===> *****response.sendRedirect("") : request가 초기화
                             request에 있는 값을 받아서 => 오라클로 전송
          insert.jsp ======> insert_ok.jsp ======> list.jsp
                    request(추가한 내용)      request
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <a href="temp.jsp?id=admin&pwd=1234">클릭</a>
</body>
</html>








