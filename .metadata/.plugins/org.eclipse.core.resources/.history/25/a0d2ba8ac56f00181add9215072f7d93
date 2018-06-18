package ui;

import javax.swing.JOptionPane;
import domain.Account;
import domain.MinusAccount;
enum BankButt {
	EXIT,
	ACCOUNT,
	MINUS_ACCOUNT,
	DEPOSIT,
	WITHDRAWA,
}
public class BankMain {
public static void main(String[] args) {
	BankButt[] bankbuttons = {
			   BankButt.EXIT,
			   BankButt.ACCOUNT,
			   BankButt.MINUS_ACCOUNT,
			   BankButt.DEPOSIT,
			   BankButt.WITHDRAWA,
		};
	Account account = null;
	while(true) {
        switch((BankButt)JOptionPane.showInputDialog(
					null,	//frame
					"MATRIX PAGE", //frame title
					"SELECT MATRIX MENU", //ORDER
					JOptionPane.QUESTION_MESSAGE, //type
					null, //icon
					bankbuttons, //array of choices
					null //default
					)) {
        case EXIT : return;
        case ACCOUNT : 
       	 account = new Account(JOptionPane.showInputDialog("이름을 입력하세요"));       	 account.setBalance(JOptionPane.showInputDialog("입금액을 입력하세요"));
       	 JOptionPane.showMessageDialog(null, account.toString());
       	 break;
        case MINUS_ACCOUNT :
         account = new MinusAccount(JOptionPane.showInputDialog("이름을 입력하세요"));
         ((MinusAccount) account).setBalance(JOptionPane.showInputDialog("입금액을 입력하세요"));
         JOptionPane.showMessageDialog(null, account.toString());
         break;
        case DEPOSIT :
        	account.setDeposit(JOptionPane.showInputDialog("입금액을 입력하세요"));
        	JOptionPane.showMessageDialog(null, String.format("잔액 : %s원", account.getBalance()));
        	break;
        case WITHDRAWA :
        	account.setWithdrawa(JOptionPane.showInputDialog("출금액을 입력하세요"));
        	JOptionPane.showMessageDialog(null, String.format("잔액 : %s원", account.getBalance()));
        	break;
       	default : break;
}
}
}
}
