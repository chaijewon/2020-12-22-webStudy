package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.MemberDAO;
import com.sist.vo.ZipcodeVO;

@Controller
public class MemberModel {
  @RequestMapping("member/join.do")
  public String member_join(HttpServletRequest request,HttpServletResponse response)
  {
	  request.setAttribute("main_jsp", "../member/join.jsp");
	  return "../main/main.jsp";
  }
  @RequestMapping("member/post_result.do")
  public String member_post(HttpServletRequest request,HttpServletResponse response)
  {
	  System.out.println("OK");
	  try
	  {
		  request.setCharacterEncoding("UTF-8");
	  }catch(Exception ex){}
	  String dong=request.getParameter("dong");
	  System.out.println(dong);
	  MemberDAO dao=MemberDAO.newInstance();
	  List<ZipcodeVO> list=dao.postFindData(dong);
	  request.setAttribute("list", list);
	  return "../member/post_result.jsp";
  }
  
  @RequestMapping("member/idcheck_result.do")
  public String idcheck(HttpServletRequest request,HttpServletResponse response)
  {
	  String id=request.getParameter("id");
	  MemberDAO dao=MemberDAO.newInstance();
	  int count=dao.idcheck(id);
	  request.setAttribute("count", count);
	  return "../member/idcheck_result.jsp";
  }
  
}








