package com.sec11.myutil01;

import java.util.HashSet;
import java.util.Set;

public class SetTest02 {

	public static void main(String[] args) {
	 Set<String> m1=new HashSet<String>();
	 Set<String>m2=new HashSet<String>();
	 
	 m1.add("A");
	 m1.add("B");
	 m1.add("C");
	 
	 m2.add("B");
	 m2.add("D");
	 m2.add("E");
	 
	 Set<String> m_union =new HashSet<>(m1);
	 m_union .addAll(m2); //.addAll() 또 다른 객체를 추가
	 
	 
	 Set<String> m_intersection =	new HashSet<>(m1);
	 m_intersection.retainAll(m2); //.retainAll() 교집합만 추출
	 
	 System.out.println("합집합 : " + m_union);
	 System.out.println("교집합 : "+m_intersection);
		
		
	}

}
