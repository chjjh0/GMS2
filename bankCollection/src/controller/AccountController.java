package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;
public class AccountController {
	enum select{EXIT,ACCOUNT,MINUS_ACCOUNT,MINUS_LIST,DEPOSIT,WITHDRAW,LIST,FIND_BY_ID,FIND_BY_NAME};
	public static void main(String[] args) {
		select[] selection = {
                select.EXIT,select.ACCOUNT,select.MINUS_ACCOUNT, select.MINUS_LIST,
                select.DEPOSIT,select.WITHDRAW,select.LIST, select.FIND_BY_ID, select.FIND_BY_NAME, 
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
			account = new MinusAccountBean();
			account.setName(JOptionPane.showInputDialog("이름"));
			account.setUid(JOptionPane.showInputDialog("ID"));
			account.setUpasswd(JOptionPane.showInputDialog("비밀번호"));
			service.createMinusAccount(account);
			break;
		case MINUS_LIST :
			JOptionPane.showMessageDialog(null, service.list());
			break;
		case DEPOSIT :
			account = new AccountBean();
			account.setUid(JOptionPane.showInputDialog("ID"));
			account.setUpasswd(JOptionPane.showInputDialog("비밀번호"));
			service.deposit(service.authentication(account),
					Integer.parseInt(JOptionPane.showInputDialog("입금액을 입력하세요")));
			break;
		case WITHDRAW :
			account = new AccountBean();
			account.setUid(JOptionPane.showInputDialog("ID"));
			account.setUpasswd(JOptionPane.showInputDialog("비밀번호"));
			service.withdraw(service.authentication(account), 
					Integer.parseInt(JOptionPane.showInputDialog("출금액을 입력하세요")));
			break;
		case LIST :
			//JOptionPane.showMessageDialog(null, service.showResult());
			break;
		case FIND_BY_NAME :
			JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("이름")));
			break;
		case FIND_BY_ID :
			int temp;
			while(true) {
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("ID"));
				account.setUpasswd(JOptionPane.showInputDialog("비밀번호")+"/"+
						JOptionPane.showInputDialog("new 비밀번호"));
				temp = service.authentication(account);
				if(temp!=9999) {
					break;
				} else {
					JOptionPane.showMessageDialog(null, "일치하는 ID가 없습니다");
				}
			}
			while(true) {
				account = new AccountBean();
				account.setUpasswd(JOptionPane.showInputDialog("새로운 비밀번호를 입력하세요"));
				String msg = service.changePass(temp, account);
				if("비밀번호 변경 성공".equals(msg)) {break;}
			}
			break;
		}	
			
		}
	}
}