package service;

import java.util.List;
import java.util.Map;

import domain.ImgBean;
import repository.ImgDAOImpl;

public class ImgServiceImpl implements ImgService{
	private static ImgService instance = new ImgServiceImpl();
	public static ImgService getInstance() {return instance;}
	private ImgServiceImpl() {}
	
	@Override
	public String add(ImgBean img) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImgBean> search(Map<?, ?> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImgBean retrieve(String id) {
		return ImgDAOImpl.getInstance().selectOne("");
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modify(Map<?, ?> param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(ImgBean img) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ImgBean login(ImgBean img) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existId(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
