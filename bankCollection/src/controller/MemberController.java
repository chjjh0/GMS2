package controller;
import javax.swing.JOptionPane;

import controller.AccountController.select;
import domain.*;
import service.*;
import serviceImpl.*;
public class MemberController {
	enum MemberButt {
		EXIT,
		JOIN_USER, JOIN_STEP,
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
                null, new MemberButt[] {MemberButt.EXIT,MemberButt.JOIN_USER,MemberButt.JOIN_STEP, MemberButt.LIST, MemberButt.FIND_BY_ID,
                MemberButt.FIND_BY_NAME,MemberButt.COUNT,MemberButt.UPDATE,MemberButt.WITHDRAWAL}, null)) {
		case EXIT : return;
		case JOIN_USER :
			member = new UserBean();
			member.setUid(JOptionPane.showInputDialog("아이디"));
			member.setuPasswd(JOptionPane.showInputDialog("비번"));
			member.setName(JOptionPane.showInputDialog("이름"));
			member.setEmail(JOptionPane.showInputDialog("이메일"));
			member.setAddr(JOptionPane.showInputDialog("주소"));
			member.setPhone(JOptionPane.showInputDialog("전화번호"));
			service.createUser((UserBean)member);
			break;
		case JOIN_STEP :
			member = new StaftBean();
			member.setUid(JOptionPane.showInputDialog("아이디"));
			member.setuPasswd(JOptionPane.showInputDialog("비번"));
			member.setName(JOptionPane.showInputDialog("이름"));
			member.setEmail(JOptionPane.showInputDialog("이메일"));
			member.setAddr(JOptionPane.showInputDialog("주소"));
			member.setPhone(JOptionPane.showInputDialog("전화번호"));
			service.createStep((StaftBean)member);
			break;
		case LIST :
			break;
		case FIND_BY_ID :
			break;
		case FIND_BY_NAME :
			break;
		case COUNT :
			break;
		case UPDATE :
			break;
		default:
			break;
		}	
			
		}
	}

}
