
beans{
	
	myaddress(com.sec01.MyAddress, "박길동") //앞:객체 뒤: value
	
	//생성자 주입
	myaddress02(com.sec01.MyAddress, "제주도","최주도","010-000-0000") //오버로드 3개받는 생성자
	
	//setter주입
	myaddress03(com.sec01.MyAddress){
		name = "김길동03"    //property name = value
		addr = "김길동03addr"			//세미콜론 ,  -> 사용하지않음
		tel = "김길동03tel"
	}
	
	//setter주입 - 다른 클래스 주입 (참조)
	info(com.sec01.AddressInfo){
		address = ref(myaddress03)  //ref함수 사용
		age = 30
	}
}