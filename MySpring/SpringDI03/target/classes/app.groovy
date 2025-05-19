beans{
	
	myaddress(com.sec01.MyAddress , "박길동") // 생성자로 값 전달
	
	myaddress02(com.sec01.MyAddress, "최제주도","제주도","111-1111") // 생성자로 값 전달
	
	myaddress03(com.sec01.MyAddress){ // setter값 전달
		name  ="김길동" 
		addr="김길동주소"
		tel  ="김길동전화번호"		
	}
	
	info(com.sec01.AddressInfo ){
		  address = ref(myaddress03)
		  age  = 30 		
	}	
	
}