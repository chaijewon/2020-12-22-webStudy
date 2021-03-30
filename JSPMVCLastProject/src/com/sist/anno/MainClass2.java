package com.sist.anno;

import java.lang.reflect.Method;
import java.util.Scanner;

class NoticeModel
{
	@RequestMapping("list.do")
	public void list()
	{
		System.out.println("목록 출력");
	}
	@RequestMapping("insert.do")
	public void insert()
	{
		System.out.println("데이터 추가");
	}
	@RequestMapping("update.do")
	public void update()
	{
		System.out.println("데이터 수정");
	}
	@RequestMapping("delete.do")
	public void delete()
	{
		System.out.println("데이터 삭제");
	}
	@RequestMapping("find.do")
	public void find()
	{
		System.out.println("데이터 찾기");
	}
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	Scanner scan=new Scanner(System.in);
        	System.out.print("URI:");
        	String uri=scan.next(); // list.do
        	Class clsName=Class.forName("com.sist.anno.NoticeModel");
        	Object obj=clsName.getDeclaredConstructor().newInstance();
        	Method[] method=clsName.getDeclaredMethods();
        	for(Method m:method)
        	{
        		RequestMapping rm=m.getAnnotation(RequestMapping.class);
        		if(rm.value().equals(uri))
        		{
        			m.invoke(obj, null);
        			break;
        		}
        	}
        }catch(Exception ex) {}
	}

}








