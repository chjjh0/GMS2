package dao;

import java.util.List;
import domain.*;

public interface ExamDAO {
	public void insertExam(ExamBean exam);
	public List<ExamBean> selectExamList();
	public List<ExamBean> selectExamByName(String name);
	public ExamBean selectExamByID(String id);
	public int countExam();
	public void updateExam(ExamBean exam);
	public void deleteExam(ExamBean exam);
}
