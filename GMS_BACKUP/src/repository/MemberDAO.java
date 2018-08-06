package repository;

import java.util.List;

import domain.MemberBean;

public interface MemberDAO {
	public MemberBean insertMember(MemberBean member);
	public List<MemberBean> list();
	public List<MemberBean> readSome(String word);
	public MemberBean readOne(String word);
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public MemberBean login(MemberBean member);
	public String join(MemberBean member);
	public boolean existID(String id);
}
