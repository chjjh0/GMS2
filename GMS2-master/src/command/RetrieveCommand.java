package command;

import javax.servlet.http.HttpServletRequest;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command{
	
	public RetrieveCommand(HttpServletRequest request) {
		System.out.println("=");
		System.out.println(" < RetrieveCommand > ");
		setRequest(request);
		setDomain(request.getServletPath().substring(1, 
				request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		request.setAttribute("user", 
				MemberServiceImpl
				.getInstance()
				.retrieve(
						request.getParameter("table")+"/"+
						request.getParameter("option")+"/"+
						request.getParameter("word")
						)
				);
		System.out.println("< RetrieveCommand >");
		System.out.println(request.getAttribute("user"));
		super.execute();
	}
}

