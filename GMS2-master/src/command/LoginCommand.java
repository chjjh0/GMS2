package command;

import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import service.MemberServiceImpl;

public class LoginCommand extends Command {
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(
				request.getServletPath().substring(1,
						request.getServletPath().indexOf("."))
				);
		setPage("retrieve");
		execute();
	}
	
	@Override
	public void execute() {
		super.execute();
		MemberBean member = new MemberBean();
		member.setMemberId(request.getParameter("userid"));
		member.setPass(request.getParameter("pass"));
		MemberBean mem = MemberServiceImpl.getInstance().login(member);
		if(mem != null) {
			request.setAttribute("match", "TRUE");
			request.getSession().setAttribute("user", //세션에 담기
					mem);
			
		}else {
			request.setAttribute("match", "FALSE");
		}
		
		
	}
}
