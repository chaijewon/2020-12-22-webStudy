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
  public ArrayList<MovieVO> movieListData(int cno)
  {
	  ArrayList<MovieVO> list=new ArrayList<MovieVO>();
	  try
	  {
		  //1. 연결
		  getConnection();
		  //2. SQL문장 
		  String sql="SELECT mno,poster,title "
				    +"FROM daum_movie "
				    +"WHERE cno=? "
				    +"ORDER BY mno ASC";
		  ps=conn.prepareStatement(sql);
		  // ? 에 값
		  ps.setInt(1, cno);
		  // 결과값 읽기
		  ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
			  MovieVO vo=new MovieVO();
			  vo.setMno(rs.getInt(1));
			  vo.setPoster(rs.getString(2));
			  vo.setTitle(rs.getString(3));
			  
			  list.add(vo);
		  }
		  rs.close();
	  }catch(Exception ex)
	  {
		  ex.printStackTrace();
	  }
	  finally
	  {
		  // 해제
		  disConnection();
	  }
	  return list;
  }
  // 영화 상세보기
  /*
   *   JDBC (DAO) => 오라클 열기 : SQL전송 : 실행 (결과값) => 오라클 닫기
   *                 ========                          ======== 시간이 오래 걸린다
   *    => DBCP      => 미리 Connection생성 => 주소연결
   *    => ORM (실무) => 마이바티스
   *    
   *    MNO       NOT NULL NUMBER         
		CNO                NUMBER         
		POSTER    NOT NULL VARCHAR2(260)  
		TITLE     NOT NULL VARCHAR2(200)  
		REGDATE   NOT NULL VARCHAR2(200)  
		GENRE     NOT NULL VARCHAR2(100)  
		NATION    NOT NULL VARCHAR2(50)   
		GRADE     NOT NULL VARCHAR2(50)   
		TIME      NOT NULL VARCHAR2(50)   
		SCORE              NUMBER(2,1)    
		SHOWUSER           VARCHAR2(30)   
		BOXOFFICE          VARCHAR2(10)   
		STORY              CLOB           
		KEY                VARCHAR2(30)
   */
  public MovieVO movieDetailData(int mno)
  {
	  MovieVO vo=new MovieVO();
	  try
	  {
		  // 1. 연결
		  getConnection();
		  // 2. SQL문장을 보낸다 
		  String sql="SELECT mno,poster,title,regdate,genre,nation,grade,"
				    +"time,score,showuser,boxoffice,story,key "
				    +"FROM daum_movie "
				    +"WHERE mno=?";
		  ps=conn.prepareStatement(sql);
		  // ?에 값을 채운다 
		  ps.setInt(1, mno);
		  // 실행후에 결과값 읽기
		  ResultSet rs=ps.executeQuery();
		  rs.next();
		  vo.setMno(rs.getInt(1));
		  vo.setPoster(rs.getString(2));
		  vo.setTitle(rs.getString(3));
		  vo.setRegdate(rs.getString(4));
		  vo.setGenre(rs.getString(5));
		  vo.setNation(rs.getString(6));
		  vo.setGrade(rs.getString(7));
		  vo.setTime(rs.getString(8));
		  vo.setScore(rs.getDouble(9));
		  vo.setShowUser(rs.getString(10));
		  vo.setBoxoffice(rs.getString(11));
		  vo.setStory(rs.getString(12));
		  vo.setKey(rs.getString(13));
		  
		  rs.close();
	  }catch(Exception ex)
	  {
		  ex.printStackTrace();
		  // 오류처리 
	  }
	  finally
	  {
		  // 닫기
		  disConnection();
	  }
	  return vo;
  }
}








