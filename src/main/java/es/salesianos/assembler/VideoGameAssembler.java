package es.salesianos.assembler;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.VideoGame;

public class VideoGameAssembler {
	public static VideoGame createVideoGameFromRequest(HttpServletRequest request) {
		VideoGame videogame= new VideoGame();
		videogame.setName(request.getParameter("name"));
		videogame.setAge(request.getParameter("age"));
		videogame.setReleaseDate(Date.valueOf(request.getParameter("releaseDate")));
		return videogame;
	}
}
