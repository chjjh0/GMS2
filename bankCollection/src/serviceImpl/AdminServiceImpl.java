package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.*;
import domain.*;
import service.*;

public class AdminServiceImpl implements AdminService {
	public static AdminService getInstance() {return instance;}
	private static AdminService instance = new AdminServiceImpl();
	private AdminServiceImpl() {}
	List<MemberBean> list;
	@Override
	public void createStaff(StaffBean staff) {
		staff.setAccessNum("999");
		list.add(staff);
	}

	@Override
	public List<MemberBean> memberList() {
		return list;
	}

	@Override
	public List<MemberBean> findMemberByName(String param) {
		List<MemberBean> temp = new ArrayList<>();
		for (MemberBean e : list) {
			if (param.equals(e.getName())) {
				temp.add(e);
			}
		}
		return temp;
	}

	@Override
	public MemberBean findMemberById(MemberBean member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountBean> accountList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountBean> findAccountByName(String param) {
		List<AccountBean> temp = new ArrayList<>();
		/*for (AccountBean e : list) {
			if (param.equals(e.getName())) {
				temp.add(e);
			}
		}*/
		return temp;
	}

	@Override
	public String createRandom(int start, int end) {
		return String.valueOf((int) (Math.random() * (end + 1)) + start);
	}

	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
	}

	@Override
	public String createAccountNo() {
		String accountNum = "";
		for (int i = 0; i < 3; i++) {
			accountNum += (i != 2) ? String.format("%03d", Integer.parseInt(createRandom(0, 999))) + "-"
					: String.format("%03d", Integer.parseInt(createRandom(0, 999))) + "";
		}
		return accountNum;
	}


}
