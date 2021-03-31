package com.sist.controller;
import java.util.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
public class FileConfig {
  public List<String> componentScan(String path,String pack)
  {
	     List<String> list=new ArrayList<String>();
	     //String path="";
	     //C:\Users\SIST\git\webStudy\JSPLastProject\src\com\
	     path+=pack.replace(".", "\\");
		 try
		 {
			 
			 File dir=new File(path);
			 File[] files=dir.listFiles();
			 for(File f:files)
			 {
				 System.out.println(f.getName());
				 String s=f.getName();
				 String ext=s.substring(s.lastIndexOf(".")+1);
				 if(ext.equals("java"))
				 {
					 String clsName=pack+"."+s.substring(0,s.lastIndexOf("."));
					 //System.out.println(clsName);
					 list.add(clsName);
				 }
			 }
		 }catch(Exception ex){}
		 return list;
  }
	/*
	 * public static void main(String[] args) { FileConfig fc=new FileConfig();
	 * fc.componentScan("com.sist.model"); }
	 */
}







