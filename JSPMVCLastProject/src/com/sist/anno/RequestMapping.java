package com.sist.anno;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME) // Source , Class , Runtime(메모리 유지)
//               ==>   ============== 컴파일후에 자동 메모리 해제 
@Target(METHOD) // 찾기(인덱스)
/*
 *    @ TYPE
 *    class A
 *    {
 *        @ FIELD
 *        B b;
 *        @CONSTRUCTOR
 *        public A(@ PARAMETER)
 *        {
 *        }
 *        @METHOD
 *        public void display()
 *        {
 *        }
 *    }
 *    
 *    @RequestMapping()
 */
public @interface RequestMapping {
   public String value();
}
