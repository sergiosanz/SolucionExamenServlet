package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import es.salesianos.assembler.CompanyAssembler;
import es.salesianos.connection.*;
import es.salesianos.model.Company;
import es.salesianos.repository.*;

public class CompanyService {
	CompanyAssembler assembler = new CompanyAssembler();
	ConnectionManager manager = new H2Connection();
	private CompanyRepository repository = new CompanyRepository();

	public Company assembleUserFromRequest(HttpServletRequest req) {
		return CompanyAssembler.createCompanyFromRequest(req);
	}

	public void createNewCompanyFromRequest(Company companyForm) {
		repository.insertCompany(companyForm);
	}

	public List<Company> listAllCompany() {
		return repository.searchAll();
	}

	public CompanyRepository getRepository() {
		return repository;
	}

	public void setRepository(CompanyRepository repository) {
		this.repository = repository;
	}
}
