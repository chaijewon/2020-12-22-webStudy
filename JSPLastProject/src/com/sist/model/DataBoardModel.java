package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class DataBoardModel {
  @RequestMapping("databoard/list.do")
  public String databoard_list(HttpServletRequest request,HttpServletResponse response)
  {
	  String page=request.getParameter("page");
	  if(page==null)
		  page="1";
	  int curpage=Integer.parseInt(page);
	  DataBoardDAO dao=DataBoardDAO.newInstance();
	  List<DataBoardVO> list=dao.databoardListData(curpage);
	  int totalpage=dao.databoardTotalPage();
	  
	  request.setAttribute("list", list);
	  request.setAttribute("curpage", curpage);
	  request.setAttribute("totalpage", totalpage);
	  request.setAttribute("main_jsp", "../databoard/list.jsp");
	  return "../main/main.jsp";
  }
  
  @RequestMapping("databoard/insert.do")
  public String databoard_insert(HttpServletRequest request,HttpServletResponse response)
  {
	  request.setAttribute("main_jsp", "../databoard/insert.jsp");
	  return "../main/main.jsp";
  }
}










