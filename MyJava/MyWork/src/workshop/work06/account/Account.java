package workshop.work06.account;

public class Account {

	private String account;	//계좌번호
	private int balance;	//잔액
	private double interestRate;	//이율
	
	public Account() {
		super();
	}

	public Account(String account, int balance, double interestRate) {
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	double calculateInterest() {
		//현재 잔액을 기준으로 이자를 계산
		return balance*interestRate*0.01;
	}
	
	void deposit(int money) {
		//잔액정보 증가
		this.balance += money;
	}
	
	void withdraw(int money) {
		//출금을 통해 잔액정보를 감소 //단 출금을 통해 잔액이 0보다 적으면 "출금 할 수 없습니다." 출력
			if(this.balance-money<0) {
				System.out.println("출금 할 수 없습니다.");
			}else{
				this.balance -= money;
			}
			
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	
	
}
