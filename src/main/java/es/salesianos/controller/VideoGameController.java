package es.salesianos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import es.salesianos.model.*;
import es.salesianos.service.VideoGameService;


@Controller
public class VideoGameController {

	private static Logger log = LogManager.getLogger(VideoGameController.class);

	@Autowired
	private VideoGameService service;

	@GetMapping("/addVideoGame")
	public ModelAndView insertVideoGame() {
		return new ModelAndView("AddVideoGame", "command", new VideoGame());
	}
	@PostMapping("/addVideoGame")
	public ModelAndView create(@ModelAttribute("VideoGame") VideoGame videogame) {
		log.debug("inserting VideoGame");
		service.insert(videogame);
		return new ModelAndView("AddVideoGame", "command", new VideoGame());
	}
	@GetMapping("/listVideoGame")
	public ModelAndView listVideogame() {
		log.debug("show list");
		ModelAndView modelAndView = new ModelAndView("ListVideoGame", "command", new VideoGame());
		modelAndView.addObject("listAllVideoGame", service.listAll());
		return modelAndView;
	}
	@PostMapping("/listVideoGame")
	public ModelAndView list() {
		log.debug("show list");
		ModelAndView modelAndView = new ModelAndView("ListVideoGame", "command", new VideoGame());
		modelAndView.addObject("listAllVideoGame", service.listAll());
		return modelAndView;
	}
	@PostMapping("/listVideoGameByCompany")
	public ModelAndView listByCompany(int companyId) {
		log.debug("show list");
		ModelAndView modelAndView = new ModelAndView("ListVideoGameByCompany", "command", new VideoGame());
		modelAndView.addObject("listAllVideoGame", service.listAllByCompany(companyId));
		return modelAndView;
	}
	@GetMapping("/listVideoGameReleaseDate")
	public ModelAndView listOrderReleaseDate() {
		log.debug("starting to order list");
		ModelAndView modelAndView = new ModelAndView("ListVideoGameReleaseDate", "command", new VideoGame());
		modelAndView.addObject("listAllVideoGame", service.OrderByReleaseDate());
		return modelAndView;
	}
	@PostMapping("/OrderByReleaseDate")
	public ModelAndView listOrderByReleaseDate() {
		log.debug("starting to order list");
		ModelAndView modelAndView = new ModelAndView("ListVideoGameReleaseDate", "command", new VideoGame());
		modelAndView.addObject("listAllVideoGame", service.OrderByReleaseDate());
		return modelAndView;
	}
	@GetMapping("/listVideoGameTitle")
	public ModelAndView listOrderByTitle() {
		log.debug("starting to order list");
		ModelAndView modelAndView = new ModelAndView("ListVideoGameTitle", "command", new VideoGame());
		modelAndView.addObject("listAllVideoGame", service.OrderByTitle());
		return modelAndView;
	}
	@PostMapping("/OrderByTitle")
	public ModelAndView listOrderTitle() {
		log.debug("starting to order list");
		ModelAndView modelAndView = new ModelAndView("ListVideoGameTitle", "command", new VideoGame());
		modelAndView.addObject("listAllVideoGame", service.OrderByTitle());
		return modelAndView;
	}
	@GetMapping("/deleteVG")
	public ModelAndView deleteVideogame(@ModelAttribute("VideoGame") String name) {
		log.debug("removing videogame");
		ModelAndView modelAndView = new ModelAndView("confirmationVideoGame", "command", new VideoGame());
		modelAndView.addObject("name", name);
		return modelAndView;
	}
	@PostMapping("/deleteVG")
	public ModelAndView delete(@ModelAttribute("VideoGame") String name) {
		log.debug("removing videogame");
		service.delete(name);
		ModelAndView modelAndView = new ModelAndView("ListVideoGame", "command", new VideoGame());
		modelAndView.addObject("listAllVideoGame", service.listAll());
		return modelAndView;
	}
	
}

