package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.*;
import domain.*;

public class MemberServiceImpl implements MemberService{
	public static MemberService getInstance() {return instance;}
	private static MemberService instance = new MemberServiceImpl();
	private MemberServiceImpl() {}
	@Override
	public void createMember(MemberBean member) {
		MemberDAOImpl.getInstance().insertMember(member);
	}
	@Override
	public List<MemberBean> getList(Map<?, ?> param) {
		return MemberDAOImpl.getInstance().selectList(param);
	}
	@Override
	public List<MemberBean> findList() {
		return MemberDAOImpl.getInstance().selectMemberList();
	}

	@Override
	public List<MemberBean> findBySome(String[] some) {
		return MemberDAOImpl.getInstance().selectMemberBySome(some);
	}

	@Override
	public MemberBean findByID(String id) {
		return MemberDAOImpl.getInstance().selectMemberByID(id);
	}

	@Override
	public int countMember() {
		return MemberDAOImpl.getInstance().countMember();
	}

	@Override
	public void updateMember(MemberBean member) {
		MemberDAOImpl.getInstance().updateMember(member);		
	}

	@Override
	public void deleteMember(MemberBean member) {
		MemberDAOImpl.getInstance().deleteMember(member);
	}
	@Override
	public boolean login(MemberBean member) {
		return ((MemberDAOImpl.getInstance().login(member))!=null);
	}
	
}
