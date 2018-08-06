package command;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;

public class SearchCommand extends Command{
	public SearchCommand(HttpServletRequest request) {
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
		System.out.println("< SearchCommand >");
		String[] temp = {
				request.getParameter("option"),
				request.getParameter("word")};
		System.out.println(temp[0]);
		System.out.println(temp[1]);
		request.setAttribute("list", 
					MemberServiceImpl.getInstance()
					.findBySome(temp));
		/*request.setAttribute("listbyTeamId", 
				MemberServiceImpl.getInstance().
				findByName(request.getParameter("keyword")));*/
		//System.out.println(request.getAttribute("listbyTeamId"));
	}
}