package service;

import java.util.List;

import domain.ExamBean;
import domain.RecordBean;

public class RecordServiceImpl implements RecordService {
	public static RecordService getInstance() {return instance;}
	public static RecordService instance = new RecordServiceImpl();
	public RecordServiceImpl() {}
	@Override
	public void createRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RecordBean> findList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecordBean> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamBean findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countRecord() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}

}
