package com.sec11.myutil01;

//Person객체 배열을 Comparable 인터페이스와  Comparator 인터페이스를 활용하여 다양한 기준으로 정렬하자.

import java.util.Arrays;
import java.util.Comparator;

public class Person implements Comparable<Person> { //Comparable<T> 제네릭스 타입을 명시 (캐스팅 하지 않아도 됨)

   private int id;
   private int age;
   private String name;

   public int getId() {
       return id;
   }
  

   public int getAge() {
       return age;
   }

   public String getName() {
       return name;
   }

   public Person(int id,  int age, String name) {
       this.id = id;     
       this.age = age;
       this.name = name;
   }

   
   
   //comparable의 추상메소드를 재정의
   //this.id - m_p.id 결과가 양수이면 this가 더 크고 음수이면 this가 더 작다
   //this.id - m_p.id 결과가 음수(-)   ->this앞에 배치된다.
   //this.id - m_p.id 결과가 양수(+)   ->m_p앞에 배치된다.  
   //this.id - m_p.id 결과가 0   ->순서변동이 없다. 
   //compareTo(루세, 루리) = 111 - 333 = -222 ->유지
   //compareTo(루리, 루오) = 333 - 222 = 111 -> 루오와 루리가 순서 교환
   //compareTo(루세, 루오) = 111 -222 = -111 ->유지  
   @Override
   public int compareTo(Person m_p) {     //Dual-Pivot QuickSort
	   									//제너릭타입으로 명시 한 타입을 넣기 : Person
       return (this.id - m_p.id); //현재 객체 this와 비교대상 m_p의 id값을 비교
   } //객체의 리턴값만큼 루프를 돌음
   
   

   @Override

   public String toString() {
       return "[id=" + this.id +  ", age=" + this.age + ", name=" +
               this.name + "]";
   }

   
   public static Comparator<Person> IdComparator = new Comparator<Person>() { //static-한번 쓰고 버리는 형태(상수처럼 선언)
	   																		//클래스 객체가 아님	-> 익명클래스 (정렬할때 자주 사용)	
	   @Override
       public int compare(Person p1, Person p2) {
           return (p1.getId() - p2.getId());
       }
   };
   //람다식 - public static Comparator<Person> AgeComparator = (p1, p2) -> p1.getAge()- p2.getAge(); //위 코드와 같은 의미인데 축약한 코드
   public static Comparator<Person> AgeComparator = new Comparator<Person>() {	  
       @Override
       public int compare(Person p1, Person p2) {
           return p1.getAge() - p2.getAge();
       }
   };

	public static void main(String[] args) {
		
		Person[] perArr = new Person[3];
		perArr[0] = new Person(111, 25, "루세");
		perArr[1] = new Person(333,  22, "루리");
		perArr[2] = new Person(222,  35, "루오");
		
		System.out.println("정렬 전" );
		
		for(Person res : perArr) {
			System.out.println(res);
		}
		Arrays.sort(perArr); //sort(Object[] a) //자동으로 compareTo()를 호출
        System.out.println("기본 정렬 :\n" + Arrays.toString(perArr));
         
   
        Arrays.sort(perArr, Person.AgeComparator);        
        System.out.println("나이순으로 정렬:\n"+Arrays.toString(perArr));
         
   
        Arrays.sort(perArr, Person.IdComparator);
        System.out.println("Id 순으로 정렬:\n"+Arrays.toString(perArr));

	}

}
