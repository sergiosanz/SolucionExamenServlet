package es.salesianos.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.salesianos.model.VideoGame;
import es.salesianos.repository.*;

@Service
public class VideoGameService implements es.salesianos.service.Service<VideoGame>{
	private static Logger log = LogManager.getLogger(ConsoleService.class);
	@Autowired
	private VideoGameRepository repository;
	@Override
	public void insert(VideoGame VideoGameForm) {
		repository.insertVideoGame(VideoGameForm);
	}
	@Override
	public List<VideoGame> listAll() {
		return repository.searchAll();
	}
	@Override
	public void delete(String videogame) {
		repository.delete(videogame);
	}
	
	public List<VideoGame> listAllByCompany(int idCompany){
		return repository.selectByCompany(idCompany);
	}
	public List<VideoGame> OrderByTitle() {
		return repository.orderByTitle();
	}
	public List<VideoGame> OrderByReleaseDate() {
		return repository.orderByReleaseDate();
	}
		
	public VideoGameRepository getRepository() {
		return repository;
	}
	public void setRepository(VideoGameRepository repository) {
		this.repository = repository;
	}

}
