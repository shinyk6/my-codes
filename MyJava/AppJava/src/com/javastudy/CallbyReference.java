package com.javastudy;

public class CallbyReference {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		
		int rs[] = method(nums);
		
		for(int result : rs) {
			System.out.println(result);
		}
	}

	private static int[] method(int[] arr) {
		arr[0] = 99;
		return arr;
	}
	
}




