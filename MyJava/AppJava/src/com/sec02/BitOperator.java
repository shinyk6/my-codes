package com.sec02;

	//비트 연산자
	//toBinaryString
	public class BitOperator {
		
		public static void prn() {
			int a=51;
			int b=240;
			
			 System.out.println("AND ="+( a&b));
			 System.out.println("OR=" +(a|b));
			 System.out.println("XOR="+(a^b));
		}
		
		public static void main(String[] args) {
			//정수를 2진 문자열로 변경 toBinaryString (to시리즈는 전부 static)
			 
			int a = 51;
			int b = 240;
			
			System.out.println("a의 51을 2진 문자열로 = "+Integer.toBinaryString(a));
			System.out.println("b의 240을 2진 문자열로 = "+Integer.toBinaryString(b));
			
			//Integer.toBinaryString(a)의 문자열로 리턴받은 이진 문자열을 32자리로 만들고 빈공간을 0으로 채우자
			//리턴 받아서 String.format으로 지정한 다음 출력해야한다.
			//이 자체를 메소드로 만들어 놓고 싶다
			
			//System.out.printf("%16s", Integer.toBinaryString(a).replace(' ', '0'));     ->이 방식은 너무 비효율적.메소드로 만들자
			
			String str = BinaryStringPadding(a);
			System.out.println(str);
			
			String str02 = BinaryStringPadding(b);
			System.out.println(str02);
			
			String str03 = BinaryStringPadding(-20);
			System.out.println(str03);
			
			int res_a = 2;
			System.out.println(BinaryStringPadding(res_a));
			
			float res_f = 7.2f;
			System.out.println(BinaryStringPadding_float(res_f));
			
			//t실수타입 구현할 때 -> 실수 클래스의 비트로 변환한 다음 정수 클래스의 tobinaryString()으로 작성한다.
			//Double클래스의 bits로 변환하는 메소드를 찾아보자!!!
			double doubleValue = 3.14159265359; //8byte
			long bits = Double.doubleToLongBits(doubleValue); //메소드 찾기
			String binaryString = Long.toBinaryString(bits); //변환하기
			System.out.println(doubleValue+"\n"+bits+"\n"+binaryString); //출력
			
			System.out.println("=================NaN=====================");
			
			double non_value = Double.NaN;	//정의되지 않은 수로 연산함  0.0/0.0  Math.sqrt(-1) ->Nan
			long res03 = Double.doubleToLongBits(non_value);	//double클래스가 Nan을 처리해준다 !!!
			long res04 = Double.doubleToRawLongBits(non_value);		
			
			////////////Long.toBinaryString()으로 변환해서 출력 해보자
			System.out.println(non_value+"\n"+res03+"\n"+res04);
			System.out.println(Long.toBinaryString(res03)+"\n"+Long.toBinaryString(res04));
			

			
		}
		public static String BinaryStringPadding(int res) {
			
			String result = String.format("%32s", Integer.toBinaryString(res)).replace(' ', '0');
			return result;
		}
		
		public static String BinaryStringPadding_float(float res_f) {
		
			String result = String.format("%32s", Float.toHexString(res_f)).replace(' ', '0');
			return result;
		}
	}




	
	
