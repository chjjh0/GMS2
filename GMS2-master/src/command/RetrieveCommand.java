package command;

import javax.servlet.http.HttpServletRequest;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command{
	
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, 
				request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		System.out.println("< RetrieveCommand >");
		request.setAttribute("user", 
				MemberServiceImpl.getInstance()
				.findByID(request.getParameter("keyword")));
		System.out.println(request.getAttribute("uesr"));
	}
}