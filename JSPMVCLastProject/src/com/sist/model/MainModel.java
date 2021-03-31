package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller
public class MainModel {
  @RequestMapping("main/main.do")
  public String main_home(HttpServletRequest request,HttpServletResponse response)
  {
	  // 전송(include)
	  request.setAttribute("main_jsp", "../main/home.jsp");
	  return "../main/main.jsp";
  }
  
}
