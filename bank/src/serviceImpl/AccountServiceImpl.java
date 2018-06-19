package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;

import domain.AccountBean;
import domain.MinusAccountBean;
import service.AccountService;
public class AccountServiceImpl implements AccountService{

	AccountBean[] accountArr;
	MinusAccountBean[] minusArr;
	int countAccount, countMinusAccount;
	
	public AccountServiceImpl () {
		accountArr = new AccountBean[5];
		minusArr = new MinusAccountBean[5];
	}
	@Override
	public void addAccountList(AccountBean account) {
		accountArr[countAccount++] = account; 
	}
	public void addMinusAccountList(AccountBean minusAccount) {
		minusArr[countMinusAccount++] = (MinusAccountBean) minusAccount;
	}
	/*@Override
	public MinusAccountBean[] list() {
		return (MinusAccountBean[]) accountArr;
	}*/
	
	public AccountBean[] list() {
		return accountArr;
	}
	public int authentication(AccountBean account) {
		int correct=0;
		for(int i=0;i<countAccount;i++) {
			if(account.getUid().equals(accountArr[i].getUid()) &&
			   account.getUPasswd().equals(accountArr[i].getUPasswd())) {
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
		accountArr[authentication].setRestMoney(money); 
		//JOptionPane.showMessageDialog(null, account.DEPOSIT_SUCCESS);
	}

	@Override
	public void withdraw(int authentication, int money) {
		if(accountArr[authentication].getRestMoney()<money) {
			//JOptionPane.showMessageDialog(null, account.WITHDRAW_FAIL);
		} else {
			accountArr[authentication].setRestMoney(
					accountArr[authentication].getRestMoney()-money);
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
		addAccountList(account);
	}
	@Override
	public void createMinusAccount(AccountBean minusAccount) {
		minusAccount.setDate(createDate());
		minusAccount.setAccountNum(createAccountNum());
		addAccountList((MinusAccountBean)minusAccount);
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

	/*@Override
	public String showResult() {
		String result="";
		for(int i=0;i<count;i++) {
			result += arr[i];
		}
		return result;
		}*/
	@Override
	public int countSameWord(String word) {
		int countSameName = 0;
		for(int i=0;i<countAccount;i++) {
			if(word.equals(accountArr[i].getName())) {
				countSameName++; 
			}
		}
		return countSameName;
	}
	@Override
	public AccountBean[] findByName(String name) {
		int sameNameCount = 0;
		AccountBean findByNameArr[] = new AccountBean[countSameWord(name)];
		for(int i=0;i<countAccount;i++) {
			if(name.equals(accountArr[i].getName())) {
				findByNameArr[sameNameCount++] = accountArr[i];
			}
		}
		return findByNameArr;
	}
	@Override
	public String changePass(int authentication, AccountBean account) {
		String msg = "";
		if(account.equals(accountArr[authentication].getUPasswd())) {
				msg = "기존 비밀번호와 같습니다, 다르게 입력해주세요";
			} else {
				String temp = account.getUPasswd();
				msg = "비밀번호 변경 성공";
				accountArr[authentication].setUpasswd(temp);
			}
		return msg;
	}
}