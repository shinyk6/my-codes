package com.workshop03.test01;

public class MemoryMemberRepository implements MemberRepository{

	@Override
	public String findMemberById(int id) { //메모리 기반 회원 저장소
		
		if(id==1) {
			return "홍길동";
		}else if(id==2) {
			return "정길동";
		}else {
			return "박길동";
		}
	}
	
}
