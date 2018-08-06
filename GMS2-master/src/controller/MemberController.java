package controller;
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

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberControll 진입");
		Sentry.init(request);
		switch(Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE : 
			System.out.println(" <MOVE> 진입 ");
			try {
				Carrier.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case CREATE :
			System.out.println(" <CREATE> 진입 ");
			Carrier.forward(request, response);
			break;
		case LIST :
			System.out.println(" <LIST> 진입 ");
			MemberServiceImpl.getInstance().findList();
			Carrier.forward(request, response);
			break;
		case SEARCH :
			break;
		case RETRIEVE :
			break;
		case COUNT :
			Carrier.redirect(request, response, "");
			break;
		case UPDATE :
			break;
		case DELETE :
			break;
		case LOGIN :
			//System.out.println("<LOGIN> 진입");
			if(request.getAttribute("match").equals("TRUE")) {
				request.getSession()
				.setAttribute("user", 
						request.getAttribute("uesr"));
				Carrier.forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath()
						+"/member.do?action=move&page=userLoginForm");
			}
			break;
		default:
			break;
		}
	}
}