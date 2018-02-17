package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.salesianos.model.*;
import es.salesianos.service.VideoGameService;;


public class AddVideoGames extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private VideoGameService service = new VideoGameService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VideoGame videogame= service.assembleUserFromRequest(req);
		service.createNewVideoGameFromRequest(videogame);
		redirect(req,resp);
	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddVideogame.jsp");
		dispatcher.forward(req, resp);
	}
	public VideoGameService getService() {
		return service;
	}
	public void setService(VideoGameService service) {
		this.service = service;
	}
	
}
