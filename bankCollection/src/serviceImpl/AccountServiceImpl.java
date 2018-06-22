package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import domain.*;
import service.AccountService;

public class AccountServiceImpl implements AccountService {
	public static AccountService getInstance() {return instance;}
	private static AccountService instance = new AccountServiceImpl();
	private AccountServiceImpl() {}
	@Override
	public void createAccount(AccountBean account) {
		/*account.setCreateDate(createDate());
		account.setAccountType(AccountBean.ACCOUNT_TYPE);
		account.setAccountNo(createAccountNo());
		list.add(account);*/
	}



	@Override
	public AccountBean findById(AccountBean account) {
		/*AccountBean acc = new AccountBean();
		for (AccountBean e : list) {
			if (account.getUid().equals(e.getUid())) {
				acc = e;break;
			}
		}
		return acc;*/
		
//		AccountBean acc = new AccountBean();
//		for (int i = 0; i < list.size(); i++) {
//			if (account.getUid().equals(list.get(i).getUid())) {
//				acc = list.get(i);break;
//			}
//		}
		return null;
	}
	@Override
	public void delete(AccountBean account) {
		//list.remove(list.indexOf(findById(account)));
	}

	@Override
	public void update(AccountBean account) {
		//list.get(list.indexOf(findById(account))).setPass(account.getPass());
	}

}