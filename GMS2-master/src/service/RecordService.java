package service;

import java.util.List;
import service.*;
import domain.*;

public interface RecordService {
	public void createRecord(RecordBean record);
	public List<RecordBean> findList();
	public List<RecordBean> findByName(String name);
	public ExamBean findByID(String id);
	public int countRecord();
	public void updateRecord(RecordBean record);
	public void deleteRecord(RecordBean record);
}
