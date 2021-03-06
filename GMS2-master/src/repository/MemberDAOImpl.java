package repository;

import java.util.*;
import domain.*;
import enums.*;
import template.*;

public class MemberDAOImpl implements MemberDAO{
	private QueryTemplate q;
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	
	@Override
	public MemberBean selectOne(String word) {
		q = new RetrieveQuery();
		Map<String,Object> map = new HashMap<>();
		map.put("table", word.split("/")[0]);
		map.put("column", word.split("/")[1].toUpperCase());
		map.put("value", word.split("/")[2]);
		q.play(map);
		return (MemberBean) q.getO();
	}

	@Override
	public void update(Map<?,?>param) {
		//QueryTemplate 양식에 updateQuery 기능들 사용
		q = new UpdateQuery();
		q.play(param);
	}

	@Override
	public void delete(MemberBean member) {
	
	}
	
	@Override
	public MemberBean login(MemberBean member) {
		q = new LoginQuery();
		HashMap<String, Object>map = new HashMap<>();
		map.put("memid", member.getMemberId());
		map.put("pass", member.getPass());
		q.play(map);
		return (MemberBean) q.getO();
	}
	@Override
	public String insert(MemberBean member) {
		String result = "";
		q = new AddQuery();
		HashMap<String, Object>map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("switch","insert");
		map.put("value1", member.getMemberId());
		map.put("value2", member.getName());
		map.put("value4", member.getPass());
		map.put("value3", member.getSsn());
		map.put("value5", member.getAge());
		map.put("value6", member.getGender());
		map.put("value7", member.getRoll());
		map.put("value8", member.getTeamId().toUpperCase());
		q.play(map);
		return result;
		
	}
	@Override
	public boolean existID(String id) {
		boolean flag = false;
		return flag;
	}
	@Override
	public int count() {
		q = new CountQuery();
		q.play();
		return q.getNumber();
	}
	
	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		System.out.println(">");
		System.out.println("< MemberDAOImpl.selectSome >");
		List<MemberBean> list = new ArrayList<>();
		q = new SearchQuery();
		q.play(param);
		for(Object s : q.getList()) {
			//Object type의 list를 MemberBean으로 형변환
			list.add((MemberBean) s);
		}
		return list;
	}

}








