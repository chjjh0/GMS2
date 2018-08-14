package repository;

import java.util.List;
import java.util.Map;
import domain.ImgBean;

public interface ImgDAO {
	public String insert(ImgBean img);
	public List<ImgBean> selectSome(Map<?,?>param);
	public ImgBean selectOne(String word);
	public int count();
	public void update(Map<?,?>param);
	public void delete(ImgBean img);
	public ImgBean login(ImgBean img);
	public boolean existID(String id);
}
