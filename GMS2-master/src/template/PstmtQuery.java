package template;

import java.sql.ResultSet;

import domain.MemberBean;
import enums.Domain;
import factory.DatabaseFactory;

public class PstmtQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("< initialize >");
		map.put("sql",String.format(
				" SELECT "
				+ ColumnFinder.find(Domain.MEMBER)
				+ " FROM %s "
				+ " WHERE %s "
				+ " LIKE ? ",
				map.get("table"),
				map.get("column"))
				);
		
	}

	@Override
	void startPlay() {
		System.out.println("< startPlay >");
		System.out.println(map.get("value"));
		try {
			pstmt = DatabaseFactory
					.createDataBase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
			pstmt.setString(1, //index 는 1부터
					"%"+map.get("value").toString()+"%");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			System.out.println("< endPlay >");
			ResultSet rs = pstmt.executeQuery();
			MemberBean member = null;
			while(rs.next()) {
				System.out.println("end inside");
				member = new MemberBean();
				member.setMemId(rs.getString("MEMID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setTeamId(rs.getString("TEAMID"));
				member.setName(rs.getString("NAME"));
				member.setGender(rs.getString("GENDER"));
				member.setAge(rs.getString("AGE"));
				member.setRoll(rs.getString("ROLL"));
				member.setSsn(rs.getString("SSN"));
				list.add(member);
				System.out.println(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}