package com.sist.main;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;// ����Ŭ ���� => �����͸� ������ �´� 
@WebServlet("/MovieListServlet")
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request : ����ڰ� ������ �����͸� �޴� ��� => BufferedReader
		// response : ó������� �������� ����  => OutputStream
		// 1. ���� => ���� (���������� ���� => HTML,XML)
		response.setContentType("text/html;charset=EUC-KR");
		// �������� �����ϴµ� html�� ������ (�� �ѱ��� �ִ�) => euc-kr (��ҹ��� ������ ����)
		// xml�� ���� => text/xml , json => text/plain => AJAX(�ǽð�) => ȭ�� ������ ���� 
		// 2. �������� �������� ���� 
		PrintWriter out=response.getWriter();
		// ������ ��û�� ������ �޸� ��ġ
		// http://211.238.142.181/
		// 1. ���� ������ 
		int curpage=1;
		MovieDAO dao=new MovieDAO();
		// 2. �������� 
		int totalpage=dao.movieTotalPage();
		// 3. ��ȭ���� 20�� => ArrayList
		ArrayList<MovieVO> list=dao.movieListData(curpage);
		out.write("<html>");
		out.write("<body>");
		out.write("<center>");
		out.write("<h1>��ȭ ���</h1>");
		out.write("<table border=1 bordercolor=black width=800>");
		out.write("<tr bgcolor=#ccffcc>");
		out.write("<th>����</th>");
		out.write("<th></th>");
		out.write("<th>��ȭ��</th>");
		out.write("<th>������</th>");
		out.write("</tr>");
		for(MovieVO vo:list) // ���� ������ ���
		{
			out.write("<tr>");
			out.write("<td>"+vo.getMno()+"</td>");
			out.write("<td align=center><img src="+vo.getPoster()+" width=30 height=30></td>");
			out.write("<td><a href=MovieDetailServlet?mno="+vo.getMno()+">"+vo.getTitle()+"</a></td>");
			// web������ �ٸ� Ŭ������ ���� ���۽ÿ� ?�ڿ� ���� �����ؼ� ������ 
			/*
			 *    ?�ڿ� �ٿ��� �����ϴ� ���  =====> GET
			 *    ���ܼ� ������ ��� (id,pwd) ===> POST
			 */
			out.write("<td>"+vo.getDirector()+"</td>");
			out.write("</tr>");
		}
		out.write("</table>");
		out.write("</center>");
		out.write("</body>");
		out.write("</html>");
	}

}














