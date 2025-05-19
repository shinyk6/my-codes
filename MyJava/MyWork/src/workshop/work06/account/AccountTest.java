package workshop.work06.account;

//workshop6-5
public class AccountTest {

	public static void main(String[] args) {
		
		Account account = new Account();
		Account account1 = new Account("441-0290-1203", 500000, 7.3);  //생성자로 값 전달
		
		account.setAccount("441-0290-1203");
		account.setBalance(500000);
		account.setInterestRate(7.3);  //set으로 값전달
		
		//기본 정보 출력
		System.out.println("계좌정보: "+ account1.getAccount()+" 현재잔액: "+account1.getBalance());
		
		//account에서 600000원 출금
		account1.withdraw(600000);
		
		//account에 20000원 입금
		account1.deposit(20000);
		
		//account 변경 정보 출력
		System.out.println("계좌정보: "+ account1.getAccount()+" 현재잔액: "+account1.getBalance());		
		
		//이자 출력
		System.out.printf("이자: %.1f",account1.calculateInterest());
		
	}

}
