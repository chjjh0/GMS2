package domain;

public class UserBean extends MemberBean{
	private String creditRate;

	public String getCreditRating() {
		return creditRate;
	}
	public void setCreditRating(String creditRating) {
		this.creditRate = creditRating;
	}
	@Override
	public String toString() {
		return "회원정보 [아이디:" + uid
				+ " 비번:" + uPasswd
				+ " 이름:" + name 
				+ " 주민번호:" + ssn
				+ " 신용도:" + creditRate
				+ " 이메일:" + email
				+ " 주소:" + addr
				+ " 전화번호:" + phone
				+ " ]";
	}

}
