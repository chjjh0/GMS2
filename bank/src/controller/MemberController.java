package controller;
import javax.swing.JOptionPane;

import controller.AccountController.select;
import domain.*;
import service.*;
import serviceImpl.*;
public class MemberController {
	enum MemberButt {
		EXIT,
		JOIN,
		LIST, FIND_BY_ID, FIND_BY_NAME, COUNT,
		UPDATE,
		WITHDRAWAL,
	};
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null;
		while(true) {
			
		switch((MemberButt)JOptionPane.showInputDialog(
                null,
                "Choice of Account Type",
                "Select Menu",
                JOptionPane.QUESTION_MESSAGE,
                null, new MemberButt[] {MemberButt.EXIT,MemberButt.JOIN,MemberButt.LIST, MemberButt.FIND_BY_ID,
                MemberButt.FIND_BY_NAME,MemberButt.COUNT,MemberButt.UPDATE,MemberButt.WITHDRAWAL}, null)) {
		case EXIT : return;
		case JOIN :
			member = new MemberBean();
			member.setUid(JOptionPane.showInputDialog("아이디"));
			member.setuPasswd(JOptionPane.showInputDialog("비밀번호"));
			member.setName(JOptionPane.showInputDialog("이름"));
			member.setSsn(JOptionPane.showInputDialog("주민번호"));
			member.setEmail(JOptionPane.showInputDialog("이메일"));
			member.setAddr(JOptionPane.showInputDialog("주소"));
			member.setPhone(JOptionPane.showInputDialog("전화번호"));
			service.join(member);
			break;
		case LIST :
			JOptionPane.showMessageDialog(null, service.list());
			break;
		case FIND_BY_ID :
			member = new MemberBean();
			JOptionPane.showMessageDialog(null, service.findById(JOptionPane.showInputDialog("아이디")));
			break;
		case FIND_BY_NAME :
			member = new MemberBean();
			JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("이름")));
			break;
		case COUNT :
			member = new MemberBean();
			String selectcount = JOptionPane.showInputDialog("1: countByUid 2: countByName");
			if(selectcount.equals("1")) {
				JOptionPane.showMessageDialog(null, "countByUid: " +
				service.countSameUid(JOptionPane.showInputDialog("아이디")) + "개");
			} else if(selectcount.equals("2")) {
				JOptionPane.showMessageDialog(null, "countByName: " +
				service.countSameName(JOptionPane.showInputDialog("이름")) + "개");
			} else {
				JOptionPane.showMessageDialog(null, "잘못 선택했습니다");
			}
			break;
		case UPDATE :
			member = new MemberBean();
			String selectUpdate = JOptionPane.showInputDialog("1: MODIFY 2: DELETE");
			if(selectUpdate.equals("1")) {
				member.setUid(JOptionPane.showInputDialog("아이디"));
				member.setuPasswd(JOptionPane.showInputDialog("비밀번호"));
				service.modify(service.authentication(member));
			} else if(selectUpdate.equals("2")) {
				member.setUid(JOptionPane.showInputDialog("아이디"));
				member.setuPasswd(JOptionPane.showInputDialog("비밀번호"));
				service.delete(service.authentication(member));
			} else {
				JOptionPane.showMessageDialog(null, "잘못 선택했습니다");
			}
			break;
		default:
			break;
		}	
			
		}
	}

}
