package template;

import domain.MemberBean;
import enums.MemberQuery;

public class UpdateQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("< UpdateQuery >");
		map.put("sql", 
				String.format(
					MemberQuery.UPDATE.toString(),
					"PASSWORD",
					"TEAM_ID",
					"ROLL")
				);
		/*"UPDATE MEMBER "
		  + "SET %s = ?, "
		  + "SET %s = ?, "
		  + "SET %s = ? "
		  + "WHERE MEM_ID LIKE ? ";*/
		
	}

	@Override
	void startPlay() {
		try {
			pstmt.setString(1, ((MemberBean)map.get("member")).getPass());
			pstmt.setString(2, ((MemberBean)map.get("member")).getTeamId());
			pstmt.setString(3, ((MemberBean)map.get("member")).getRoll());
			pstmt.setString(4, ((MemberBean)map.get("member")).getMemberId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
