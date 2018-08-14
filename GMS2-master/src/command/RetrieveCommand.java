package command;

import javax.servlet.http.HttpServletRequest;

import service.ImgServiceImpl;
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
		//pagename 에 movecommand와 달리
		//pagename을 담아야 하는데 아마 page를 page pagename으로 바꾼 후 작업해야하는 듯
		//pagename으로 바꾸는 지점이나 pagename을 찾으면 됨
		System.out.println("< RetrieveCommand_execute >");
		request.setAttribute("pagename", 
				request.getParameter("page"));
		request.setAttribute("user", 
				MemberServiceImpl
				.getInstance()
				.retrieve(
						request.getParameter("table")+"/"+
						request.getParameter("option")+"/"+
						request.getParameter("word")
						)
				);
		// String img = "";
		//String imgPath = "/upload/"+img;
		//TABLE에 파일명/확장자 등록, 프로필 갈아끼울 EL{img} 작업 중
		request.setAttribute("img", 
				"/upload/"+ImgServiceImpl.getInstance().retrieve(""));
		
		System.out.println(request.getAttribute("user"));
		super.execute();
	}
}


