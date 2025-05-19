package com.sec09;

// 사용자 정의 예외 클래스
class CustomException extends Exception {   

	public CustomException(String message) { //throwable이 객체 생성-ArgumentException
        super(message);	//음수잖아~~가 이쪽으로 들어감
        					//super에 생성자에 값전달, 호출
    }
}

/// 사용자 예외처리 호출
public class d_MyException {
    public static void main(String[] args) {
        try {
            if (args.length == 0) { //입력한 값이 0이면
                throw new IllegalArgumentException("값을 입력하세요!"); //exception class생성
            }

            int a = Integer.parseInt(args[0]); //입력값이 정수인 것을 a에 대입
            								   //numberformatException이 발생할 수 있기에 선처리.

            if (a < 0) {
                throw new CustomException("음수잖아~~~");	//커스텀exception
            }

            System.out.println("입력 값: " + a);

        } catch (CustomException e) { //커스텀 예외 메세지
        	e.printStackTrace();
            System.err.println("사용자 정의 예외 발생: " + e.getMessage() + ":" + e.toString());
        } catch (NumberFormatException e) {
        	e.printStackTrace();
            System.err.println("숫자가 아닌 값을 입력하셨습니다: " + e.getMessage() + ":" + e.getLocalizedMessage());
        } catch (IllegalArgumentException e) {
        	e.printStackTrace();
            System.err.println("잘못된 입력: " + e.getMessage());
        } catch (Exception e) {
        	e.printStackTrace();
            System.err.println("예외 발생: " + e);
        }finally {
        	System.out.println("예외상관 없이 무조건 실행");
        }
    }
}
