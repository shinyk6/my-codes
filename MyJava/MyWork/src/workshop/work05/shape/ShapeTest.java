package workshop.work05.shape;


//Shape 클래스를 구현 (삼각형, 사각형 넓이를 구하기)
public class ShapeTest {

	public static void main(String[] args) {
		Shape shape[] = new Shape[6];

		// (1.조건)에서 주어진 데이터를 기반으로 Shape type의 객체를 생성 하여
		// 6개의 도형 객체를 배열에 넣는다.
		shape[0] = new Triangle(7,5, "Blue");
		shape[1] = new Rectangle(4,6,"Blue");
		
		shape[2] = new Triangle(6,7,"Red");
		shape[3] = new Rectangle(8,3,"Red");
		
		shape[4] = new Triangle(9,8,"White");
		shape[5] = new Rectangle(5,7,"White");
		
		 // 모든 객체의 넓이 정보와 색상 정보를 for Loop를 이용하여 화면에 출력 한다
				
		System.out.println("기본정보");
		
		for(Shape res: shape) {
			System.out.println(res.getClass().getSimpleName()+" "+res.getArea()+" " + res.getColors());
		}
			
		// 모든 객체들을 setResize함수를 이용하여 5를 입력 하고 사이즈를 변경 후 화면에 출력 한다. 단 for Loop문을 이용한다.
		System.out.println("사이즈를 변경 후 정보");
		for(Shape res : shape) { // Resize 인터페이스는 Shape과 직접적인 관계가 없으므로 setResize()를 호출하려면 강제 형변환 또는 인스턴스 형의 타입으로 확인 후 호출.
			if (res instanceof Resize r) { //왼쪽에있는애가 오른쪽에있는 타입을 가지고 있는지 없는지 확인
				r.setResize(5); //형 변환 후 호출      r:주소  어떤 인터페이스가 가진setResize인지 확인하고 다운캐스팅
			}
			System.out.println(res.getClass().getSimpleName()+" "+res.getArea()+" "+res.getColors() );
		}
		
		
	}

}

