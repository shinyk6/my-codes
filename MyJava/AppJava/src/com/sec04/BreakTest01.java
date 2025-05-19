package com.sec04;

public class BreakTest01 {
	public static void main(String[] args) {
		
		outer : for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
				if (j == 1)
					break outer;	//outer로 점핑해라 (라벨링 코드는 자바에서 존재하지만 많이 안씀)
				System.out.println("i =" + i + " j =" + j);
			}//inner for end
		}//outer for end
	}//main  end
}//BreakTest01  end




