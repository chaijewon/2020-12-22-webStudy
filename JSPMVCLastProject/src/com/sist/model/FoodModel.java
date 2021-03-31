package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller
public class FoodModel {
	   @RequestMapping("food/list.do")
	   // m.invoke(obj, request,response);
	   public String board_list(HttpServletRequest request,HttpServletResponse response)
	   {
		   request.setAttribute("msg", "맛집");
		   request.setAttribute("main_jsp", "../food/list.jsp");
		   return "../main/main.jsp";
	   }
}
