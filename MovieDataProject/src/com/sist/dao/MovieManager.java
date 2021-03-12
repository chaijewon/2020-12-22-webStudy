package com.sist.dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 다음에서 데이터 읽어 오기 => MovieDAO => 데이터 저장 
public class MovieManager {
   public void movieData()
   {
	   MovieDAO dao=new MovieDAO();
	   try
	   {
		   System.out.println("Start...");
		   String url="https://movie.daum.net/premovie/kakaopage?flag=Y";
		   int cno=11;
		   Document doc=Jsoup.connect(url).get();
		   System.out.println(doc);
		   /*
		    *  <div class="thumb_cont">
                                <strong class="tit_item">
                                    <a href="/moviedb/main?movieId=137317" 
                                    class="link_txt" data-tiara-layer="moviename">미나리</a>
		    */
		   Elements link=doc.select("div.thumb_cont strong.tit_item a.link_txt");
		   /*
		    *  <span class="txt_info">
							        개봉<span class="txt_num">21.03.03</span>
						        </span>
		    */
		   //Elements regdate=doc.select("span.txt_info span.txt_num");
		   /*
		    *  <span class="txt_append">
                                    <span class="info_txt">평점<span class="txt_grade">7.2</span></span>
                                    <span class="info_txt">예매율<span class="txt_num">22.1%</span></span>
                                </span>
		    */
		   /*
		    *  <div class="poster_movie">
                                        <img src="https://img1.daumcdn.net/thumb/C408x596/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F335359e6a5a36f0d334bc20ff2f2c0488b30c67d" class="img_thumb" alt="미나리">
                                    <span class="rank_num">1</span>
                                        <span class="txt_tag">
                                            <span class="ico_movie ico_see see12">12세이상관람가</span>
                                        </span>
                                </div>
		    */
		   //Elements grade=doc.select("span.txt_tag span.ico_movie");
		   //Elements score=doc.select("span.txt_append span.txt_grade");
		   //
		   //Elements poster=doc.select("div.poster_movie img.img_thumb");
		   /*
		    *  <div class="poster_info">
                       <a href="/moviedb/main?movieId=137317" class="link_story" data-tiara-layer="poster">
                        2021년 전 세계가 기다린어느 한국 가족의 원더풀한 이야기"미나리는 어디서든 잘 자라"낯선 미국, 아칸소로 떠나온 한국 가족.가족들에게 뭔가 해내는 걸 보여주고 싶은 아빠 '제이콥'(스티븐 연)은자신만의 농장을 가꾸기 시작하고 엄마 '모니카'(한예리)도 다시 일자리를 찾는다.아직 어린 아이들을 위해‘모니카’의 엄마 ‘순자’(윤여정)가 함께 살기로 하고가방 가득 고춧가루, 멸치, 한약 그리고 미나리씨를 담은 할머니가 도착한다.의젓한 큰딸 '앤'(노엘 케이트 조)과 장난꾸러기 막내아들 '데이빗'(앨런 김)은여느 그랜마같지 않은 할머니가 영- 못마땅한데…함께 있다면, 새로 시작할 수 있다는 희망으로하루하루 뿌리 내리며 살아가는어느 가족의 아주 특별한 여정이 시작된다!
                 </a>
		    */
		   //Elements story=doc.select("div.poster_info a.link_story");
		   /*
		    *   MNO       NOT NULL NUMBER  (O)       
				CNO                NUMBER  (O)    
				POSTER    NOT NULL VARCHAR2(260) (O)  
				TITLE     NOT NULL VARCHAR2(200) (O)
				DIRECTOR  NOT NULL VARCHAR2(100)  
				ACTOR              VARCHAR2(1000) 
				REGDATE   NOT NULL VARCHAR2(200)  (O)
				GENRE     NOT NULL VARCHAR2(100)  
				NATION    NOT NULL VARCHAR2(50)   
				GRADE     NOT NULL VARCHAR2(50)   (O)
				TIME      NOT NULL VARCHAR2(50)   
				SCORE              NUMBER(2,1)    (O)
				SHOWUSER           VARCHAR2(30)   
				BOXOFFICE          VARCHAR2(10)   
				STORY              CLOB           (O)
				KEY                VARCHAR2(30)
		    */
		   for(int i=0;i<link.size();i++)
		   {
			   try
			   {
				   // HTML => 태그와 태그사이 <a>(값)</a> => text()
				   // <a 속성="값"> => attr(속성) ==> img , a 
				   MovieVO vo=new MovieVO();
				   
					/*
					 * if(link.get(i).text().equals("타락천사")) continue;
					 * System.out.println("제목:"+link.get(i).text());
					 * System.out.println("링크:"+link.get(i).attr("href"));
					 * System.out.println("개봉일:"+regdate.get(i).text());
					 * System.out.println("등급:"+grade.get(i).text());
					 * System.out.println("평점:"+score.get(i).text());
					 * System.out.println("포스터:"+poster.get(i).attr("src"));
					 * System.out.println("줄거리:"+story.get(i).text()); 
					 * vo.setCno(cno);
					 * vo.setTitle(link.get(i).text()); 
					 * vo.setRegdate(regdate.get(i).text());
					 * vo.setGrade(grade.get(i).text());
					 * vo.setScore(Double.parseDouble(score.get(i).text()));
					 * vo.setPoster(poster.get(i).attr("src")); 
					 * vo.setStory(story.get(i).text());
					 */
				   // https://movie.daum.net/moviedb/main?movieId=137317
				   Document doc2=Jsoup.connect("https://movie.daum.net"
				            +link.get(i).attr("href")).get();
				   /*
				    *   <div class="inner_tit">
                    <span class="txt_tit">소울</span>
                </div>
				    */
				   Element title=doc2.selectFirst("div.inner_tit span.txt_tit");
				   System.out.println("제목:"+title.text());
				   vo.setCno(cno);
				   vo.setTitle(link.get(i).text());
				   /*
				    *  div class="info_desc" data-tiara-layer="desc">
                            <div class="desc_cont">
				    */
				   Element story=doc2.selectFirst("div.info_desc div.desc_cont");
				   String s=story.text();
				   //s=s.substring(0,s.indexOf("["));
				   vo.setStory(story.text());
				   System.out.println("줄거리:"+s);
				   
				   /*
				    * 
				    *   info_poster">
                    <a href="#photoId=1396501" class="thumb_img" data-tiara-layer="poster" data-tiara-copy="메인_포스터">
            <span class="bg_img
				    */
				   Element poster=doc2.selectFirst("div.info_poster span.bg_img");
				   String p=poster.attr("style");
				   p=p.substring(p.indexOf("(")+1,p.lastIndexOf(")"));
				   System.out.println(p);
				   vo.setPoster(p);
				   /*
				    *   개봉	2021.01.20
						장르	애니메이션/판타지
						국가	미국
						등급	전체관람가
						러닝타임	107분
						평점	8.8
						누적관객	1,977,906명
						박스오피스	7위
				    */
				   Elements info1=doc2.select("div.inner_cont dl.list_cont dt");
				   Elements info2=doc2.select("div.inner_cont dl.list_cont dd");
				   for(int j=0;j<info1.size();j++)
				   {
					   try 
					   {
						   String str=info1.get(j).text();
						   if(str.equals("개봉"))
						   {
							   System.out.println("개봉:"+info2.get(j).text());
							   vo.setRegdate(info2.get(j).text());
						   }
						   else if(str.equals("등급"))
						   {
							   System.out.println("등급:"+info2.get(j).text());
							   vo.setGrade(info2.get(j).text());
						   }
						   else if(str.equals("평점"))
						   {
							   System.out.println("평점:"+info2.get(j).text());
							   vo.setScore(Double.parseDouble(info2.get(j).text()));
						   }
						   else if(str.equals("장르"))
						   {
							   System.out.println("장르:"+info2.get(j).text());
							   vo.setGenre(info2.get(j).text());
						   }
						   else if(str.equals("국가"))
						   {
							   System.out.println("국가:"+info2.get(j).text());
							   vo.setNation(info2.get(j).text());
						   }
						   else if(str.equals("러닝타임"))
						   {
							   System.out.println("러닝타임:"+info2.get(j).text());
							   vo.setTime(info2.get(j).text());
						   }
						   else if(str.equals("누적관객"))
						   {
							   System.out.println("누적관객:"+info2.get(j).text());
							   vo.setShowUser(info2.get(j).text());
						   }
						   else if(str.equals("박스오피스"))
						   {
							   System.out.println("박스오피스:"+info2.get(j).text());
							   vo.setBoxoffice(info2.get(j).text());
						   }
					   }catch(Exception ex) {}
						   
				   }
				   //System.out.println("동영상:"+youtubeGetKey(vo.getTitle()));
				   vo.setKey(youtubeGetKey(vo.getTitle()));
				   dao.movieInsert(vo);
				   
				   Thread.sleep(100);// 읽는 속도와 오라클에 저장하는 속도 차이 
				   // P / S
				   System.out.println("========================================================");
		   
			   }catch(Exception ex) {ex.printStackTrace();}
		   }
	   }catch(Exception ex){ex.printStackTrace();}
   }
   // https://www.youtube.com/results?search_query=
   public String youtubeGetKey(String title)
   {
	   String key="";
	   try
	   {
		   String url="https://www.youtube.com/results?search_query="+title;
		   Document doc=Jsoup.connect(url).get();
		   // /watch?v=bdcIC8d4nW0
		   Pattern p=Pattern.compile("/watch\\?v=[^가-힣]+");
		   /*
		    *  /watch?v=bdcIC8d4nW0","webPageType":"WEB_PAGE_TYPE_WATCH","rootVe":3832}
		    */
		   Matcher m=p.matcher(doc.toString());
		   while(m.find())
		   {
			   String str=m.group();// 찾은 문자열을 읽어 온다 
			   str=str.substring(str.indexOf("=")+1,str.indexOf("\""));
			   key=str;
			   break;
		   }
	   }catch(Exception ex){ex.printStackTrace();}
	   return key;
   }
   public static void main(String[] args) {
	    MovieManager m=new MovieManager();
	    m.movieData();
   }
}







