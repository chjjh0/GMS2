package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import domain.MemberBean;
import domain.StaftBean;
import domain.UserBean;
import service.MemberService;

public class MemberServiceImpl implements MemberService{
	List<MemberBean> list;
	public MemberServiceImpl() {
		list = new ArrayList<MemberBean>();
	}
	@Override
	public void createUser(UserBean user) {
		user.setCreditRating("7등급");
		System.out.println("실행 결과: " 
				+ ((list.add(user)) ? "등록 성공" : "등록 실패"));
	}
	@Override
	public void createStep(StaftBean staft) {
		staft.setAccessNum("9999");
		System.out.println("실행 결과: " 
				+ ((list.add(staft)) ? "등록 성공" : "등록 실패"));
	}
	@Override
	public List<MemberBean> list() {
		return list;
	}
	@Override
	public List<MemberBean> search(String param) {
		List<MemberBean> temp = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(param.equals(list.get(i).getName())) {
				temp.add(list.get(i));
			}
		}
		return temp;
	}
	@Override
	public MemberBean search(MemberBean member) {
		MemberBean dap = new MemberBean();
		for(int i=0;i<list.size();i++) {
			if(member.equals(list.get(i).getUid())) {
				dap = list.get(i);
				break;
			}
		}
		return dap;
	}
	@Override
	public void update(MemberBean member) {
		/*MemberBean m = search(member);
		m.setuPasswd(member.getuPasswd());
		list.add(m);*/
		list.get(list.indexOf(search(member))).setuPasswd(member.getuPasswd());
	}
	@Override
	public void delete(MemberBean member) {
		list.remove(search(member));
	}

}
