<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.bean.*"%>
<%--
     public void jspService(HttpServletRequest request,HttpServletResponse response)
     throws Exception
     {
 --%>
<%
    request.setCharacterEncoding("UTF-8");
    
    String name=request.getParameter("name");
    String id=request.getParameter("id");
    String sex=request.getParameter("sex");
    String addr=request.getParameter("addr");
    String tel=request.getParameter("tel");
    
    MemberBean bean=new MemberBean();
    bean.setName(name);
    bean.setSex(sex);
    bean.setId(id);
    bean.setAddr(addr);
    bean.setTel(tel);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  아이디:<%=bean.getId() %><br>
  이름:<%=bean.getName() %><br>
  성별:<%=bean.getSex() %><br>
  주소:<%=bean.getAddr() %><br>
  전화:<%=bean.getTel() %>
</body>
</html>




