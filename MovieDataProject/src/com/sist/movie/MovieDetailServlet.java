package com.sist.movie;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;
@WebServlet("/MovieDetailServlet")
public class MovieDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   // 화면 출력 
	   response.setContentType("text/html;charset=UTF-8");
	   // JSP <%@ page contentType="text/html;charset=UTF-8"%>
	   // HTML을 출력할 위치 확인 
	   PrintWriter out=response.getWriter();
	   // JSP에서는 내장객체(미리 생성) => <% out.println("<html>") %>
	   // 오라클 출력을 위한 사용자 보내준 데이터 읽기 
	   // "MovieDetailServlet? mno = 5"  ==> NumberFormatException
	   String mno=request.getParameter("mno"); // 필요시에 받드시 변환 
	   /*
	    *   Wrapper 
	    *     정수 : Integer.parseInt(문자열)
	    *     실수 : Double.parseDouble()
	    *     논리 : Boolean.parseBoolean()
	    */
	   // => Web => 데이터형이 없다 (문자열)
	   // 오라클에서 데이터를 읽어온다 
	   MovieDAO dao=new MovieDAO();
	   MovieVO vo=dao.movieDetailData(Integer.parseInt(mno));
	   // HTML(출력)+자바(데이터 읽기)  => 순서 (자바 => HTML)
	   // MVC => M => V => C (현재 실무에서 사용되는 기술)
	   // HTML을 이용해서 데이터를 출력한다 
	   out.println("<div class=container>");
	   out.println("<h1 class=text-center>&lt;"+vo.getTitle()+"&gt;상세보기</h1>");
	   out.println("<div class=row>");
	   out.println("<table class=\"table\">");
	   out.println("<tr>");
	   out.println("<td class=text-center>");
	   out.println("<embed src=\"http://youtube.com/embed/"+vo.getKey()+"\" width=800 height=350>");
	   out.println("</td>");
	   out.println("</tr>");
	   out.println("</table>");
	   out.println("<table class=\"table table-striped\">");
	   out.println("<tr>");
	   out.println("<td width=30% rowspan=9 class=text-center>");
	   out.println("<img src="+vo.getPoster()+" width=100%>");
	   out.println("</td>");
	   out.println("<td colspan=2 style=\"color:orange\">"+vo.getTitle()+"</td>");
	   out.println("</tr>");
	   out.println("<tr>");
	   out.println("<th width=10% class=\"text-right danger\">개봉</th>");
	   out.println("<td width=60%>");
	   out.println(vo.getRegdate());
	   out.println("</td>");
	   out.println("</tr>");
	   /*
	    *   개봉	2021.01.27
			장르	애니메이션/판타지/액션/시대극
			국가	일본
			등급	15세이상관람가
			러닝타임	117분
			평점	5.9
			누적관객	1,197,951명
			박스오피스	1위
	    */
	   out.println("<tr>");
	   out.println("<th width=10% class=\"text-right danger\">장르</th>");
	   out.println("<td width=60%>");
	   out.println(vo.getGenre());
	   out.println("</td>");
	   out.println("</tr>");
	   
	   out.println("<tr>");
	   out.println("<th width=10% class=\"text-right danger\">국가</th>");
	   out.println("<td width=60%>");
	   out.println(vo.getNation());
	   out.println("</td>");
	   out.println("</tr>");
	   
	   out.println("<tr>");
	   out.println("<th width=10% class=\"text-right danger\">등급</th>");
	   out.println("<td width=60%>");
	   out.println(vo.getGrade());
	   out.println("</td>");
	   out.println("</tr>");
	   
	   out.println("<tr>");
	   out.println("<th width=10% class=\"text-right danger\">러닝타입</th>");
	   out.println("<td width=60%>");
	   out.println(vo.getTime());
	   out.println("</td>");
	   out.println("</tr>");
	   
	   out.println("<tr>");
	   out.println("<th width=10% class=\"text-right danger\">평점</th>");
	   out.println("<td width=60%>");
	   out.println(vo.getScore());
	   out.println("</td>");
	   out.println("</tr>");
	   
	   out.println("<tr>");
	   out.println("<th width=10% class=\"text-right danger\">누적관객</th>");
	   out.println("<td width=60%>");
	   out.println(vo.getShowUser());
	   out.println("</td>");
	   out.println("</tr>");
	   
	   out.println("<tr>");
	   out.println("<th width=10% class=\"text-right danger\">박스오피스</th>");
	   out.println("<td width=60%>");
	   out.println(vo.getBoxoffice());
	   out.println("</td>");
	   out.println("</tr>");
	   
	   out.println("<tr>");
	   out.println("<td colspan=3 valign=top class=text-left>");
	   out.println(vo.getStory());
	   out.println("<td>");
	   out.println("</tr>");
	   
	   out.println("<tr>");
	   out.println("<td colspan=3 class=text-right>");
	   out.println("<a href=# class=\"btn btn-sm btn-success\">예매하기</a>");
	   out.println("<a href=# class=\"btn btn-sm btn-info\">찜하기</a>");
	   out.println("<a href=# class=\"btn btn-sm btn-danger\">좋아요</a>");
	   out.println("<a href=MovieMainServlet?mode=1 class=\"btn btn-sm btn-warning\">목록</a>");
	   out.println("<td>");
	   out.println("</tr>");
	   
	   
	   out.println("</table>");
	   out.println("</div>");
	   out.println("</div>");
	   
	}

}










