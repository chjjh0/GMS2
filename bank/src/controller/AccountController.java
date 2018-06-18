package controller;

import javax.swing.JOptionPane;

import domain.*;
import service.*;
import serviceImpl.*;
public class AccountController {
	enum select{EXIT,ACCOUNT,MINUS_ACCOUNT,DEPOSIT,WITHDRAW,LIST,FINDBYNAME};
	public static void main(String[] args) {
		select[] selection = {
                select.EXIT,select.ACCOUNT,select.MINUS_ACCOUNT,
                select.DEPOSIT,select.WITHDRAW,select.LIST, select.FINDBYNAME
        };
		AccountServiceImpl service = new AccountServiceImpl();
		AccountBean account = null;
		while(true) {
			select option = (select)JOptionPane.showInputDialog(
                    null,
                    "Choice of Account Type",
                    "Select Menu",
                    JOptionPane.QUESTION_MESSAGE,
                    null, selection, selection[1]);	
		switch(option) {
		case EXIT : return;
		case ACCOUNT :
			account = new AccountBean();
			account.setName(JOptionPane.showInputDialog("이름"));
			account.setUid(JOptionPane.showInputDialog("ID"));
			account.setUpasswd(JOptionPane.showInputDialog("비밀번호"));
			service.createAccount(account);
			break;
		case MINUS_ACCOUNT :
			break;
		case DEPOSIT :
			account = new AccountBean();
			account.setName(JOptionPane.showInputDialog("이름"));
			account.setUid(JOptionPane.showInputDialog("ID"));
			account.setUpasswd(JOptionPane.showInputDialog("비밀번호"));
			service.deposit(service.authentication(account),
					Integer.parseInt(JOptionPane.showInputDialog("입금액을 입력하세요")));
			break;
		case WITHDRAW :
			account = new AccountBean();
			account.setName(JOptionPane.showInputDialog("이름"));
			account.setUid(JOptionPane.showInputDialog("ID"));
			account.setUpasswd(JOptionPane.showInputDialog("비밀번호"));
			service.withdraw(service.authentication(account), 
					Integer.parseInt(JOptionPane.showInputDialog("출금액을 입력하세요")));
			break;
		case LIST :
			JOptionPane.showMessageDialog(null, service.showResult());
			break;
		case FINDBYNAME :
			account = new AccountBean();
			JOptionPane.showMessageDialog(null, service.findByName((JOptionPane.showInputDialog("이름"))));
			break;
		}	
			
		}
	}
}