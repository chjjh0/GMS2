package controller;

import java.util.List;

import javax.swing.JOptionPane;
import domain.*;
import serviceImpl.*;
import service.*;

public class AdminController {
	public static AdminController getInstance() {return instance;}
	private static AdminController instance = new AdminController();
	private AdminController() {}
	public void add() {
		MemberService service = MemberServiceImpl.getInstance();
		MemberBean member = null;
		member = new StaffBean();
		member.setName(JOptionPane.showInputDialog("Name?"));
		member.setUid(JOptionPane.showInputDialog("ID?"));
		member.setPass(JOptionPane.showInputDialog("Pass?"));
		member.setSsn(JOptionPane.showInputDialog("SSN?"));
		member.setAddr(JOptionPane.showInputDialog("ADRS?"));
		member.setPhone(JOptionPane.showInputDialog("PHONE?"));
		member.setEmail(JOptionPane.showInputDialog("EMAIL?"));
		//service.createStaff((StaffBean) member);
	}

	public void memberList() {
		MemberService service = MemberServiceImpl.getInstance();
		//JOptionPane.showMessageDialog(null, service.list());
	}
	

	public void findMemberById() {
		MemberService service = MemberServiceImpl.getInstance();
		MemberBean member = null;
		member = new StaffBean();
		member.setUid(JOptionPane.showInputDialog("ID?"));
		//JOptionPane.showMessageDialog(null, service.findById(member));
	}

	public void findMemberByName() {
		MemberService service = MemberServiceImpl.getInstance();
		//JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("name?")));
	}
	public void accountList() {
		AccountService service = AccountServiceImpl.getInstance();
		//JOptionPane.showMessageDialog(null, service.list());
	}

	public void findByName() {
		AccountService service = AccountServiceImpl.getInstance();
		//JOptionPane.showMessageDialog(null, service.findByName((JOptionPane.showInputDialog("Name?"))));
	}
}











