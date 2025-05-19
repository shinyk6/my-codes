package workshop.work07.test06;

public class PlaneTest {

		public static void main(String[] args) {
			
			// Airplane과 Cargoplane 객체 생성
			Plane[] planes = new Plane[2];
			planes[0] = new Airplane("L747", 1000); 
			planes[1] = new Cargoplane("C40", 1000); 
			
			// 생성된 객체의 정보 출력
			System.out.printf("  %-10s   %-10s\n", "Plane", "fuelsize");
			System.out.println("-----------------------------");
			
			for (Plane plane : planes) {
				System.out.printf("  %-10s    %-10s\n", plane.getPlaneName(), plane.getFuelSize());
			}
			
			System.out.println();
			System.out.println("100 운항");
			System.out.printf("  %-10s   %-10s\n", "Plane", "fuelsize");
			System.out.println("-----------------------------");		
			
			for (Plane plane : planes) {
				plane.flight(100);
				System.out.printf("  %-10s    %-10s\n", plane.getPlaneName(), plane.getFuelSize());
			}
			

			// Airplane과 Cargoplane 객체에 200씩 주유
			// 주유 후 객체 의 변경된 정보 출력
			System.out.println();
			System.out.println("200 주유");
			System.out.printf("  %-10s   %-10s\n", "Plane", "fuelsize");
			System.out.println("-----------------------------");		
			
			for (Plane plane : planes) {
				plane.refuel(200);
				System.out.printf("  %-10s    %-10s\n", plane.getPlaneName(), plane.getFuelSize());
			}
		}

}
