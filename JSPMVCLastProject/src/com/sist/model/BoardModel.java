package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller
public class BoardModel {
   @RequestMapping("board/list.do")
   // m.invoke(obj, request,response);
   public String board_list(HttpServletRequest request,HttpServletResponse response)
   {
	   request.setAttribute("msg", "게시판");
	   // include => request를 공유 
	   request.setAttribute("main_jsp", "../board/list.jsp");
	   return "../main/main.jsp";// 화면 출력
   }
}
