package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;

import domain.AccountBean;
import service.AccountService;
public class AccountServiceImpl implements AccountService{

	AccountBean[] arr;
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
	public int authentication(AccountBean account) {
		int correct=0;
		for(int i=0;i<count;i++) {
			if(account.getName().equals(arr[i].getName()) &&  
			   account.getUid().equals(arr[i].getUid()) &&
			   account.getUPasswd().equals(arr[i].getUPasswd())) {
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
		//JOptionPane.showMessageDialog(null, account.DEPOSIT_SUCCESS);
	}

	@Override
	public void withdraw(int authentication, int money) {
		if(arr[authentication].getRestMoney()<money) {
			//JOptionPane.showMessageDialog(null, account.WITHDRAW_FAIL);
		} else {
			arr[authentication].setRestMoney(
					arr[authentication].getRestMoney()-money);
			//2JOptionPane.showMessageDialog(null, account.WITHDRAW_SUCCESS);
		}
	}
	@Override
	public String createRandom(int start, int end) {
		return null;
	}

	@Override
	public void createAccount(AccountBean account) {
		account.setDate(createDate());
		account.setAccountNum(createAccountNum());
		addList(account);
	}

	@Override
	public String createAccountNum() {
		Random randomAccNo = new Random();
		String accountNo = "";
		for(int i=0;i<3;i++) {
			accountNo += (i>=2) ?
					randomAccNo.nextInt(999)+100 + "" :
					randomAccNo.nextInt(999)+100 + "-";
		}
		return accountNo;
	}

	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일")
	    		.format(new Date());
	}

	@Override
	public String showResult() {
		String result="";
		for(int i=0;i<count;i++) {
			result += arr[i];
		}
		return result;
		}
	@Override
	public int countSameWord(String name) {
		int countSameName = 0;
		for(int i=0;i<count;i++) {
			if(name.equals(arr[i].getName())) {
				countSameName++; 
			}
		}
		return countSameName;
	}
	@Override
	public AccountBean[] findByName(String name) {
		int sameNameCount = 0;
		AccountBean findByNameArr[] = new AccountBean[countSameWord(name)];
		for(int i=0;i<count;i++) {
			if(name.equals(arr[i].getName())) {
				findByNameArr[sameNameCount++] = arr[i];
			}
		}
		return findByNameArr;
	}
	
}