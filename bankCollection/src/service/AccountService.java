package service;
import java.util.List;

import domain.*;
public interface AccountService {
	public void createAccount(AccountBean account);
	public AccountBean findById(AccountBean account);
	public void delete(AccountBean account);
	public void update(AccountBean account);
	
}