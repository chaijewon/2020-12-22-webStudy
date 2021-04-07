package com.sist.model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
import com.sist.vo.*;
import java.io.*;
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
  @RequestMapping("databoard/insert_ok.do")
  public String databoard_insert_ok(HttpServletRequest request,HttpServletResponse response)
  {
	  try
	  {
		  request.setCharacterEncoding("UTF-8");
		  String path="c:\\upload\\";
		  int size=1024*1024*100;
		  String enctype="UTF-8";// 한글파일
		  // 업로드 
		  MultipartRequest mr=new MultipartRequest(request, path,size,enctype,
				    new DefaultFileRenamePolicy());
		  // 데이터 받기
		  String name=mr.getParameter("name");
		  String subject=mr.getParameter("subject");
		  String content=mr.getParameter("content");
		  String pwd=mr.getParameter("pwd");
		  
		  DataBoardVO vo=new DataBoardVO();
		  vo.setName(name);
		  vo.setSubject(subject);
		  vo.setContent(content);
		  vo.setPwd(pwd);
		  
		  String filename=mr.getOriginalFileName("upload");
		  if(filename==null)
		  {
			  vo.setFilename("");
			  vo.setFilesize(0);
		  }
		  else
		  {
			  File file=new File(path+filename);
			  vo.setFilename(filename);
			  vo.setFilesize((int)file.length());
			  
		  }
		  //DB연동 
		  DataBoardDAO dao=DataBoardDAO.newInstance();
		  dao.databoardInsert(vo);
	  }catch(Exception ex){}
	  return "redirect:../databoard/list.do";
  }
}










