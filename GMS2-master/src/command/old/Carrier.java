/*package command.old;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Carrier {
	public static void send(HttpServletRequest request,
		HttpServletResponse response) {
		System.out.println("Carrier 진입");
		System.out.println(Sentry.cmd.getView());
		try {
			request
			.getRequestDispatcher(Sentry.cmd.getView())
			.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {
	public static void send(HttpServletRequest request,
			HttpServletResponse response) 
			throws Exception {
	System.out.println(Sentry.cmd.getView());
	request
	.getRequestDispatcher(Sentry.cmd.getView())
	.forward(request, response);
	}
}
*/