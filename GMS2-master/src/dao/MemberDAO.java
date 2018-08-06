package dao;

import java.util.List;
import java.util.Map;
import domain.MemberBean;

public interface MemberDAO {
	public MemberBean login(MemberBean member);
	public void insertMember(MemberBean member);
	public List<MemberBean> selectMemberList();
	public List<MemberBean> selectList(Map<?, ?> param);
	public List<MemberBean> selectMemberBySome(String[] name);
	public MemberBean selectMemberByID(String id);
	public int countMember();
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public String join(MemberBean member);
}
