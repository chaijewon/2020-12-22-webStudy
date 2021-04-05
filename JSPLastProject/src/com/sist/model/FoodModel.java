package com.sist.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
/*
 *   MVC => Model,View,Controller
 *          =====
 *          요청처리 = Spring(Controller) , Struts(Action)
 *          public void display(@Parameter B b)
 */
import com.sist.controller.RequestMapping;
import com.sist.dao.FoodDAO;
import java.util.*;
import com.sist.vo.*;
/*
 *    1) ../food/food_category.do?cno=1 => 사용자 요청 (jsp파일에 있다)
 *    =========================
 *    2) DispatcherServlet 
 *       => @RequestMapping("food/food_category.do")
 *    3) FoodModel 
 *    4) FoodDAO 
 *    5) DispatcherServlet
 *    6) food_category.jsp 에서 출력 
 */
@Controller
public class FoodModel {
  @RequestMapping("food/food_category.do")
  public String food_category(HttpServletRequest request,HttpServletResponse response)
  {
	  String cno=request.getParameter("cno");
	  // DAO연결 {no:1,name:"",}
	  FoodDAO dao=FoodDAO.newInstance();// 오라클연동 
	  List<FoodVO> list=dao.foodCategoryHouseData(Integer.parseInt(cno));
	  for(FoodVO vo:list)
	  {
		  String poster=vo.getPoster();
		  poster=poster.substring(0,poster.indexOf("^"));
		  vo.setPoster(poster);
	  }
	  FoodCategoryVO vo=dao.foodCategoryInfoData(Integer.parseInt(cno));
	  request.setAttribute("list", list);
	  request.setAttribute("vo", vo);
	  request.setAttribute("main_jsp", "../food/food_category.jsp");
	  return "../main/main.jsp";
  }
  @RequestMapping("food/detail_before.do")
  public String detail_before(HttpServletRequest request,HttpServletResponse response)
  {
	  String no=request.getParameter("no");
	  System.out.println(no);
	  Cookie cookie=new Cookie("m"+no, no);// 문자열만 저장이 가능 
	  cookie.setMaxAge(60*60);
	  cookie.setPath("/");
	  response.addCookie(cookie);
	  return "redirect:../food/food_detail.do?no="+no;
  }
  @RequestMapping("food/food_detail.do")
  public String food_detail(HttpServletRequest request,HttpServletResponse response)
  {
	  String no=request.getParameter("no");
	  // DAO연결 
	  FoodDAO dao=FoodDAO.newInstance();
	  FoodVO vo=dao.foodDetailData(Integer.parseInt(no));
	  List<RecipeVO> list=dao.foodSameRecipeData(vo.getType());
	  List<FoodReplyVO> rList=dao.foodReplyReadData(Integer.parseInt(no));
	  request.setAttribute("rList", rList);
	  request.setAttribute("list", list);
	  request.setAttribute("vo", vo);
	  request.setAttribute("main_jsp", "../food/food_detail.jsp");
	  return "../main/main.jsp";
  }
  
  @RequestMapping("food/food_reply_insert.do")
  public String food_reply_insert(HttpServletRequest request,HttpServletResponse response)
  {
	  // 댓글 데이터 받기 
	  try
	  {
		  request.setCharacterEncoding("UTF-8");
	  }catch(Exception ex) {}
	  String cno=request.getParameter("cno");
	  String msg=request.getParameter("msg");
	  HttpSession session=request.getSession();
	  String id=(String)session.getAttribute("id");
	  String name=(String)session.getAttribute("name");
	  FoodReplyVO vo=new FoodReplyVO();
	  vo.setName(name);
	  vo.setMsg(msg);
	  vo.setId(id);
	  vo.setCno(Integer.parseInt(cno));
	  //DAO연결 
	  FoodDAO dao=FoodDAO.newInstance();
	  dao.foodReplyInsert(vo);
	  return "redirect:../food/food_detail.do?no="+cno;
  }
  // 댓글 삭제
  @RequestMapping("food/food_reply_delete.do")
  public String food_reply_delete(HttpServletRequest request,HttpServletResponse response)
  {
	  String no=request.getParameter("no");
	  String cno=request.getParameter("cno");
	  FoodDAO dao=FoodDAO.newInstance();
	  //DB연동 
	  dao.foodReplyDelete(Integer.parseInt(no));
	  return "redirect:../food/food_detail.do?no="+cno;
  }
  
}










