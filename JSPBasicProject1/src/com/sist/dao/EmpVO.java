package com.sist.dao;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class EmpVO {
   // 사원 한명에 대한 정보 =>모아서 브라우저로 전송 (데이터를 모아서 전송할 목적)
   private int empno;
   private String ename;
   private String job;
   private int mgr;
   private Date hiredate;
   private int sal;
   private int comm;
   private int deptno;
}
