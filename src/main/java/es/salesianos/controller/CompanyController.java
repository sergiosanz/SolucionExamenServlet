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
import es.salesianos.service.CompanyService;

@Controller
public class CompanyController {

	private static Logger log = LogManager.getLogger(CompanyController.class);
	@Autowired
	private CompanyService service;

	@GetMapping("/listConsoleByCompany")
	public ModelAndView listConsoleByCompanyGet() {
		log.debug("show list");
		ModelAndView modelAndView = new ModelAndView("ListConsoleByCompany", "command", new Company());
		modelAndView.addObject("listAllCompany", service.listAll());
		return modelAndView;
	}

	@GetMapping("/listVideogamesByCompany")
	public ModelAndView listVideoGameByCompany() {
		log.debug("list by company");
		ModelAndView modelAndView = new ModelAndView("ListVideoGameByCompany", "command", new Company());
		modelAndView.addObject("listAllCompanyVG", service.listAll());
		return modelAndView;
	}

	@GetMapping("/addCompany")
	public ModelAndView loadCompany() {
		ModelAndView modelAndView = new ModelAndView("AddCompany", "command", new Company());
		return modelAndView
	}

	@PostMapping("/addCompany")
	public ModelAndView create(@ModelAttribute("company") Company company) {
		log.debug("inserting company");
		service.insert(company);
		ModelAndView modelAndView = new ModelAndView("AddCompany", "command", new Company());
		return modelAndView
	}

}
