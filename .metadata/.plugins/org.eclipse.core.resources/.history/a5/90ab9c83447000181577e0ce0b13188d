package domain;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
비트뱅크
기본통장
계좌번호 : 123-456-789
이름 : 홍길동
생성일 : 2018년 6월10일
잔액 : 10000원
-------------
비트뱅크
마이너스통장
계좌번호 : 123-456-789
이름 : 홍길동
생성일 : 2018년 6월10일
잔액 : -10000원 
마이너스통장은 상속을이용!!
*/
//입출금 아님. 한번만 돌리는것 해보기.
import java.util.Random;
public class Account {
	public final static String BANK_NAME="비트뱅크";
	public final static String ACCOUNT_TYPE="기본통장";
	public final static String WITHDRAW_SUCCESS="출금성공";
	public final static String WITHDRAW_FAIL="잔액부족";
	public final static String DEPOSIT_SUCCESS="입금성공";
	public final static String DEPOSIT_FAIL="적합한 입력값이 아님";
	public final static String BALANCE_ERROR="잔액이 부족합니다";
	protected String accountNo, name, date, uid;
	public static String balance;
	public Account(String name) {
		accountNo = "";
		date = "";
		balance = "0";
		this.name = name;
		setAccountNo();
		setDate();
	}
	public void setAccountNo() {
		Random randomAccNo = new Random();
		String accountNo = "";
		for(int i=0;i<3;i++) {
			accountNo += (i>=2) ?
					randomAccNo.nextInt(999)+100 + "" :
					randomAccNo.nextInt(999)+100 + "-";
		}
		this.accountNo += accountNo;
	}
	public void setBalance(String money) {
		this.balance = String.valueOf(
				Integer.parseInt(balance) +
				Integer.parseInt(money));
	}
	public void setDate() {
	    this.date = new SimpleDateFormat("yyyy년 MM월 dd일")
	    		.format(new Date());
	}
	public void setDeposit(String money) {
		balance = String.valueOf(
				Integer.parseInt(balance) +
				Integer.parseInt(money));
	}
	public void setWithdrawa(String money) {
		if(Integer.parseInt(balance) 
		   < Integer.parseInt(money)) {
				
			
			balance = String.valueOf(
				Integer.parseInt(balance) -
				Integer.parseInt(money));
		}
	}
	public String getAccountNo() {
		return accountNo;
	}
	public String getName() {
		return name;
	}
	public String getBalance() {
		return balance;
	}
	public String getDate() {
		return date;
	}
	public String toString() {
		return String.format("%s \n"+
							"%s \n" +
							"계좌번호 : %s \n" +
							"이름 : %s \n" +
							"생성일 : %s \n" +
							"잔액 : %s원 \n",
							BANK_NAME, ACCOUNT_TYPE, accountNo, name, date, balance
							);
	}
}