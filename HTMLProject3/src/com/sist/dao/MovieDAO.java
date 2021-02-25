package com.sist.dao;
import java.util.*;// 데이터를 모아서 => 브라우저로 전송
import java.sql.*;//JDBC => 데이터베이스 연결
public class MovieDAO {
   // 1. 데이터베이스 연결 객체 
   private Connection conn;
   // 2. 오라클이 실행하기 위해서는 SQL문장을 전송 
   private PreparedStatement ps;// PL/SQL CallableStatement(함수)
   // 3. 오라클 주소 설정
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   // 4. 연결하기 위한 드라이버 설치
   public MovieDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");//클래스명은 대소문자 구분
	   }catch(Exception ex){}
   }
   // 5. 오라클 연결  conn hr/happy
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
	   }catch(Exception ex) {}
   }
   // 6. 오라클 종료  exit
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   // 오라클 연결시 필수 사항 
   // 영화와 관련된 SQL문장 전송 => 데이터를 받는다 
   // 1. 영화 목록 출력 => 1페이지 20개를 출력  1개당 MovieVO에 저장 => ArrayList<MovieVO>
   public ArrayList<MovieVO> movieListData(int page) //매개변수 => page는 사용자 전송
   {
	   ArrayList<MovieVO> list=new ArrayList<MovieVO>();//list=>MovieVO를 20개를 채운다
	   try
	   {
		   // 1. 연결
		   getConnection();
		   // 2. SQL문장 
		   String sql="SELECT mno,title,poster,director,num "
				     +"FROM (SELECT mno,title,poster,director,rownum as num "
				     +"FROM (SELECT mno,title,poster,director "
				     +"FROM movie ORDER BY mno ASC)) "
				     +"WHERE num BETWEEN ? AND ?"; // 인라인뷰 => 페이징 기법
		   ps=conn.prepareStatement(sql);
		   // 2-1. ?에 값을 채운다 
		   int rowSize=20;
		   int start=(page*rowSize)-(rowSize-1);
		   int end = page*rowSize;
		   
		   ps.setInt(1, start);
		   ps.setInt(2, end);
		   /*
		    *    1page => 1~20     1*20-19 => 1
		    *             = ==
		    *    2page => 21~40     2*20-19 => 21  => rownum은 1번부터 시작한다 
		    */
		   // 3. SQL문장 실행 요청 
		   // 4. 결과값을 받아 온다 
		   // 결과값은 메모리에 저장 => ResultSet
		   ResultSet rs=ps.executeQuery(); // executeUpdate() => COMMIT이 첨부 
		   // SELECT => 결과값을 읽어온다 , INSERT,UPDATE,DELETE=>실행 (COMMIT)
		   // 5. 결과값을 MovieVO에 설정=> ArrayList에 저장 
		   while(rs.next())
		   {
			   MovieVO vo=new MovieVO();// 20개를 메모리에 따로 저장 
			   // mno,title,poster,director
			   vo.setMno(rs.getInt(1));
			   vo.setTitle(rs.getString(2));
			   vo.setPoster(rs.getString(3));
			   vo.setDirector(rs.getString(4));
			   list.add(vo); // list=> 20개의 VO가 저장된다 
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   // 에러 출력 
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   // 종료
		   disConnection();
	   }
	   return list;
   }
   // 1-1. 총페이지 구한다 
   public int movieTotalPage()
   {
	   int total=0;
	   try
	   {
		   // 1. 연결
		   getConnection();
		   // 2. SQL문장
		   String sql="SELECT CEIL(COUNT(*)/20.0) FROM movie";// 올림함수 1938/20.0
		   // 20.1 => 21
		   // 3. SQL문장 실행 요청
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   rs.next(); // 데이터 출력위치에 커서변경 
		   // 4. 결과값을 받는다 
		   total=rs.getInt(1);
		   rs.close();
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   // 닫기
		   disConnection();
	   }
	   return total;
   }
   // 2. 상세보기 
   public MovieVO movieDetailData(int mno)
   {
	   MovieVO vo=new MovieVO();
	   try
	   {
		   // 1. 연결
		   getConnection();
		   // 2. SQL문장 제작
		   String sql="SELECT mno,poster,title,director,grade,genre,actor,regdate "
				     +"FROM movie "
				     +"WHERE mno=?";
		   ps=conn.prepareStatement(sql);
		   // 3. ?에 값을 채운다
		   ps.setInt(1, mno);
		   // 4. SQL문장 실행 요청
		   ResultSet rs=ps.executeQuery();
		   // 5. 결과값을 MovieVO에 채워준다 
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
		   // 오류 점검
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   // 닫기
		   disConnection();
	   }
	   return vo;
   }
}













