package com.sec05;

public class h_CmdTest {
 // java h_CmdTest 
// java h_CmdTest anc def
	public static void main(String[] args) { //메인으로 받게 되면 무조건 string -> 두 수를 입력받아 합해라 등은 형변환이 필요
		System.out.println("args의 요소의 개수 =" + args.length);
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	} 
}
