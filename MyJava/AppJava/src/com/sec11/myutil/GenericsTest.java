package com.sec11.myutil;

public class GenericsTest {

	public static void main(String[] args) {		

		
		MyClass<? extends A> m_c = new MyClass<>(new C());	//value에의해 왼쪽 타입이 결정되어 참조됨 C타입만 전달이 됨	
		m_c.doTest();
		
		m_c = new MyClass<B>(new B());
		m_c.doTest();
		
		m_c = new MyClass<A>(new A());
		m_c.doTest();
		
		m_c = new MyClass<D>(new D());
		

		MyClass<? super C> m_T = new MyClass<A>(new A());		
		m_T.doTest();
		
	   m_T = new MyClass<C>(new C());		
	   m_T.doTest();
       
    }
}

class MyClass<T extends A>{  //A를 상속  받는 자식 모두  
   private T obj;
  
	public MyClass(T obj){
        this.obj = obj;
    }     
	
	public void  doTest(){
		 obj.my_print();
	}
}

class A{
	  public void my_print(){
        System.out.println("I am in super class A");
    }
}
 
class B extends A{
	  public void my_print(){
        System.out.println("I am in sub class B");
    }
}
 
class C extends A{
    public void my_print(){
        System.out.println("I am in sub class C");
    }

}


class D extends A{
    public void my_print(){
        System.out.println("I am in sub class D");
    } 
}
