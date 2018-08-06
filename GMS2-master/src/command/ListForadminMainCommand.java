package command;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;

public class ListForadminMainCommand extends Command{
	public ListForadminMainCommand(HttpServletRequest request) {
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
		System.out.println("< ListCommand >");
		System.out.println(getView());
		Command count = new CountCommand(request);
		request.setAttribute("listForadminMain", 
				MemberServiceImpl.getInstance().findList());
		//System.out.println(request.getAttribute("list"));
	}
}