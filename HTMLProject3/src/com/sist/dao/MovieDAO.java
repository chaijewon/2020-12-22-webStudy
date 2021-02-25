package com.sist.dao;
import java.util.*;// �����͸� ��Ƽ� => �������� ����
import java.sql.*;//JDBC => �����ͺ��̽� ����
public class MovieDAO {
   // 1. �����ͺ��̽� ���� ��ü 
   private Connection conn;
   // 2. ����Ŭ�� �����ϱ� ���ؼ��� SQL������ ���� 
   private PreparedStatement ps;// PL/SQL CallableStatement(�Լ�)
   // 3. ����Ŭ �ּ� ����
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   // 4. �����ϱ� ���� ����̹� ��ġ
   public MovieDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");//Ŭ�������� ��ҹ��� ����
	   }catch(Exception ex){}
   }
   // 5. ����Ŭ ����  conn hr/happy
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
	   }catch(Exception ex) {}
   }
   // 6. ����Ŭ ����  exit
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   // ����Ŭ ����� �ʼ� ���� 
   // ��ȭ�� ���õ� SQL���� ���� => �����͸� �޴´� 
   // 1. ��ȭ ��� ��� => 1������ 20���� ���  1���� MovieVO�� ���� => ArrayList<MovieVO>
   public ArrayList<MovieVO> movieListData(int page) //�Ű����� => page�� ����� ����
   {
	   ArrayList<MovieVO> list=new ArrayList<MovieVO>();//list=>MovieVO�� 20���� ä���
	   try
	   {
		   // 1. ����
		   getConnection();
		   // 2. SQL���� 
		   String sql="SELECT mno,title,poster,director,num "
				     +"FROM (SELECT mno,title,poster,director,rownum as num "
				     +"FROM (SELECT mno,title,poster,director "
				     +"FROM movie ORDER BY mno ASC)) "
				     +"WHERE num BETWEEN ? AND ?"; // �ζ��κ� => ����¡ ���
		   ps=conn.prepareStatement(sql);
		   // 2-1. ?�� ���� ä��� 
		   int rowSize=20;
		   int start=(page*rowSize)-(rowSize-1);
		   int end = page*rowSize;
		   
		   ps.setInt(1, start);
		   ps.setInt(2, end);
		   /*
		    *    1page => 1~20     1*20-19 => 1
		    *             = ==
		    *    2page => 21~40     2*20-19 => 21  => rownum�� 1������ �����Ѵ� 
		    */
		   // 3. SQL���� ���� ��û 
		   // 4. ������� �޾� �´� 
		   // ������� �޸𸮿� ���� => ResultSet
		   ResultSet rs=ps.executeQuery(); // executeUpdate() => COMMIT�� ÷�� 
		   // SELECT => ������� �о�´� , INSERT,UPDATE,DELETE=>���� (COMMIT)
		   // 5. ������� MovieVO�� ����=> ArrayList�� ���� 
		   while(rs.next())
		   {
			   MovieVO vo=new MovieVO();// 20���� �޸𸮿� ���� ���� 
			   // mno,title,poster,director
			   vo.setMno(rs.getInt(1));
			   vo.setTitle(rs.getString(2));
			   vo.setPoster(rs.getString(3));
			   vo.setDirector(rs.getString(4));
			   list.add(vo); // list=> 20���� VO�� ����ȴ� 
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   // ���� ��� 
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   // ����
		   disConnection();
	   }
	   return list;
   }
   // 1-1. �������� ���Ѵ� 
   public int movieTotalPage()
   {
	   int total=0;
	   try
	   {
		   // 1. ����
		   getConnection();
		   // 2. SQL����
		   String sql="SELECT CEIL(COUNT(*)/20.0) FROM movie";// �ø��Լ� 1938/20.0
		   // 20.1 => 21
		   // 3. SQL���� ���� ��û
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   rs.next(); // ������ �����ġ�� Ŀ������ 
		   // 4. ������� �޴´� 
		   total=rs.getInt(1);
		   rs.close();
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   // �ݱ�
		   disConnection();
	   }
	   return total;
   }
   // 2. �󼼺��� 
   public MovieVO movieDetailData(int mno)
   {
	   MovieVO vo=new MovieVO();
	   try
	   {
		   // 1. ����
		   getConnection();
		   // 2. SQL���� ����
		   String sql="SELECT mno,poster,title,director,grade,genre,actor,regdate "
				     +"FROM movie "
				     +"WHERE mno=?";
		   ps=conn.prepareStatement(sql);
		   // 3. ?�� ���� ä���
		   ps.setInt(1, mno);
		   // 4. SQL���� ���� ��û
		   ResultSet rs=ps.executeQuery();
		   // 5. ������� MovieVO�� ä���ش� 
		   rs.next();
		   vo.setMno(rs.getInt(1));
		   vo.setPoster(rs.getString(2));
		   vo.setTitle(rs.getString(3));
		   vo.setDirector(rs.getString(4));
		   vo.setGrade(rs.getString(5));
		   vo.setGenre(rs.getString(6));
		   vo.setActor(rs.getString(7));
		   vo.setRegdate(rs.getString(8));
		   rs.close();
	   }catch(Exception ex)
	   {
		   // ���� ����
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   // �ݱ�
		   disConnection();
	   }
	   return vo;
   }
}













