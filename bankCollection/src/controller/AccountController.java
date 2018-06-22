package controller;

import javax.swing.JOptionPane;

import domain.AccountBean;
import domain.MinusAccountBean;
import serviceImpl.*;
import service.*;

public class AccountController {
	public static AccountController getInstance() {return instance;}
	private static AccountController instance = new AccountController();
	private AccountController() {}
	
	public void createAccount() {
		
	}
	public void account() {
		//AccountService service = new AccountServiceImpl();
		AccountBean account = null;
		account = new AccountBean();
		account.setName(JOptionPane.showInputDialog("Name?"));
		account.setUid(JOptionPane.showInputDialog("ID?"));
		account.setPass(JOptionPane.showInputDialog("Pass?"));
		//service.createAccount(account);
	}
	
	

	public void findById() {
		//AccountService service = new AccountServiceImpl();
		AccountBean account = null;
		account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("ID?"));
		//JOptionPane.showMessageDialog(null, service.findById(account));
	}

	public void changePass() {
		//AccountService service = new AccountServiceImpl();
		AccountBean account = null;
		account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("ID?"));
		account.setPass((JOptionPane.showInputDialog("old Pass?") + "/" + (JOptionPane.showInputDialog("New Pass?"))));
		//service.update(account);
	}

	public void deleteAccount() {
		//AccountService service = new AccountServiceImpl();
		AccountBean account = null;
		account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("ID?"));
		//service.delete(account);
	}
}