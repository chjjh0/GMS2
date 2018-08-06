package dao;

import java.util.List;
import domain.*;

public interface SubjectDAO {
	public void insertSubject(SubjectBean subject);
	public List<SubjectBean> selectSubjectList();
	public List<SubjectBean> selectSubjectByName(String name);
	public SubjectBean selectSubjectByID(String id);
	public int countSubject();
	public void updateSubject(SubjectBean subject);
	public void deleteSubject(SubjectBean subject);
}
