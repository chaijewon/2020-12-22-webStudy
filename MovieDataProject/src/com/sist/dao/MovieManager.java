package com.sist.dao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

// 다음에서 데이터 읽어 오기 => MovieDAO => 데이터 저장 
public class MovieManager {
   public void movieData()
   {
	   try
	   {
		   String url="https://movie.daum.net/ranking/reservation";
		   int cno=1;
		   Document doc=Jsoup.connect(url).get();
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
		   Elements regdate=doc.select("span.txt_info span.txt_num");
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
		   Elements grade=doc.select("span.txt_tag span.ico_movie");
		   Elements score=doc.select("span.txt_append span.txt_grade");
		   //
		   Elements poster=doc.select("div.poster_movie img.img_thumb");
		   /*
		    *  <div class="poster_info">
                       <a href="/moviedb/main?movieId=137317" class="link_story" data-tiara-layer="poster">
                        2021년 전 세계가 기다린어느 한국 가족의 원더풀한 이야기"미나리는 어디서든 잘 자라"낯선 미국, 아칸소로 떠나온 한국 가족.가족들에게 뭔가 해내는 걸 보여주고 싶은 아빠 '제이콥'(스티븐 연)은자신만의 농장을 가꾸기 시작하고 엄마 '모니카'(한예리)도 다시 일자리를 찾는다.아직 어린 아이들을 위해‘모니카’의 엄마 ‘순자’(윤여정)가 함께 살기로 하고가방 가득 고춧가루, 멸치, 한약 그리고 미나리씨를 담은 할머니가 도착한다.의젓한 큰딸 '앤'(노엘 케이트 조)과 장난꾸러기 막내아들 '데이빗'(앨런 김)은여느 그랜마같지 않은 할머니가 영- 못마땅한데…함께 있다면, 새로 시작할 수 있다는 희망으로하루하루 뿌리 내리며 살아가는어느 가족의 아주 특별한 여정이 시작된다!
                 </a>
		    */
		   Elements story=doc.select("div.poster_info a.link_story");
		   for(int i=0;i<link.size();i++)
		   {
			   // HTML => 태그와 태그사이 <a>(값)</a> => text()
			   // <a 속성="값"> => attr(속성) ==> img , a 
			   System.out.println("제목:"+link.get(i).text());
			   System.out.println("링크:"+link.get(i).attr("href"));
			   System.out.println("개봉일:"+regdate.get(i).text());
			   System.out.println("등급:"+grade.get(i).text());
			   System.out.println("평점:"+score.get(i).text());
			   System.out.println("포스터:"+poster.get(i).attr("src"));
			   System.out.println("줄거리:"+story.get(i).text());
			   System.out.println("========================================================");
		   }
	   }catch(Exception ex){}
   }
   
   public static void main(String[] args) {
	    MovieManager m=new MovieManager();
	    m.movieData();
   }
}







