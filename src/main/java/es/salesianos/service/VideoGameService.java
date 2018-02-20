package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import es.salesianos.assembler.VideoGameAssembler;
import es.salesianos.connection.*;
import es.salesianos.model.VideoGame;
import es.salesianos.repository.*;

public class VideoGameService {
	VideoGameAssembler assembler = new VideoGameAssembler();

	private VideoGameRepository repository = new VideoGameRepository();
	ConnectionManager manager = new H2Connection();

	public VideoGame assembleUserFromRequest(HttpServletRequest req) {
		return VideoGameAssembler.createVideoGameFromRequest(req);
	}

	public void createNewVideoGameFromRequest(VideoGame VideoGameForm) {
		repository.insertVideoGame(VideoGameForm);
	}

	public List<VideoGame> listAllByCompany(int idCompany) {
		return repository.selectByCompany(idCompany);
	}

	public List<VideoGame> listAllVideogame() {
		return repository.searchAll();
	}

	public List<VideoGame> OrderByTitle() {
		return repository.orderByTitle();
	}

	public List<VideoGame> OrderByReleaseDate() {
		return repository.orderByReleaseDate();
	}

	public void deleteVideoGame(VideoGame videogame) {
		repository.delete(videogame);
	}

	public VideoGameRepository getRepository() {
		return repository;
	}

	public void setRepository(VideoGameRepository repository) {
		this.repository = repository;
	}
}
