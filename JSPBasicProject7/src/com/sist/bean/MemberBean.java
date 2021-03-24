package com.sist.bean;
/*
 *   네트워크 통신 
 *   브라우저(클라이언트) <==========> 톰캣(서버)  C/S
 *          결과값 => 데이터가 많은 경우에 클래스로 묶어서 한번에 전송 
 *          JSP : Bean 
 *            = 변수(private),읽기/쓰기 => getter/setter
 *          MyBatis : DTO
 *          Spring : VO
 *          ============= 캡슐화 (데이터 보호:시큐어코딩)
 *          
 */
public class MemberBean {
    private String id;
    private String name;
    private String addr;
    private String tel;
    private String sex;
    private boolean admin;
    
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSex() {
		
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
   
}








