package es.salesianos.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.salesianos.model.Company;
import es.salesianos.repository.*;

@Service
public class CompanyService implements es.salesianos.service.Service<Company> {

	private static Logger log = LogManager.getLogger(CompanyService.class);
	@Autowired
	private CompanyRepository repository;

	@Override
	public void insert(Company companyForm) {
		repository.insertCompany(companyForm);
	}

	@Override
	public List<Company> listAll() {
		return repository.searchAll();
	}

	@Override
	public void delete(String companyForm) {
		repository.delete(companyForm);
	}

	public CompanyRepository getRepository() {
		return repository;
	}

	public void setRepository(CompanyRepository repository) {
		this.repository = repository;
	}

}
