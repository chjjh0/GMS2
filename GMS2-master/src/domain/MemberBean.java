package domain;

import lombok.Data;

@Data
public class MemberBean {
	private String memId, teamId, name, age, roll, ssn, password, gender;

	@Override
	public String toString() {
		return "MemberBean [memId=" + memId + ", teamId=" + teamId + ", name=" + name + ", age=" + age + ", roll="
				+ roll + ", ssn=" + ssn + ", password=" + password + ", gender=" + gender + "]";
	}
	
}