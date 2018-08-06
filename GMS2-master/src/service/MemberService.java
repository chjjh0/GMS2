package service;

import java.util.List;
import java.util.Map;
import domain.MemberBean;

public interface MemberService {
		public boolean login(MemberBean member);
		public void createMember(MemberBean member);
		public List<MemberBean> findList();
		public List<MemberBean> getList(Map<?, ?> param);
		public List<MemberBean> findBySome(String[] some);
		public MemberBean findByID(String id);
		public int countMember();
		public void updateMember(MemberBean member);
		public void deleteMember(MemberBean member);
	}
