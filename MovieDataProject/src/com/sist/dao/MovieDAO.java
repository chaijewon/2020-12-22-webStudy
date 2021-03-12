package com.sist.dao;
import java.util.*;
import java.sql.*;
public class MovieDAO {
  private Connection conn;
  private PreparedStatement ps;
  private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
  public MovieDAO()
  {
	  try
	  {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
	  }catch(Exception ex) {}
  }
  public void getConnection()
  {
	  try
	  {
		  conn=DriverManager.getConnection(URL,"hr","happy");
	  }catch(Exception ex) {}
  }
  public void disConnection()
  {
	  try
	  {
		  if(ps!=null) ps.close();
		  if(conn!=null) ps.close();
	  }catch(Exception ex) {}
  }
  // 데이터 추가
  /*
   *   mno NUMBER, -- 영화의 고유번호 (SEQUENCE)
	   cno NUMBER, -- 카테고리 번호
	   poster VARCHAR2(260) CONSTRAINT dm_poster_nn NOT NULL, 
	   title VARCHAR2(200) CONSTRAINT dm_title_nn NOT NULL,
	   regdate VARCHAR2(200) CONSTRAINT dm_regdate_nn NOT NULL,
	   genre VARCHAR2(100) CONSTRAINT dm_genre_nn NOT NULL,
	   nation VARCHAR2(50) CONSTRAINT dm_nation_nn NOT NULL,
	   grade VARCHAR2(50) CONSTRAINT dm_grade_nn NOT NULL,
	   time VARCHAR2(50) CONSTRAINT dm_time_nn NOT NULL,
	   score NUMBER(2,1),
	   showUser VARCHAR2(30),
	   boxoffice VARCHAR2(10),
	   story CLOB,
	   key VARCHAR2(30)
   */
  public void movieInsert(MovieVO vo)
  {
	  try
	  {
		  // 연결 
		  getConnection();
		  String sql="INSERT INTO daum_movie VALUES("
				    +"dm_mno_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,0)";
		  ps=conn.prepareStatement(sql);
		  // ?에 값을 채운다 
		  ps.setInt(1, vo.getCno());
		  ps.setString(2, vo.getPoster());
		  ps.setString(3, vo.getTitle());
		  ps.setString(4, vo.getRegdate());
		  ps.setString(5, vo.getGenre());
		  ps.setString(6, vo.getNation());
		  ps.setString(7, vo.getGrade());
		  ps.setString(8, vo.getTime());
		  ps.setDouble(9, vo.getScore());
		  ps.setString(10, vo.getShowUser());
		  ps.setString(11, vo.getBoxoffice());
		  ps.setString(12, vo.getStory());
		  ps.setString(13, vo.getKey());
		  
		  // 실행
		  ps.executeUpdate();
		  
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  disConnection();
	  }
  }
}








