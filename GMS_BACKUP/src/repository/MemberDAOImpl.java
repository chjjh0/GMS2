package repository;

import java.sql.*;
import java.util.*;
import domain.*;
import enums.*;
import factory.*;
import pool.DBConstant;

public class MemberDAOImpl implements MemberDAO{
	private static MemberDAO instance = new MemberDAOImpl();

	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	@Override
	public MemberBean insertMember(MemberBean member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberBean> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberBean> readSome(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean readOne(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMember(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public MemberBean login(MemberBean member) {
		MemberBean mem = null;
		try {
			ResultSet rs = DataBaseFactory.createDataBase(
					Vendor.ORACLE,
					DBConstant.USER_NAME,
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement().executeQuery(String.format(
							"SELECT MEM_ID MEMID, "
									+" TEAM_ID TEAMID, "
									+" NAME, "
									+" SSN, "
									+" ROLL, "
									+" PASSWORD "
									+" FROM MEMBER "
									+" WHERE MEM_ID LIKE '%s' "
									+" AND PASSWORD LIKE '%s' "
							,member.getMemberId(),member.getPass()));			
			while(rs.next()) {
				mem = new MemberBean();
				mem.setMemberId(rs.getString("MEMID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setSsn(rs.getString("SSN"));
				mem.setRoll(rs.getString("ROLL"));
			}				
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return mem;
	}
	@Override
	public String join(MemberBean member) {
		String result = "";
		if(!existID(member.getMemberId())) {
			try {
				DataBaseFactory.createDataBase(
						Vendor.ORACLE,
						DBConstant.USER_NAME,
						DBConstant.PASSWORD)
						.getConnection()
						.createStatement()
						.executeUpdate(
								String.format(
								"INSERT INTO MEMBER "
										+ "(MEM_ID, NAME, SSN, PASSWORD, AGE) "
										+ "VALUES "
										+ "('%s','%s','%s','%s','%d')", 
										member.getMemberId(),
										member.getName(),
										member.getSsn(),
										member.getPass(),
										(119-Integer.parseInt(member.getSsn().substring(0, 2)))
										));
			} catch (Exception e) {
				e.printStackTrace();
			}
			result = "등록성공";
		}else{
			result = "아이디가 이미 있습니다.";
		}
		
		return result;
		
	}
	@Override
	public boolean existID(String id) {
		ResultSet rs = null;
		boolean flag = false;
		try {
			rs = DataBaseFactory.createDataBase(
					Vendor.ORACLE, 
					DBConstant.USER_NAME, 
					DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeQuery(String.format(
					MemberQuery.EXIST_ID.toString(),
					id
					)
			);
			flag = (rs.next());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("exitID"+flag);
		return flag;
	}

}








