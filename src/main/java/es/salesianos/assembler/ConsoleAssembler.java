package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Console;

public class ConsoleAssembler {
	public static Console createConsoleFromRequest(HttpServletRequest request) {
		Console console = new Console();
		console.setName(request.getParameter("name"));
		console.setCompanyId(Integer.parseInt(request.getParameter("companyId")));
		return console;
	}
}
