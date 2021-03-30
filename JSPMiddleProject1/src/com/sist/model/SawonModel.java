package com.sist.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
/*
 *    class HttpServletRequest
 *    {
 *        int a=10;
 *    }
 *    
 *    class Model
 *    {
 *        public void disp(HttpServletRequest request)
 *        {
 *           request.a=100;
 *        }
 *    }
 *    
 *    HttpServletRequest request=new HttpServletRequest();
 *    B b=new B();
 *    b.disp(request);   
 *    
 *    request를 받는 곳 : JSP , 서블릿
 */
public class SawonModel {
  public void sawonInit(HttpServletRequest request)
  {
	  String name="심청이";
	  request.setAttribute("name", name);// JSP로 전송 
  }
  public void sawonDetailData(HttpServletRequest request)
  {
	  SawonVO vo=new SawonVO(1, "홍길동", "개발부");
	  // vo=> jsp로 전송 
	  request.setAttribute("vo", vo);
  }
  public void sawonTwoData(HttpServletRequest request)
  {
	  String firstName="박";
	  String lastName="문수";
	  request.setAttribute("first", firstName);
	  request.setAttribute("last", lastName);
  }
}






