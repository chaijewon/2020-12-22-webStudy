<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*,java.util.*"%>
<%--
      main.jsp?mode=2&no=10
      ===============
        detail.jsp?no=10
 --%>
<jsp:useBean id="dao" class="com.sist.dao.FoodDAO"></jsp:useBean>
<%
    String no=request.getParameter("no");
    String cno=request.getParameter("cno");
    FoodVO vo=dao.foodDetailData(Integer.parseInt(no));
    String s=vo.getAddress();
    String ss=s.substring(s.indexOf(" ")+1);
    ss=ss.substring(0,ss.indexOf(" "));
    System.out.println(ss);
    List<FoodVO> list=dao.foodLocation(ss);
    // 부평구 경인로 952
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="row">
   <table class="table">
     <tr>
      <%
         StringTokenizer st=new StringTokenizer(vo.getPoster(),"^");
         while(st.hasMoreTokens())
         {
      %>
            <td><img src="<%=st.nextToken() %>" width=100%></td>
      <%
         }
      %>
     </tr>
   </table>
  </div>
  <div class="row">
    <div class="col-sm-6">
      <table class="table">
        <tr>
          <td>
            <h3><%=vo.getTitle() %>&nbsp;<span style="color:orange"><%=vo.getScore() %></span></h3>
          </td>
        </tr>
      </table>
      <table class="table">
       <tr>
         <th width=20% class="text-right">주소</th>
         <td width=80%><%=vo.getAddress().substring(0,vo.getAddress().lastIndexOf("지")) %></td>
       </tr>
       <tr>
         <th width=20% class="text-right">전화</th>
         <td width=80%><%=vo.getTel() %></td>
       </tr>
       <tr>
         <th width=20% class="text-right">음식 종류</th>
         <td width=80%><%=vo.getType() %></td>
       </tr>
       <tr>
         <th width=20% class="text-right">가격대</th>
         <td width=80%><%=vo.getPrice() %></td>
       </tr>
       <tr>
         <th width=20% class="text-right">주차</th>
         <td width=80%><%=vo.getParking() %></td>
       </tr>
       <tr>
         <th width=20% class="text-right">영업시간</th>
         <td width=80%><%=vo.getTime() %></td>
       </tr>
       <%
          // no  원
          if(!vo.getMenu().equals("no"))
          {
       %>
       <tr>
         <th width=20% class="text-right">메뉴</th>
         <td width=80%>
           <ul style="list-style-type: none">
           <%
               st=new StringTokenizer(vo.getMenu(),"원");
               while(st.hasMoreTokens())
               {
           %>
                  <li><%=st.nextToken().trim() %>원</li>
           <%
               }
               
           %>
           </ul>
         </td>
       </tr>
       <%
          }
       %>
      </table>
    </div>
    <div class="col-sm-6">
      <div id="map" style="width:100%;height:350px;"></div>
      <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=db0485ed4f0d0ece879a4510ed7f48e6&libraries=services"></script>
      <script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };  
		
		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch('<%=vo.getAddress().substring(0,vo.getAddress().lastIndexOf("지")) %>', function(result, status) {
		
		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {
		
		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		
		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });
		
		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;"><%=vo.getTitle()%></div>'
		        });
		        infowindow.open(map, marker);
		
		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});    
		</script>
		<div style="height:20px"></div>
		<table class="table">
		 <caption><b>주변 인기 맛집</b></caption>
		 <%
		    for(FoodVO fvo:list)
		    {
		 %>
		       <tr>
		         <td><img src="<%=fvo.getPoster().substring(0,fvo.getPoster().indexOf("^")) %>" width=30 height=30></td>
		         <td><%=fvo.getTitle() %></td>
		         <td><%=fvo.getType() %></td>
		         <td><%=fvo.getPrice() %></td>
		       </tr>
		 <%
		    }
		 %>
		</table>
    </div>
    <div style="height:30px"></div>
    <div class="row">
     <table class="table">
      <tr>
       <td class="text-right">
        <a href="#" class="btn btn-sm btn-danger">예약</a>
        <a href="#" class="btn btn-sm btn-success">찜하기</a>
        <a href="main.jsp?mode=1&cno=<%=cno %>" class="btn btn-sm btn-primary">목록</a>
       </td>
      </tr>
     </table>
     <table class="table">
      <tr>
       <td class="text-right">
        맛있다 (<%=vo.getGood() %>)&nbsp;괜찮다 (<%=vo.getSoso() %>)&nbsp;별로 (<%=vo.getBad() %>)
       </td>
      </tr>
     </table>
     
    </div>
  </div>
</body>
</html>











