package service;

import java.util.List;
import domain.*;

public interface AdminService {
	public void createStaff(StaffBean staff);
	public List<MemberBean> memberList();  //Arraylist의 최상위 개념인 List로 써야 한다. StaffBean UserBean이 아닌 MemberBean을 쓰는 이유이다.
	public List<MemberBean> findMemberByName(String param);
	public MemberBean findMemberById(MemberBean member);
	public List<AccountBean> accountList();
	public List<AccountBean> findAccountByName(String param);
	public String createRandom(int start, int end);
	public String createDate();
	public String createAccountNo();
}
