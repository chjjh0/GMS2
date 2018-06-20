package serviceImpl;
/*package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;

import domain.AccountBean;
import service.AccountService;
public class AccountImplBackup implements AccountService{

	AccountBean[] arr;
	AccountBean account;
	int count;
	
	public AccountServiceImpl () {
		arr = new AccountBean[5];
	}
	@Override
	public void addList(AccountBean account) {
		arr[count++] = account; 
	}
	@Override
	public AccountBean[] list() {
		return arr;
	}
	public int authentication(String name, String uid, String upasswd) {
		int correct=0;
		for(int i=0;i<count;i++) {
			if(arr[i].getName().equals(name) &&  
					arr[i].getUid().equals(uid) &&
					arr[i].getUPasswd().equals(upasswd)) {
			correct=i;
			break;
		} else {
				correct = 9999;
			}
		}
			return correct;
		}
	@Override
	public void deposit(int authentication, int money) {
		arr[authentication].setRestMoney(money); 
		JOptionPane.showMessageDialog(null, account.DEPOSIT_SUCCESS);
	}

	@Override
	public void withdraw(int authentication, int money) {
		if(arr[authentication].getRestMoney()<money) {
			JOptionPane.showMessageDialog(null, account.WITHDRAW_FAIL);
		} else {
			arr[authentication].setRestMoney(
					arr[authentication].getRestMoney()-money);
			JOptionPane.showMessageDialog(null, account.WITHDRAW_SUCCESS);
		}
	}
	@Override
	public String createRandom(int start, int end) {
		return null;
	}

	@Override
	public void createAccount(AccountBean dto) {
		account = dto;
		createDate();
		createAccountNum();
		addList(account);
	}

	@Override
	public void createAccountNum() {
		Random randomAccNo = new Random();
		String accountNo = "";
		for(int i=0;i<3;i++) {
			accountNo += (i>=2) ?
					randomAccNo.nextInt(999)+100 + "" :
					randomAccNo.nextInt(999)+100 + "-";
		}
		account.setAccountNum(accountNo);
	}

	@Override
	public void createDate() {
		account.setDate(new SimpleDateFormat("yyyy년 MM월 dd일")
	    		.format(new Date()));
	}

	@Override
	public String showResult() {
		String result="";
		for(int i=0;i<count;i++) {
			result += arr[i];
		}
		return result;
		}
}*/