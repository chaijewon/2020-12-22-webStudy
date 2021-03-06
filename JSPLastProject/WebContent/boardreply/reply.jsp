<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.mypage_row{
  margin: 0px auto;
  width:960px;
}
</style>
</head>
<body>
	<div class="wrapper row3 mypage_row">
	  <h2 class="sectiontitle">답변하기</h2>
	  <div style="height: 500px;width:750px;overflow-y:auto;margin:0px auto">
	  <%--
	     enctype="multipart/form-data" : 파일업로드시에 사용하는 프로토콜
	   --%>
	   <form method=post action="../boardreply/reply_ok.do">
	   <table class="table">
	    <tr>
	      <th width=20% class="text-right">이름</th>
	      <td width=80%>
	        <input type=text name=name size=15 class="input-sm" value="관리자" readonly="readonly">
	        <input type=hidden name=no value="${no }">
	        <input type=hidden name=group_id value="${group_id }">
	      </td>
	    </tr>
	    <tr>
	      <th width=20% class="text-right">제목</th>
	      <td width=80%>
	        <input type=text name=subject size=50 class="input-sm">
	      </td>
	    </tr>
	    <tr>
	      <th width=20% class="text-right">내용</th>
	      <td width=80%>
	        <textarea rows="10" cols="52" name=content></textarea>
	      </td>
	    </tr>
	    <tr>
	      <th width=20% class="text-right">비밀번호</th>
	      <td width=80%>
	        <input type=password name=pwd size=10 class="input-sm">
	      </td>
	    </tr>
	    <tr>
	      <td colspan="2" class="text-center">
	        <input type=submit value="답변" class="btn btn-sm btn-danger">
	        <input type=button value="취소" onclick="javascript:history.back()"
	         class="btn btn-sm btn-success"
	        >
	      </td> 
	    </tr>
	   </table>
	   </form>
	  </div>
	</div>
</body>
</html>