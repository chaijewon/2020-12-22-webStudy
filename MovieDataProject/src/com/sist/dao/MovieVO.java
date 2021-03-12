package com.sist.dao;

import lombok.Getter;
import lombok.Setter;

/*
 *  MNO       NOT NULL NUMBER         
	CNO                NUMBER         
	POSTER    NOT NULL VARCHAR2(260)  
	TITLE     NOT NULL VARCHAR2(200)  
	DIRECTOR  NOT NULL VARCHAR2(100)  
	ACTOR              VARCHAR2(1000) 
	REGDATE   NOT NULL VARCHAR2(200)  
	GENRE     NOT NULL VARCHAR2(100)  
	NATION    NOT NULL VARCHAR2(50)   
	GRADE     NOT NULL VARCHAR2(50)   
	TIME      NOT NULL VARCHAR2(50)   
	SCORE              NUMBER(2,1)    
	SHOWUSER           VARCHAR2(30)   
	BOXOFFICE          VARCHAR2(10)   
	STORY              CLOB           
	KEY                VARCHAR2(30)
 */
@Setter
@Getter
public class MovieVO {
   private int mno,cno,replyCount;
   private String poster,title,director,actor,regdate,
           genre,nation,grade,time,showUser,
           boxoffice,story,key;
   private double score;
}







