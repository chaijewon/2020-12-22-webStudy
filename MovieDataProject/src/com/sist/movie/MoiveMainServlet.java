package com.sist.movie;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MoiveMainServlet")
public class MoiveMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// html 전송
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
		out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
		out.println("<style>");
		out.println(".row{");
		out.println("width:960px;margin:0px auto}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<nav class=\"navbar navbar-inverse\">\r\n"
				+ "  <div class=\"container-fluid\">\r\n"
				+ "    <div class=\"navbar-header\">\r\n"
				+ "      <a class=\"navbar-brand\" href=\"#\">SIST Movie</a>\r\n"
				+ "    </div>\r\n"
				+ "    <ul class=\"nav navbar-nav\">\r\n"
				+ "      <li class=\"active\"><a href=\"#\">Home</a></li>\r\n"
				+ "      <li class=\"dropdown\">\r\n"
				+ "        <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">랭킹\r\n"
				+ "        <span class=\"caret\"></span></a>\r\n"
				+ "        <ul class=\"dropdown-menu\">\r\n"
				+ "          <li><a href=\"#\">예매순위</a></li>\r\n"
				+ "          <li><a href=\"#\">박스오피스</a></li>\r\n"
				+ "          <li><a href=\"#\">OTT</a></li>\r\n"
				+ "        </ul>\r\n"
				+ "      </li>\r\n"
				+ "      <li class=\"dropdown\">\r\n"
				+ "        <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">상영/예정작\r\n"
				+ "        <span class=\"caret\"></span></a>\r\n"
				+ "        <ul class=\"dropdown-menu\">\r\n"
				+ "          <li><a href=\"#\">넷플릭스</a></li>\r\n"
				+ "          <li><a href=\"#\">왓차</a></li>\r\n"
				+ "          <li><a href=\"#\">카카오페이지</a></li>\r\n"
				+ "        </ul>\r\n"
				+ "      </li>\r\n"
				+ "      <li><a href=\"#\">영화뉴스</a></li>\r\n"
				+ "    </ul>\r\n"
				+ "  </div>\r\n"
				+ "</nav>");
		out.println("<div style=\"height:50px\"></div>");
		RequestDispatcher rd=request.getRequestDispatcher("MovieHomeServlet");
		rd.include(request, response);
		out.println("</body>");
		out.println("</html>");
	}

}











