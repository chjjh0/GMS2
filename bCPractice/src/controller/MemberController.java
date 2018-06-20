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
