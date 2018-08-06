package enums;

public enum MemberQuery {
	LOGIN,INSERT_MEMBER,EXIST_ID,COUNT_MEMBER;
	
	@Override
	public String toString() {	
		String query = "";
		switch(this) {
		case LOGIN : 
			query = "SELECT MEM_ID MEMID, "
					+" TEAM_ID TEAMID, "
					+" NAME, "
					+" SSN, "
					+" ROLL, "
					+" PASSWORD "
					+" FROM MEMBER "
					+" WHERE MEM_ID LIKE '%s' "
					+" AND PASSWORD LIKE '%s' ";
			break;
		case INSERT_MEMBER : 
			query = "INSERT INTO MEMBER "
					+ "(MEM_ID, NAME, SSN, PASSWORD, AGE) "
					+ "VALUES "
					+ "('%s','%s','%s','%s','%d')";
			break;
		case EXIST_ID : 
			query = "SELECT MEM_ID "
					+ "FROM MEMBER "
					+ "WHERE MEM_ID LIKE '%s'";
			break;
		case COUNT_MEMBER :
			query = " SELECT COUNT(*) AS count FROM MEMBER ";
			break;
			
		}
		return query;
	}
	
}
