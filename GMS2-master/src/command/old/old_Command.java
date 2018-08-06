/*package command.old;

import javax.servlet.http.HttpServletRequest;

import command.Order;

public class old_Command implements Order{
	protected HttpServletRequest request;
	//protected HttpServletResponse response;
	protected String action,domain,page,view;
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void execute() {
		this.view = "/WEB-INF/view/" + domain + "/" + page +".jsp";
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}
}*/