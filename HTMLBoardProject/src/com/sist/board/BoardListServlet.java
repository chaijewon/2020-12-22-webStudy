package com.sist.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;
@WebServlet("/BoardListServlet")
// BoardListServlet a=new BoardListServlet();
// �� => main(X) , ����,JSP=> �޸� �Ҵ� (��Ĺ) ����?����=��
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. ���� => �������� ���� (HTML,XML)
		response.setContentType("text/html;charset=EUC-KR");// text/xml;charset=EUC-KR
		//2. ��� ��ǻ�ͷ� ���� ���� ���� 
		PrintWriter out=response.getWriter();// �ش� Ŭ���̾�Ʈ�� HTML�� ����
		/*
		 *   ������ �ޱ� 
		 *   http://211.238.142.181/HTMLBoardProject/BoardListServlet
		 */
		//1. ������ => ����� ��û�� ������ �ޱ� 
		String page=request.getParameter("page");
		// 2. ó������ ������ ���� (X) => ����Ʈ
		if(page==null)
			page="1";
		// ���� ������ ���� 
		int curpage=Integer.parseInt(page);
		// �������� ���� 
		BoardDAO dao=new BoardDAO();
		int count=dao.boardRowCount();// ��ȣ������ ��� 
		int totalpage=(int)(Math.ceil(count/10.0));
		// �������� ������ �б�
		ArrayList<BoardVO> list=dao.boardListData(curpage);
		//3. � HTML ���� 
		out.println("<html>");
		out.println("<head>");
		out.println("<style type=text/css>");
		out.println("td,th{font-family:���� ���;font-size:9pt;height:35px}");
		out.println(".table_main{border-collapse:collapse;");
		out.println("border-top-width: 2px;"
				+ "border-bottom-width: 1px;"
				+ "border-top-style: solid;"
				+ "border-bottom-style: solid;"
				+ "border-top-color: #333;"
				+ "border-bottom-color: #333;}");
		out.println(".table_main th{");
		out.println("background-color: #999;"
				+ "color: #fff;"
				+ "border-bottom-width: 1px;"
				+ "border-bottom-color: #333;}");
		out.println(".table_main td{");
		out.println("border-bottom-width: 1px;"
				+ "border-bottom-color: #666;"
				+ "border-bottom-style: dotted;}");
		out.println("a{color:black;text-decoration:none}");
		out.println("a:hover{color:green;text-decoration:underline}");
		out.println(".dataTr:HOVER {"
				+ "background-color: #FC6;"
				+ "cursor: pointer;"
				+ "cursor: hand;"
				+ "}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>�Խ���</h1>");
		out.println("<table border=0 width=700>");
		out.println("<tr>");
		out.println("<td><a href=BoardInsertServlet>����</a></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<div style=\"height:400px\">");
		out.println("<table width=700 class=table_main>");
		out.println("<tr id=head>");
		out.println("<th width=10%>��ȣ</th>");
		out.println("<th width=45%>����</th>");
		out.println("<th width=15%>�̸�</th>");
		out.println("<th width=20%>�ۼ���</th>");
		out.println("<th width=10%>��ȸ��</th>");
		out.println("</tr>");
		// �����͸� ����ϴ� ��ġ 
		for(BoardVO vo:list)
		{
			out.println("<tr class=dataTr>");
			out.println("<td width=10% align=center>"+vo.getNo()+"</td>");
			String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String dbday=vo.getRegdate().toString();
			// YY/MM/DD => java => yyyy-MM-dd
			out.println("<td width=45%><a href=BoardDetailServlet?no="+vo.getNo()+">"+vo.getSubject()+"</a>");
			if(today.equals(dbday))
			{
				out.println("<sup><font color=red>new</font></sup>");
			}
			out.println("</td>");
			out.println("<td width=15% align=center>"+vo.getName()+"</td>");
			out.println("<td width=20% align=center>"+vo.getRegdate().toString()+"</td>");
			out.println("<td width=10% align=center>"+vo.getHit()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		// �ϴ�
		out.println("<table width=700>");
		out.println("<tr>");
		out.println("<td align=left>");
		out.println("Search:");
		out.println("<select name=fs>");
		out.println("<option value=name>�̸�</option>");
		out.println("<option value=subject>����</option>");
		out.println("<option value=content>����</option>");
		out.println("</select>");
		out.println("<input type=text name=ss size=10>");
		out.println("<input type=submit value=�˻�>");
		out.println("</td>");
		out.println("<td align=right>");
		out.println("<a href=BoardListServlet?page="+(curpage>1?curpage-1:curpage)+">����</a>&nbsp;");
		out.println(curpage+" page / "+totalpage+" pages&nbsp;");
		out.println("<a href=BoardListServlet?page="+(curpage<totalpage?curpage+1:curpage)+">����</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
	}

}







