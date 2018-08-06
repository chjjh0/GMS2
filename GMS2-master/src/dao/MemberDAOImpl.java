package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import enums.Vendor;
import factory.DatabaseFactory;
import pool.DBConstant;
import template.PstmtQuery;
import template.QueryTemplate;

public class MemberDAOImpl implements MemberDAO{
	public static MemberDAO getInstance() {return instance;}
	private static MemberDAO instance = new MemberDAOImpl();
	private MemberDAOImpl() {}
	Connection conn;
	Statement stmt;
	
	@Override
	public void insertMember(MemberBean member) {
		try{
		//excuteUpdate의 return 이 int 값이 돌아온다 성공:1 실패:0
		//return의 용도는 개발자의 디버깅용도이며
		//사용법은 DatabaseFactory 앞에 int a 로 받아주면 됨
		System.out.println("DAO_insertMember");
		System.out.println(MemberQuery.INSERT_MEMBER.toString());
		DatabaseFactory.createDataBase(
				Vendor.ORACLE,
				DBConstant.UID,
				DBConstant.PWD)
		.getConnection()
		.createStatement()
		.executeQuery(String.format(
				MemberQuery.INSERT_MEMBER.toString(),
				member.getMemId(),
				member.getTeamId(),
				member.getName(),
				member.getRoll(),
				member.getSsn(),
				member.getPassword()
				//member.getGender()
				));
		
		//memId, teamId, name, age, roll, ssn, password
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<MemberBean> selectList(Map<?, ?> param) {
		System.out.println("DAO < selectList >");
		MemberBean m = null;
		List<MemberBean> list = null;
		String beginRow = param.get("beginRow").toString();
		String endRow = param.get("endRow").toString();
		System.out.println("begin row "+beginRow);
		System.out.println("end row "+endRow);
		System.out.println("query");
		System.out.println(MemberQuery.LIST.toString());
		try {
			ResultSet rs = DatabaseFactory.createDataBase(
							Vendor.ORACLE,
							DBConstant.UID,
							DBConstant.PWD)
			.getConnection()
			.createStatement()
			.executeQuery(String.format(
					MemberQuery.LIST.toString(), 
					beginRow,
					endRow));
			list = new ArrayList<>();
			while(rs.next()) {
				m = new MemberBean();
				m.setMemId(rs.getString("MEMID"));
				m.setTeamId(rs.getString("TEAMID"));
				m.setName(rs.getString("NAME"));
				m.setAge(rs.getString("AGE"));
				m.setRoll(rs.getString("ROLL"));
				//m.setPassword(rs.getString("PASSWORD"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public List<MemberBean> selectMemberList() {
		MemberBean m = null;
		List<MemberBean> mList = null;
		try {
			ResultSet rs = DatabaseFactory.createDataBase(
							Vendor.ORACLE,
							DBConstant.UID,
							DBConstant.PWD)
			.getConnection()
			.createStatement()
			.executeQuery(MemberQuery.LIST.toString());
			mList = new ArrayList<>();
			while(rs.next()) {
				m = new MemberBean();
				m.setMemId(rs.getString("MEMID"));
				m.setTeamId(rs.getString("TEAMID"));
				m.setName(rs.getString("NAME"));
				m.setAge(rs.getString("AGE"));
				m.setRoll(rs.getString("ROLL"));
				//m.setPassword(rs.getString("PASSWORD"));
				mList.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mList;
	}
	/*@Override
	public List<MemberBean> selectMemberBySome(String[] some) {
		System.out.println("< selectMemberBySome >");
		System.out.println(some[0]);
		System.out.println(some[1]);
		MemberBean m = null;		
		List<MemberBean> mList = null;
		try {
			ResultSet rs = DatabaseFactory.createDataBase(
					Vendor.ORACLE,
					DBConstant.UID,
					DBConstant.PWD)
			.getConnection()
			.createStatement()
			.executeQuery(String.format(
					MemberQuery.LISTBYSOME.toString(),
					some[0], "%"+ some[1] +"%"));
			mList = new ArrayList<>();
			while(rs.next()) {
				m = new MemberBean();
				m = new MemberBean();
				m.setMemId(rs.getString("MEMID"));
				m.setTeamId(rs.getString("TEAMID"));
				m.setName(rs.getString("NAME"));
				m.setAge(rs.getString("AGE"));
				m.setRoll(rs.getString("ROLL"));
				mList.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				return mList;
	}*/
	@Override
	public List<MemberBean> selectMemberBySome(String[] some) {
		//template pattern
		System.out.println("< selectMemberBySome >");
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		map.put("column", some[0]);
		map.put("value", some[1]);
		map.put("table", Domain.MEMBER);
		q.play(map);
		for(Object s : q.getList()) {
			list.add((MemberBean) s);
		}
				return list;
	}
	@Override
	public MemberBean selectMemberByID(String id) {
		MemberBean mem = null;
		try {
		ResultSet rs = DatabaseFactory.createDataBase(
				Vendor.ORACLE, 
				DBConstant.UID,
				DBConstant.PWD)
		.getConnection()
		.createStatement()
		.executeQuery(String.format(
				MemberQuery.LISTBYONE.toString(), 
				id));				
		while(rs.next()) {
			mem = new MemberBean();
			mem.setMemId(rs.getString("MEMID"));
			mem.setName(rs.getString("NAME"));
			mem.setAge(rs.getString("AGE"));
			mem.setGender("TEMP");
			mem.setSsn(rs.getString("SSN"));
			mem.setTeamId(rs.getString("TEAMID"));
			mem.setRoll(rs.getString("ROLL"));
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(mem);
		return mem;
	}
	@Override
	public int countMember() {
		int count=0;
		try{
			ResultSet rs = DatabaseFactory.createDataBase(
					Vendor.ORACLE,
					DBConstant.UID,
					DBConstant.PWD)
			.getConnection()
			.createStatement()
			.executeQuery(MemberQuery.COUNT_MEMBER.toString());
			while(rs.next()) {
				count = rs.getInt("count"); 
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return count;
	}
	@Override
	public void updateMember(MemberBean member) {
		try {
			DatabaseFactory.createDataBase(
					Vendor.ORACLE,
					DBConstant.UID,
					DBConstant.PWD)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(
					MemberQuery.UPDATE_MEMBER.toString(),
					member.getPassword(),
					member.getMemId(),
					member.getPassword()
					));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteMember(MemberBean member) {
		System.out.println(String.format(String.format(
					MemberQuery.DELETE_MEMBER.toString(),
					member.getName())));
		try {
			DatabaseFactory.createDataBase(
					Vendor.ORACLE,
					DBConstant.UID,
					DBConstant.PWD)
			.getConnection()
			.createStatement()
			.executeQuery(String.format(
					MemberQuery.DELETE_MEMBER.toString(),
					member.getName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public String join(MemberBean member) {
		String result = "";
		try {	
			ResultSet rs = DatabaseFactory.createDataBase(
					Vendor.ORACLE,
					DBConstant.UID,
					DBConstant.PWD)
			.getConnection()
			.createStatement()
			.executeQuery(String.format(
					"SELECT MEMID MEMID "+
					"FROM MEMBER "+
					"WHERE MEMID LIKE '%s'"
					, member.getMemId()));
			if(rs.next()) {
				//아이디중복
				result ="아이디가 이미 있습니다.";
			}else {				
				stmt.execute(
						String.format(
						"INSERT INTO MEMBER "
						+ "(MEMID, NAME, SSN, PASSWORD, AGE) "
						+ "VALUES "
						+ "('%s','%s','%s','%s','%d')", 
						member.getMemId(),
						member.getName(),
						member.getSsn(),
						member.getPassword(),
						(119-Integer.parseInt(member.getSsn().substring(0, 2)))
						)
				);
				result = "등록 성공";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public MemberBean login(MemberBean member) {
		MemberBean mem = null;
		try {
			ResultSet rs = DatabaseFactory.createDataBase(
						Vendor.ORACLE,
						DBConstant.UID,
						DBConstant.PWD)
			.getConnection()
			.createStatement()
			.executeQuery
			(String.format(MemberQuery.LOGIN.toString(), 
					member.getMemId(), member.getPassword()));
			while(rs.next()) {
				mem = new MemberBean();
				System.out.println("INSIDE");
				/*mem.setSsn(rs.getString("SSN"));
				mem.setMemId(rs.getString("MEMID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setUpdatePassword("temp");*/
				mem.setMemId(rs.getString("MEMID"));
				mem.setPassword(rs.getString("PASSWORD"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mem;
	}
	
}