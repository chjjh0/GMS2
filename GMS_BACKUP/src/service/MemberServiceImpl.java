package service;

import java.util.List;
import domain.MemberBean;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	private MemberBean session;
	private MemberServiceImpl() {session = new MemberBean();}
	public static MemberService getInstance() {return instance;}

	@Override
	public void createMember(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberBean> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberBean> readSome(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean readOne(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMember(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean login(MemberBean member) {
		session =MemberDAOImpl.getInstance().login(member); 
		return (session!=null);
	}
	@Override
	public String join(MemberBean member) {
		return MemberDAOImpl.getInstance().join(member);
		
	}
	@Override
	public boolean existId(String id) {
		return MemberDAOImpl.getInstance().existID(id);
	}

}
