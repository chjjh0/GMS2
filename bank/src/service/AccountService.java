package service;

import domain.AccountBean;

public interface AccountService {
	public void addList(AccountBean account);
	public AccountBean[] list();
	public int authentication(AccountBean account);
	public void deposit(int authentication, int money);
	public void withdraw(int authentication, int money);
	public String createRandom(int start, int end);
	public void createAccount(AccountBean dto);
	public String createAccountNum();
	public String createDate();
	public String showResult();
	public int countSameWord(String word);
	public AccountBean[] findByName(String name);
}