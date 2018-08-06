package service;

import domain.*;
import java.util.List;

public interface ExamService {
	public void createExam(ExamBean exam);
	public List<ExamBean> findList();
	public List<ExamBean> findByName(String name);
	public ExamBean findByID(String id);
	public int countExam();
	public void updateExam(ExamBean exam);
	public void deleteExam(ExamBean exam);
}
