package com.sist.temp;
import java.sql.*;
import javax.sql.*;
import java.util.*;
import javax.naming.*;
public class EmpDAO {
   private Connection conn;
   private PreparedStatement ps;
   // 미리 만들어진 Connection의 주소를 얻어온다 
   /*
    *    Map<String,A>
    *    map.put("a",new A()) , Connection c=map.get("jdbc/oracle")
    *    
    *    A a=(A)map.get("a")
    *           ============
    *            new A()
    *            
    *                      POOL => 저장장소 (Connection)  maxIdle="5"
    *                 ==================
    *                  false jdbc/oracle     conn=DriverManager.getConnection(url,username,password)
    *                  false jdbc/oracle     conn=DriverManager.getConnection(url,username,password)
    *                  false jdbc/oracle     conn=DriverManager.getConnection(url,username,password)
    *                  false jdbc/oracle     conn=DriverManager.getConnection(url,username,password)
    *                  false jdbc/oracle     conn=DriverManager.getConnection(url,username,password)
    *                 ==================
    */
   public void getConnection()
   {
	   try
	   {
		   Context init=new InitialContext();
		   Context c=(Context)init.lookup("java://comp/env");// 톰캣이 생성한 Connection주소
		   DataSource ds=(DataSource)c.lookup("jdbc/oracle");//Connection주소
		   conn=ds.getConnection();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
   // 반환 => 재사용 
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   // 기능 
   public List<EmpVO> empListData()
   {
	   List<EmpVO> list=new ArrayList<EmpVO>();
	   try
	   {
		   getConnection();
		   String sql="SELECT empno,ename,job,hiredate,sal "
				     +"FROM emp";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   EmpVO vo=new EmpVO();
			   vo.setEmpno(rs.getInt(1));
			   vo.setEname(rs.getString(2));
			   vo.setJob(rs.getString(3));
			   vo.setHiredate(rs.getDate(4));
			   vo.setSal(rs.getInt(5));
			   
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
	   return list;
   }
}








