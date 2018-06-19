package service;

import domain.AccountBean;
import domain.MinusAccountBean;

public interface AccountService {
	public void addAccountList(AccountBean account);
	public void addMinusAccountList(AccountBean minusAccount);
	public AccountBean[] list();
	public int authentication(AccountBean account);
	public void deposit(int authentication, int money);
	public void withdraw(int authentication, int money);
	public String createRandom(int start, int end);
	public void createAccount(AccountBean account);
	public void createMinusAccount(AccountBean minusAccount);
	public String createAccountNum();
	public String createDate();
	//public String showResult();
	public int countSameWord(String word);
	public AccountBean[] findByName(String name);
	public String changePass(int authentication, AccountBean account);
}