<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Food&Recipe</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="../css/layout.css" rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body id="top">
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row1">
  <header id="header" class="clear"> 
    <!-- ################################################################################################ -->
    <div id="logo" class="fl_left">
      <h1><a href="index.html">맛집 & 레시피</a></h1>
    </div>
    <div class="fl_right">
      <ul class="inline">
        <li>ID:<input type=text name=id class="input-xs" size=10></li>
        <li>Password:<input type=password name=pwd class="input-xs" size=10></li>
        <li><input type=button value=로그인 class="btn btn-sm btn-primary"></li>
      </ul>
    </div>
    <!-- ################################################################################################ --> 
  </header>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row2">
  <nav id="mainav" class="clear"> 
    <!-- ################################################################################################ -->
    <ul class="clear">
      <li class="active"><a href="index.html">Home</a></li>
      <li><a class="drop" href="#">회원가입</a>
        <ul>
          <li><a href="pages/gallery.html">회원가입</a></li>
          <li><a href="pages/full-width.html">아이디찾기</a></li>
          <li><a href="pages/sidebar-left.html">비밀번호찾기</a></li>
        </ul>
      </li>
      <!--<li><a class="drop" href="#">회원수정</a>
        <ul>
          <li><a href="pages/gallery.html">회원수정</a></li>
          <li><a href="pages/full-width.html">비밀번호변경</a></li>
          <li><a href="pages/sidebar-left.html">회원탈퇴</a></li>
        </ul>
      </li>-->
      <li><a class="drop" href="#">맛집</a>
        <ul>
          <li><a href="#">지역별맛집</a></li>
          <li><a href="#">맛집추천</a></li>
          <li><a href="#">맛집예약</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">레시피</a>
        <ul>
          <li><a href="#">레시피</a></li>
          <li><a href="#">쉐프</a></li>
          <li><a href="#">오늘의 레시피</a></li>
          <li><a href="#">오늘의 쉐프</a></li>
          <li><a href="#">인기 레시피</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">커뮤니티</a>
        <ul>
          <li><a href="#">자유게시판</a></li>
          <li><a href="#">묻고답하기</a></li>
          <li><a href="#">후기게시판</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">뉴스</a>
        <ul>
          <li><a href="#">맛집뉴스</a></li>
          <li><a href="#">레시피뉴스</a></li>
          <li><a href="#">전체뉴스</a></li>
        </ul>
      </li>
      <li><a href="#">마이페이지</a></li>
      <!-- <li><a href="#">관리자페이지</a></li>-->
    </ul>
    <!-- ################################################################################################ --> 
  </nav>
</div>
<!-- 내용이 들어가는 위치 -->
   <jsp:include page="home.jsp"></jsp:include>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->

<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row4">
  <footer id="footer" class="clear"> 
    <!-- ################################################################################################ -->
     <p class="text-center">
       강북쌍용교육센터 G강의장
     </p>
    <!-- ################################################################################################ --> 
  </footer>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<!-- <div class="wrapper row5">
  <div id="copyright" class="clear"> 
    ################################################################################################
    <p class="fl_left">Copyright &copy; 2018 - All Rights Reserved - <a href="#">Domain Name</a></p>
    <p class="fl_right">Template by <a target="_blank" href="https://www.os-templates.com/" title="Free Website Templates">OS Templates</a></p>
    ################################################################################################ 
  </div>
</div> -->

<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a> 
<!-- JAVASCRIPTS --> 
<script src="../js/jquery.min.js"></script> 
<script src="../js/jquery.backtotop.js"></script> 
<script src="../js/jquery.mobilemenu.js"></script> 
<script src="../js/jquery.flexslider-min.js"></script>
</body>
</html>