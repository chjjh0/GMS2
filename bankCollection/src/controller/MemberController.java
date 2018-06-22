package controller;
import javax.swing.JOptionPane;
import domain.*;
import serviceImpl.*;
import service.*;

public class MemberController {
	public static MemberController getInstance() {return instance;}
	private static MemberController instance = new MemberController();
	private MemberController() {}
	public void join(UserBean member) {
		MemberService service = MemberServiceImpl.getInstance();
		System.out.println("========= 멤버 컨트롤러 ===========");
		System.out.println("화면에서 넘어온 객체:"+member);
		service.createUser(member);
	}



	public void update() {
		MemberService service = MemberServiceImpl.getInstance();
		MemberBean member = null;
		member = new StaffBean();
		member.setUid(JOptionPane.showInputDialog("ID?"));
		member.setUid(JOptionPane.showInputDialog("OldPass?") + "/" + (JOptionPane.showInputDialog("NewPass?")));
		service.updatePassword(member);
	}

	public void withdrawal() {
		MemberService service = MemberServiceImpl.getInstance();
		MemberBean member = null;
		member = new StaffBean();
		member.setUid(JOptionPane.showInputDialog("ID?"));
		member.setUid(JOptionPane.showInputDialog("Pass?"));
		service.deleteMember(member);
	}
}