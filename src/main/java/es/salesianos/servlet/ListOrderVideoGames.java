package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.salesianos.model.*;
import es.salesianos.service.VideoGameService;

public class ListOrderVideoGames extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private VideoGameService service = new VideoGameService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<VideoGame> listAllVideoGames = service.OrderByReleaseDate();
		req.getSession().setAttribute("listAllVideoGames", listAllVideoGames);
		redirect(req,resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListVideoGame.jsp");
		dispatcher.forward(req,resp);
	}
}

