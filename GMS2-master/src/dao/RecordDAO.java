package dao;

import java.util.List;
import domain.*;

public interface RecordDAO {
	public void insertRecord(RecordBean record);
	public List<RecordBean> selectRecordList();
	public List<RecordBean> selectRecordByName(String name);
	public ExamBean selectRecordByID(String id);
	public int countRecord();
	public void updateRecord(RecordBean record);
	public void deleteRecord(RecordBean record);
}
