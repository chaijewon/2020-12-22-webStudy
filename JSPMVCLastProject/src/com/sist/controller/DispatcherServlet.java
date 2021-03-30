package com.sist.controller;

import java.io.*;
import java.lang.reflect.Method;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List<String> clsList=new ArrayList<String>();
	public void init(ServletConfig config) throws ServletException {
	   String xmlPath=config.getInitParameter("contextConfigLocation");
	   String filePath=config.getInitParameter("file_path");
	   try
	   {
		   DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		   DocumentBuilder db=dbf.newDocumentBuilder();
		   Document doc=db.parse(new File(xmlPath));
		   Element beans=doc.getDocumentElement();
		   NodeList list=beans.getElementsByTagName("component-scan");
		   FileConfig fc=new FileConfig();
		   for(int i=0;i<list.getLength();i++)
		   {
			   Element component=(Element)list.item(i);
			   String pack=component.getAttribute("base-package");
			   List<String> fList=fc.componentScan(filePath, pack);
			   for(String s:fList)
			   {
				   clsList.add(s);
			   }
		   }
		   
	   }catch(Exception ex){}
	   
	   for(String ss:clsList)
	   {
		   System.out.println(ss);
	   }
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getRequestURI();
		// /JSPMVCLastProject/board/list.do main/main.do
		cmd=cmd.substring(request.getContextPath().length()+1);
		//System.out.println(cmd);
		try {
		      for(String cls:clsList)
		      {
		         Class clsName=Class.forName(cls);
		         if(clsName.isAnnotationPresent(Controller.class)==false)
		         {
		        	 continue;
		         }
		         Object obj=clsName.getDeclaredConstructor().newInstance();
		         // 메소드 찾기 
		         Method[] methods=clsName.getDeclaredMethods();
		         for(Method m:methods)
		         {
		        	 RequestMapping rm=m.getAnnotation(RequestMapping.class);
		        	 if(rm.value().equals(cmd))
		        	 {
		        		 // public String boardList(HttpServletRequest requst,reponse)
		        		 // return "redirect:list.do"
		        		 String jsp=(String)m.invoke(obj, request,response);
		        		 if(jsp.startsWith("redirect"))// sendRedirect
		        		 {
		        			 
		        		 }
		        		 else // forward
		        		 {
		        			 
		        		 }
		        		 return;
		        	 }
		         }
		      }
		}catch(Exception ex){}
		
	}

}








