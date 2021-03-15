package com.sist.movie;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;
@WebServlet("/MovieReserveServlet")
public class MovieReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		// 데이터 받기
		MovieDAO dao=new MovieDAO();
		ArrayList<MovieVO> list=dao.movieListData(1);
		
		out.println("<div class=container>");
		out.println("<h1 class=text-center>예매순위</h1>");
		out.println("<div class=row>");
		// 웹 프로그램은 데이터를 다른 클래스로 전송 => ?를 이용해서 데이터를 전송 
		// ?키=값
		// ?키=값&키=값 ==> HTML은 값을 받을 수 없다 => 자바 : request.getParameter("키")
		// HTML:화면만 출력 , CSS:화면 디자인 => 정적페이지  => 자바 System.out.println()
		// 자바 (프로그램 언어를 이용해서 처리 => 서블릿 , JSP)
		// C# => Asp,Asp.net
		/*
		 *   실무 
		 *     MVC 
		 *     ===
		 *      M(Model) : 자바
		 *                 ====
		 *                   데이터를 관리(송신,수신) : 오라클 , XML(문서형 데이터베이스), JSON
		 *                                               =========================
		 *      V(View)  : 태그형 => HTML , CSS , JavaScript
		 *                                      ===========
		 *                                       Jquery,VueJs,ReactJS
		 *      =================
		 *      C(Controller) : Model+View  => 서블릿 (스프링)
		 *                                           ===== 사용(X) , 직접 제작 
		 *          
		 *      서블릿명?키=값  => 앞에 있는 서블릿클래스에서 받아서 처리
		 *      a.jsp?키=값  => 앞에 있는 JSP가 값을 받아서 처리 
		 */
		for(MovieVO vo:list)
		{
			out.println("<div class=\"col-md-3\">\r\n"
					+ "    <div class=\"thumbnail\">\r\n"
					+ "      <a href=\"MovieMainServlet?mode=8&mno="+vo.getMno()+"\">\r\n"
					+ "        <img src=\""+vo.getPoster()+"\" alt=\"Lights\" style=\"width:100%\">\r\n"
					+ "        <div class=\"caption\">\r\n"
					+ "          <p style=\"font-size:9pt\">"+vo.getTitle()+"</p>\r\n"
					+ "        </div>\r\n"
					+ "      </a>\r\n"
					+ "    </div>\r\n"
					+ "  </div>");
		}
		out.println("</div>");
		out.println("</div>");
	}

}








