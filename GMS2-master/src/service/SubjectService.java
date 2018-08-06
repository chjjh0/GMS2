package service;

import java.util.List;
import domain.SubjectBean;

public interface SubjectService {
	public void createSubject(SubjectBean subject);
	public List<SubjectBean> findList();
	public List<SubjectBean> findByName(String name);
	public SubjectBean findByID(String id);
	public int countSubject();
	public void updateSubject(SubjectBean subject);
	public void deleteSubject(SubjectBean subject);	
}
