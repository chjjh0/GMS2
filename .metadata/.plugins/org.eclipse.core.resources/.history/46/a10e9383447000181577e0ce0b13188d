package domain;

public class MinusAccount extends Account{
	public final static String BANK_NAME="비트뱅크";
	public final static String ACCOUNT_TYPE="마이너스  통장";
	public MinusAccount(String name) {
		super(name);
	}
	public void setBalance(String balance) {
		this.balance += "-" + balance + "원";
	}
	public String toString() {
		setAccountNo();
        setDate();
		return String.format("%s \n"+
							"%s \n" +
							"%s \n" +
							"%s \n" +
							"%s \n" +
							"%s \n",
							BANK_NAME, ACCOUNT_TYPE, accountNo, name, date, balance
							);
}
}
