package test;

import java.util.ArrayList;
import java.util.List;

import domain.MemberBean;
import service.MemberServiceImpl;

public class testList {
public static void main(String[] args) {
	List<MemberBean> list = new ArrayList<>();
	list = MemberServiceImpl.getInstance().findList();
	System.out.println(list);
}
}
