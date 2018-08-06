package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;

public class ListCommand extends Command{
	private static String beginRow = "1", endRow = "1";
	public ListCommand(HttpServletRequest request) {
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
		Map<String, Object> param = new HashMap<>();
		int count = 0, beginPage = 1, endPage=0;
		count = MemberServiceImpl.getInstance().countMember();
		System.out.println("count "+count/5);
		if(count/5<6) {
			if(count%5==0) {
				endPage=(count/5);
			} else {
				endPage=(count/5)+1;
			}
		} else {
			endPage=5;
		}
		beginRow = this.endRow;
		endRow = String.valueOf(
				Integer.parseInt(this.endRow)+4);
		System.out.println("begin row "+beginRow);
		System.out.println("end row "+endRow);
		param.put("beginRow", beginRow);
		param.put("endRow", endRow);
		request.setAttribute("count", count);
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", 
				MemberServiceImpl.getInstance().getList(param));
		//System.out.println(request.getAttribute("list"));
	}
}