package com.sist.anno;

import java.lang.reflect.Method;
import java.util.*;
class BoardModel{
	public void list()
	{
		System.out.println("목록 출력");
	}
	public void insert()
	{
		System.out.println("데이터 추가");
	}
	public void update()
	{
		System.out.println("데이터 수정");
	}
	public void delete()
	{
		System.out.println("데이터 삭제");
	}
	public void find()
	{
		System.out.println("데이터 찾기");
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
			/*
			 * Scanner scan=new Scanner(System.in); System.out.print("기능 입력:"); String
			 * cmd=scan.next();
			 */
        	Class clsName=Class.forName("com.sist.anno.BoardModel");
        	Object obj=clsName.getDeclaredConstructor().newInstance();
        	// new Board()
        	Method[] method=clsName.getDeclaredMethods();
        	//method[0].invoke(obj, null);
        	for(Method m:method)
        	{
        		System.out.println(m.getName());
        	}
        	
        }catch(Exception ex) {}
	}

}








