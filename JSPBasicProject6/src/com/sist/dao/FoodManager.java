package com.sist.dao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 *      NO     NOT NULL NUMBER           
		TITLE   NOT NULL VARCHAR2(300) 
		SUBJECT NOT NULL VARCHAR2(300) 
		POSTER  NOT NULL VARCHAR2(260) 
		LINK    NOT NULL VARCHAR2(260) 
 */
public class FoodManager {
	private FoodDAO dao=new FoodDAO();
    public void foodCategoryData()
    {
    	try
    	{
    		int k=1;
    		// 연결 => 소스읽기 
    		Document doc=Jsoup.connect("https://www.mangoplate.com/").get();
    		//System.out.println(doc);
    		Elements title=doc.select("div.top_list_slide span.title"); // CSS 선택자
    		Elements poster=doc.select("div.top_list_slide img.center-croping");
    		Elements subject=doc.select("div.top_list_slide p.desc");
    		Elements link=doc.select("div.top_list_slide a");
    		for(int i=0;i<title.size();i++)
    		{
    			System.out.println("번호:"+k);
    			System.out.println("제목:"+title.get(i).text());
    			System.out.println("부제목:"+subject.get(i).text());
    			System.out.println("이미지:"+poster.get(i).attr("data-lazy"));
    			System.out.println("링크:https://www.mangoplate.com"+link.get(i).attr("href"));
    			FoodCategoryVO vo=new FoodCategoryVO();
    			vo.setTitle(title.get(i).text());
    			vo.setSubject(subject.get(i).text());
    			vo.setPoster(poster.get(i).attr("data-lazy"));
    			vo.setLink("https://www.mangoplate.com"+link.get(i).attr("href"));
    			dao.foodCategoryInsert(vo);
    			
    			k++;
    		}
    	}catch(Exception ex){}
    }
    public static void main(String[] args) {
		FoodManager fm=new FoodManager();
		fm.foodCategoryData();
	}
}








