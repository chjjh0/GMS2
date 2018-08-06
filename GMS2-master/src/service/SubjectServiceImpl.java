package service;

import java.util.List;
import domain.SubjectBean;

public class SubjectServiceImpl implements SubjectService{
	public static SubjectService getInstance() {return instance;}
	public static SubjectService instance = new SubjectServiceImpl();
	public SubjectServiceImpl() {}
	@Override
	public void createSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SubjectBean> findList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectBean> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectBean findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countSubject() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

}
