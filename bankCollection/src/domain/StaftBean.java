package domain;

public class StaftBean extends MemberBean{
	private String accessNum;

	public String getAccessNum() {
		return accessNum;
	}
	public void setAccessNum(String accessNum) {
		this.accessNum = accessNum;
	}
	@Override
	public String toString() {
		return "회원정보 [아이디:" + uid
				+ " 비번:" + uPasswd
				+ " 이름:" + name 
				+ " 주민번호:" + ssn
				+ " 접근번호:" + accessNum
				+ " 이메일:" + email
				+ " 주소:" + addr
				+ " 전화번호:" + phone
				+ " ]";
	}
}
