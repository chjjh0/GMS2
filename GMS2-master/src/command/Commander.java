package command;

import javax.servlet.http.HttpServletRequest;
import enums.Action;

public class Commander {
	public static Command order(HttpServletRequest request) {
		Command cmd = null;
		switch(Action.valueOf(request.getParameter("action")
				.toUpperCase())) {
		case ADD : 
			Receiver.cmd = new AddCommand(request);
			break;
		case SEARCH: 
			System.out.println("< Commander_SEARCH >");
			cmd = new SearchCommand(request);
			break;
		case RETRIEVE:
			cmd = new RetrieveCommand(request);
			break;
		case COUNT : 
			cmd = new CountCommand(request);
			break;
		case MODIFY:
			cmd = new ModifyCommand(request);
			break;
		case REMOVE:
			cmd = new RemoveCommand(request);
			break;
		case MOVE:
			cmd = new MoveCommand(request);
			break;
		case LOGIN: 
			cmd = new LoginCommand(request);
			break;
		case FILEUPLOAD: 
			cmd = new FileCommand(request);
			break;
		default:
			break;
		}
		System.out.println("< Commander_return 직전 >");
		System.out.println(cmd.toString());
		return cmd;
	}

}
