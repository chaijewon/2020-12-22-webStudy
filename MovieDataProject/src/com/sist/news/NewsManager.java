package com.sist.news;
// http://newssearch.naver.com/search.naver?where=rss&query=영화
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.net.*;
/*
 *   XML , JSON , CSV => 읽어 온다 
 *   기본 => 오라클 
 *   
 *   XML : 스프링은 XML기반 (어노테이션)
 */
public class NewsManager {
   public List<Item> newsListData()
   {
	   List<Item> list=new ArrayList<Item>();
	   try
	   {
		   String fd="영화";
		   String strUrl="http://newssearch.naver.com/search.naver?where=rss&query="
				         +URLEncoder.encode(fd, "UTF-8");
		   JAXBContext jb=JAXBContext.newInstance(Rss.class);
		   Unmarshaller un=jb.createUnmarshaller(); 
		   /*
		    *   Unmarshaller ( XML=>클래스화 )
		    *   Marshaller   (클래스 => XML)
		    */
		   Rss rss=(Rss)un.unmarshal(new URL(strUrl));
		   list=rss.getChannel().getItem();
	   }catch(Exception ex){}
	   return list;
   }
}







