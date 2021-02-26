package com.sist.dao;
/*
 *   NO      NOT NULL NUMBER    =======> int        
	NAME    NOT NULL VARCHAR2(34)  ====> String
	SUBJECT NOT NULL VARCHAR2(2000) ===> String
	CONTENT NOT NULL CLOB           ===> String
	PWD     NOT NULL VARCHAR2(10)   ===> String
	REGDATE          DATE           ===> java.util.Date
	HIT              NUMBER       =====> int 
	
	����Ŭ     =====   �ڹ�
	����
	  CHAR
	  VARCHAR2
	  CLOB   =====   String
	����
	  NUMBER =====> ����� ������ �Ǵ� int , double
	  NUMBER(7,2) 
	��¥ 
	  DATE 
	  TIMESTAMP ===> java.util.Date
	��Ÿ
	  BFILE
	  BLOB      ===> java.io.InputStream 
	  ���̳ʸ� ���� 
	  
	 =====================================> ����Ŭ�� �÷���� �ڹ��� ������ ��ġ
 */
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import java.sql.*;
@Setter
@Getter
public class BoardVO {
   //java.util.Date date=new java.util.Date();
   //Date date=new Date();
   private int no;
   private String name;
   private String subject;
   private String content;
   private String pwd;
   private Date regdate;
   private int hit;
}




















