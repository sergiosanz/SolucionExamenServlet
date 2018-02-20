package es.salesianos.assembler;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.Company;

public class CompanyAssembler {
	public static Company createCompanyFromRequest(HttpServletRequest request) {
		Company company = new Company();
		company.setName(request.getParameter("name"));
		company.setCreationDate((Date.valueOf(request.getParameter("creationDate"))));
		return company;
	}
}
