package command;

import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import service.MemberServiceImpl;

public class LoginCommand extends Command {
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath()
				.substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		super.execute();
		System.out.println("< LoginCommand >");
		MemberBean member = new MemberBean();
		member.setMemId(request.getParameter("userid"));
		member.setPassword(request.getParameter("password"));
		if(MemberServiceImpl.getInstance().login(member)) {
			System.out.println("로그인 성공");
			request.setAttribute("match", "TRUE");
			request.setAttribute("user", 
					MemberServiceImpl.getInstance().findByID(
						request.getParameter("userid")));
			System.out.println(request.getAttribute("user").toString());
		}else {
			System.out.println("로그인 실패");
			request.setAttribute("match", "FALSE");
		}
	}
}