package service;

import java.util.List;
import java.util.Map;
import domain.ImgBean;

public interface ImgService {
	public String add(ImgBean img);
	public List<ImgBean> search(Map<?,?>param);
	public ImgBean retrieve(String id);
	public int count();
	public void modify(Map<?,?>param);
	public void remove(ImgBean img);
	public ImgBean login(ImgBean img);
	public boolean existId(String id);
}
