package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class CreateCommand extends Command{
	/*//18/07/30 수정중
	private static Command instance = new CreateCommand();
	public static Command getInstance() {return instance;}
	public CreateCommand(String domain, String action, String page) {
*/	
	public CreateCommand(HttpServletRequest request) {
	setRequest(request);
	setDomain(request.getServletPath()
			.substring(1, request.getServletPath().indexOf(".")));
	setAction(request.getParameter("action"));
	setPage(request.getParameter("page"));
	execute();
	}
	
	@Override
	public void execute() {
		switch(Domain.valueOf(getDomain().toUpperCase())) {
		case MEMBER :
			System.out.println("< CreateCommand >");
			MemberBean member = new MemberBean();
			member.setMemId(request.getParameter("userid"));
			member.setTeamId(request.getParameter("teamid"));
			member.setName(request.getParameter("name"));
			member.setAge(request.getParameter("age"));
			member.setRoll(request.getParameter("roll"));
			member.setSsn(request.getParameter("ssn"));
			member.setPassword(request.getParameter("password"));
			member.setGender(request.getParameter("gender"));
			MemberServiceImpl.getInstance().createMember(member);
			//member.setSubject(ParamMap.getValues(request, "subject"));
			System.out.println("회원가입 성공");
			break;
		default:
			break;
		}
		super.execute();
	}
}