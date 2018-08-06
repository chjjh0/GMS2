package service;

import java.util.List;
import domain.*;
import service.*;
import dao.*;


public class ExamServiceImpl implements ExamService {
	public static ExamService getInstance() {return instance;}
	private static ExamService instance = new ExamServiceImpl();
	private ExamServiceImpl() {}
	@Override
	public void createExam(ExamBean exam) {
		System.out.println(exam);
		ExamDAOImpl.getInstance().insertExam(exam);
	}

	@Override
	public List<ExamBean> findList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamBean> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamBean findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countExam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}
	
}
