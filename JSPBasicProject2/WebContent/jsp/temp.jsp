<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //response.sendRedirect("result.jsp");
    //pageContext.forward("result.jsp");//MVC
    //RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
    //rd.forward(request, response);
    /*
        한단계 거쳐서 이동 
        request
         필요 : forward,session
         불필요 : sendRedirect
         
         
         a.jsp 
         _jspService(req,res)
         {
         
         }
    
         b.jsp
         _jspService(req,res)
         {
        	 c.jsp => _jspService(req,res)
         }
         
         c.jsp
         _jspService(req,res)
         {
        	 
         }
    */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>