package enums;

public enum MemberQuery {
/* MEMID, TEAMID, NAME, AGE, ROLL, PASSWORD, SSN */
	LOGIN, INSERT_MEMBER, EXIST_ID,
	COUNT_MEMBER, UPDATE_MEMBER, DELETE_MEMBER,
	LIST, LISTBYONE, LISTBYSOME;
	@Override
	public String toString() {
		String query="";
		switch(this) {
		case LOGIN:
			query = " SELECT MEMID, "
					+" PASSWORD "
					+" FROM MEMBER "
					+" WHERE MEMID LIKE '%s' "
					+" AND PASSWORD LIKE '%s' ";
			break;
		case INSERT_MEMBER:
			//memId, teamId, name, age, roll, ssn, password
			query = " INSERT INTO MEMBER "
					+ " (MEMID, "
					+ " TEAMID, " 
					+ " NAME, "
					+ " AGE, "
					+ " ROLL, " 
					+ " SSN, " 
					+ " PASSWORD,"
					+ "	GENDER) "
					+ " VALUES "
					+ " ('%s', "	//MEMID
					+ " '%s', "		//TEAMID
					+ " '%s', "		//NAME
					+ " 20, "
					+ " '%s', "		//ROLL
					+ " '%s', "		//SSN
					+ " '%s', " 	//PASSWORD
					+ " 'temp') ";	//GENDER	
			break;
		case DELETE_MEMBER:
			query = " DELETE MEMBER "
					+ " WHERE NAME LIKE '%s' ";
			break;
		case EXIST_ID : 
			query = " SELECT MEMID "
					+ "FROM MEMBER "
					+ "WHERE MEMID LIKE '%s'";
			break;
		case COUNT_MEMBER :
			query = " SELECT COUNT(*) AS count FROM MEMBER ";
			break;
		case UPDATE_MEMBER :
			query = " UPDATE MEMBER SET PASSWORD = '%s' " 
					+ " WHERE MEMID LIKE '%s' "
					+ " AND PASSWORD <> '%s' ";
			break;
		case LIST :
			//query = " SELECT * FROM MEMBER ";
			query = " SELECT B.* "
					+ " FROM "  
					+ " (SELECT ROWNUM \"SEQ\", A.* " 
					+ " FROM (SELECT * FROM MEMBER) A) B "    
					+ " WHERE B.SEQ BETWEEN %s AND %s ";        ;
			break;
		case LISTBYSOME :
			query = " SELECT * FROM MEMBER "
					+ " WHERE "	+ " %s "
					+ " LIKE '%s' ";
			break;
		case LISTBYONE :
			query = " SELECT * FROM MEMBER "
					+ " WHERE MEMID LIKE '%s' ";
			break;
		}
		return query;
	} 
			
}