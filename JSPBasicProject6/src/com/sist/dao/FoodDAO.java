package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.jdbc.*;
// DBCP => 웹에서만 가능 
public class FoodDAO {
	 private DAOManager dm=new DAOManager();
	 private Connection conn;
	 private PreparedStatement ps;
	 public void foodCategoryInsert(FoodCategoryVO vo)
	 {
		 try
		 {
			 dm.getConnection(conn);
			 String sql="INSERT INTO food_category VALUES("
					   +"(SELECT NVL(MAX(no)+1,1) FROM food_category),?,?,?,?)";
			 ps=conn.prepareStatement(sql);
			 ps.setString(1, vo.getTitle());
			 ps.setString(2, vo.getSubject());
			 ps.setString(3, vo.getPoster());
			 ps.setString(4, vo.getLink());
			 // 실행
			 ps.executeUpdate(); // COMMIT
		 }catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 finally
		 {
			 dm.disConnection(conn, ps);
		 }
	 }
}








