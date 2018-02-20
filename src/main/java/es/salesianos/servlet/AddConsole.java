package es.salesianos.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.salesianos.model.*;
import es.salesianos.service.ConsoleService;

public class AddConsole extends HttpServlet{
	
	private ConsoleService service = new ConsoleService();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Console console = service.assembleUserFromRequest(req);
		service.createNewConsoleFromRequest(console);
		redirect(req,resp);
	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddConsole.jsp");
		dispatcher.forward(req, resp);
	}
	public ConsoleService getService() {
		return service;
	}

	public void setService(ConsoleService service) {
		this.service = service;
	}
}
