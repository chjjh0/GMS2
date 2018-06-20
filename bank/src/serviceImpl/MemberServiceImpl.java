package serviceImpl;

import javax.swing.JOptionPane;

import domain.MemberBean;
import service.MemberService;

public class MemberServiceImpl implements MemberService{
	MemberBean[] arr = null;
	int countMember, countUid, countName;
	public MemberServiceImpl() {
		arr = new MemberBean[5];
	}
	@Override
	public void addList(MemberBean member) {
		arr[countMember++] = member;
	}
	@Override
	public void join(MemberBean member) {
		addList(member);
	}
	@Override
	public MemberBean[] list() {
		return arr;
	}
	@Override
	public int countSameUid(String uid) {
		countUid = 0;
		for(int i=0;i<countMember;i++) {
			if(uid.equals(arr[i].getUid())) {
				countUid++;
			}
		}
		return countUid;
	}
	@Override
	public MemberBean findById(String uid) {
		MemberBean searchUid = new MemberBean();
		for(int i=0;i<countMember;i++){
			if(uid.equals(arr[i].getUid())){
				searchUid = arr[i];
				break;
			}
		}
		return searchUid;
	}
	@Override
	public int countSameName(String name) {
		countName = 0;
		for(int i=0;i<countMember;i++) {
			if(name.equals(arr[i].getName())) {
				countName++;
			}
		}
		return countName;
	}
	@Override
	public MemberBean[] findByName(String name) {
		MemberBean[] arrName= new MemberBean[countSameName(name)];
		int countArrUid = 0;
		for(int i=0;i<countMember;i++){
			if(name.equals(arr[i].getName())){
				arrName[countArrUid++] = arr[i];
			}
		}
		return arrName;
	}
	@Override
	public int authentication(MemberBean member) {
		int countAuth = 0;
		for(int i=0;i<countMember;i++) {
			if(member.getUid().equals(arr[i]) &&
			   member.getuPasswd().equals(arr[i])) {
				countAuth = i;
			}
		}
		return countAuth;		
	}
	@Override
	public String modify(int index) {
		arr[index].setAddr(JOptionPane.showInputDialog("주소"));
		arr[index].setEmail(JOptionPane.showInputDialog("이메일"));
		arr[index].setPhone(JOptionPane.showInputDialog("전화번호"));
		String succes = "회원정보 변경 성공";
		return succes;
	}
	public void delete(int index) {
		arr[index] = arr[--countMember];
		arr[countMember] = null;
	}

}
