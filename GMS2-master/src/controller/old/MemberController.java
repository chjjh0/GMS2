/*package controller.old;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.*;
import domain.MemberBean;
import enums.*;
import service.*;

//@WebServlet(urlPatterns = {"/member/join/joinForm.do","/member/login/userLoginForm.do"})
@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public MemberController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		MemberBean member = null;
		List<MemberBean> list = null;
		
		System.out.println("MemberControll 진입");
		Sentry.init(request);
		switch(Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE : 
			System.out.println(" <MOVE> 진입 ");
			try {
				Carrier.send(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case CREATE :
			System.out.println(" <CREATE> 진입 ");
			member = new MemberBean();
			member.setUserid(request.getParameter("userid"));
			member.setPassword(request.getParameter("password"));
			member.setName(request.getParameter("name"));
			member.setSsn(request.getParameter("ssn"));
			member.setTeamId(request.getParameter("teamid"));
			member.setRoll(request.getParameter("roll"));
			MemberServiceImpl.getInstance().createMember(member);
			response.sendRedirect(request.getContextPath()
					+"/member.do?action=move&page=userLoginForm");
			break;
		case LIST :
			System.out.println(" <LIST> 진입 ");
			list = new ArrayList<>();
			list = MemberServiceImpl.getInstance().findList();
			System.out.println(list.size());
			break;
		case SEARCH :
			list = new ArrayList<>();
			list = MemberServiceImpl.getInstance().findByID(request.getParameter("userid"));
			System.out.println(list.size());
			response.sendRedirect(request.getContextPath()
					+"/member.do?action=move&page=search_team_result");
			break;
		case RETRIEVE :
			String name = MemberServiceImpl.getInstance().findByID(request.getParameter("user_id")).getName();
			System.out.println(name);
			response.sendRedirect(request.getContextPath()
					+"/member.do?action=move&page=search_member_result");
			break;
		case COUNT :
			MemberServiceImpl.getInstance().countMember();
			break;
		case UPDATE :
			System.out.println("<UPDATE> 진입");
			member = new MemberBean();
			member.setUserid(request.getParameter("userid"));
			member.setUpdatePassword(request.getParameter("newpassword"));
			MemberServiceImpl.getInstance().updateMember(member);
			response.sendRedirect(request.getContextPath()
					+"/member.do?action=move&page=mypage");
			break;
		case DELETE :
			member = new MemberBean();
			member.setMemId(request.getParameter("userid"));
			member.setPassword(request.getParameter("password"));
			//MemberServiceImpl.getInstance().deleteMember(member);
			response.sendRedirect(request.getContextPath());
			break;
		case LOGIN :
			System.out.println("<LOGIN> 진입");
			if(request.getAttribute("match").equals("TRUE")) {
				request.getSession()
				.setAttribute("user", 
						request.getAttribute("uesr"));
				response.sendRedirect(request.getContextPath()
					+"/member.do?action=move&page=mypage"); 
			} else {
				response.sendRedirect(request.getContextPath()
						+"/member.do?action=move&page=userLoginForm");
			}
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}*/