package com.sec03;

/*	이름 세과목 총점, 평균을 구현하는 클래스
 *	- U_score
 *	이름		국어 영어	수학	총점	평균
 * 	홍길동	100	100	100			a1
 * 	정길동	90	90	90			b1	
 * 	박길동	80	80	80			c1
 */
public class U_Score {
	
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	
	

	public U_Score(String name, int kor, int eng, int mat) { //필드 생성자 추가
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public U_Score() { //기본 생성자 추가
		//super();
		//내부 생성자 호출 가능 ->첫줄에 명시해야함
		this("noname", 50,50,50);     //나의 생성자 내부 호출 
		/*this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		*/
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}
	
	public int getTot() { //세과목의 합
		return this.getKor()+this.getEng()+this.getMat();
	}
	
	public int getAvg() { //세과목의 평균
		return this.getTot()/3;
	}

	@Override //toString 재정의 -> 전체 출력
	public String toString() {
		return String.format("U_Score [getName()=%s, getKor()=%d, getEng()=%d, getMat()=%d, getTot()=%d, getAvg()=%d]",
				getName(), getKor(), getEng(), getMat(), getTot(), getAvg());
	}

	public static void main(String[] args) {
		
		U_Score a1 = new U_Score();	//a1이라는 이름으로 객체를 생성한 주소를 대입받은 상태
		U_Score b1 = new U_Score(); 
		U_Score c1 = new U_Score();
		
		a1.setName("홍길동");
		a1.setKor(100); a1.setEng(100); a1.setMat(100);
		System.out.println(a1);
		
		b1.setName("정길동");
		b1.setKor(90); b1.setEng(90); b1.setMat(90);
		System.out.println(b1); 
		
		c1.setName("박길동");
		c1.setKor(80); c1.setEng(80); a1.setMat(80);
		System.out.println(c1);
		
		
		//////이름만 출력, 세 명의 전체 총점 출력
		System.out.println("================================================================");
		System.out.printf("%10s %10s %10s \n", a1.getName(), b1.getName(), c1.getName());
		int tot = a1.getTot()+b1.getTot()+c1.getTot();
		System.out.printf("   total_score = %5d\n", tot);

	}

}
