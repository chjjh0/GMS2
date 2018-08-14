package template;


import java.sql.ResultSet;
import domain.MemberBean;
import enums.MemberQuery;
import factory.DataBaseFactory;

public class SearchQuery extends QueryTemplate{

	@Override
	void initialize() {
		//sql문 setting
		System.out.println(">");
		System.out.println("< SearchQuery_initialize() >");
		System.out.println("map.containsKey: "+!map.containsKey("column"));
		map.put("sql", 
				(!map.containsKey("column"))?
					String.format(
							MemberQuery.LIST.toString(), 
							((String)map.get("domain")))
					:
					String.format(
							MemberQuery.SEARCH.toString(),
							((String)map.get("domain")),
							((String)map.get("column")).toUpperCase())
		);
	}

	@Override
	void startPlay() {
		//setting 된 sql문에 pstmt.setString으로 beginRow, endRow를 주는 용도 
		try {
			int j = 1;
			System.out.println(">");
			System.out.println("< SearchQuery_startPlay() >");
			System.out.println("map.containsKey: "+map.containsKey("column"));
			if(map.containsKey("column")) {
				pstmt.setString(j, 
					"%"+((String)map.get("value"))+"%");
			}
			pstmt.setString(j++, (String)map.get("beginRow"));
			pstmt.setString(j, (String)map.get("endRow"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		//startPlay()까지 완성된 sql문을 DB에 던진고  담는 역할
		MemberBean member = null;
		try {
			System.out.println(">");
			System.out.println("< SearchQuery_endPlay() >");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new MemberBean();
				member.setMemberId(rs.getString("MEM_ID"));
				member.setPass(rs.getString("PASSWORD"));
				member.setTeamId(rs.getString("TEAM_ID"));
				member.setName(rs.getString("NAME"));
				member.setGender(rs.getString("GENDER"));
				member.setAge(rs.getString("AGE"));
				member.setRoll(rs.getString("ROLL"));
				member.setSsn(rs.getString("SSN"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
