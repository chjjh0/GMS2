package service;

import domain.MemberBean;
public interface MemberService {
	public void join(MemberBean member);
	public void addList(MemberBean member);
	public MemberBean[] list();
	public int countSameUid(String uid);
	public MemberBean findById(String uid);
	public int countSameName(String name);
	public MemberBean[] findByName(String name);
	public String modify(int index);
	public void delete(int index);
	public int authentication(MemberBean member);

}
