package domain;

public class MinusAccountBean extends AccountBean{
	public final static String ACCOUNT_TYPE="마이너스 통장";
	protected int debtLimit;

	public void setDebtLimit(int debtLimit) {
		this.debtLimit = debtLimit;
	}
	public int getDebtLimit() {
		return debtLimit;
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
							"대출잔액 : %s원 \n",
							BANK_NAME, ACCOUNT_TYPE, accountNum, name, uid, date, debtLimit
							);
	}
}
