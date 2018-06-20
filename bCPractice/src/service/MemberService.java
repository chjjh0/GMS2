package service;

import java.util.List;
import domain.MemberBean;
import domain.StaftBean;
import domain.UserBean;
public interface MemberService {
	public void createUser(UserBean user);
	public void createStep(StaftBean Staft);
	public List<MemberBean> list();
	public List<MemberBean> search(String param);
	public MemberBean search(MemberBean member);
	public void update(MemberBean member);
	public void delete(MemberBean member);
}
