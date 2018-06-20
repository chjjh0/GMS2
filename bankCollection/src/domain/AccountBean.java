package domain;

public class AccountBean {
	public final static String BANK_NAME="비트뱅크";
	public final static String ACCOUNT_TYPE="기본통장";
	public final static String WITHDRAW_SUCCESS="출금 성공";
	public final static String WITHDRAW_FAIL="잔액이 부족합니다";
	public final static String DEPOSIT_SUCCESS="입금 성공";
	public final static String DEPOSIT_FAIL="적합한 입력값이 아님";
	public final static String BALANCE_ERROR="잔액이 부족합니다";
	protected String name, uid, uPasswd, date, accountNum;
	protected int restMoney;

	public void setName(String name) {
		this.name = name;
	}
	public void setUid (String uid) {
		this.uid = uid;
	}
	public void setUpasswd (String upasswd) {
		this.uPasswd = upasswd;
	}
	public void setDate (String date) {
		this.date = date;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum; 
	}
	public void setRestMoney(int money) {
		this.restMoney = money;
	}
	public String getName() {
		return name;
	}
	public String getUid() {
		return uid;
	}
	public String getUPasswd() {
		return uPasswd;
	}
	public String getDate () {
		return date;
	}
	public String getAccountNum() {
		return accountNum; 
	}
	public int getRestMoney() {
		return restMoney;
	}
	public String toString() {
		return String.format(
							"%s \n"+
							"%s \n" +
							"계좌번호 : %s \n" +
							"이름 : %s \n" +
							"ID : %s \n" +
							"비밀번호 : **** \n" +
							"생성일 : %s \n" +
							"잔액 : %s원 \n",
							BANK_NAME, ACCOUNT_TYPE, accountNum, name, uid, date, restMoney
							);
	}
}