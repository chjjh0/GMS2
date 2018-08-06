package dao;

import java.util.List;

import dao.*;
import domain.*;
import service.*;

public class ExamDAOImpl implements ExamDAO{
	public static ExamDAO getInstance() {return instance;}
	public static ExamDAO instance = new ExamDAOImpl();
	public ExamDAOImpl() {}
	@Override
	public void insertExam(ExamBean exam) {
		System.out.println("2");
	}

	@Override
	public List<ExamBean> selectExamList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamBean> selectExamByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamBean selectExamByID(String id) {
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
