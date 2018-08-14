package repository;

import java.util.*;
import domain.*;
import enums.*;
import template.*;

public class ImgDAOImpl implements ImgDAO{
	private static ImgDAO instance = new ImgDAOImpl();
	public static ImgDAO getInstance() {return instance;}
	private ImgDAOImpl() {}
	@Override
	public String insert(ImgBean img) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ImgBean> selectSome(Map<?, ?> param) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ImgBean selectOne(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void update(Map<?, ?> param) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(ImgBean img) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ImgBean login(ImgBean img) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean existID(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}