package es.salesianos.assembler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Company;

public class CompanyAssembler {

	public Company createCompanyFromRequest(HttpServletRequest req) {
		Company company = new Company();
		company.setName(req.getParameter("name"));
		String cDate = req.getParameter("creationDate");
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		String strFecha = cDate;
		Date fecha = null;
		try {
		fecha = formatoDelTexto.parse(strFecha);
		} catch (ParseException ex) {
		ex.printStackTrace();
		}
		company.setCreationdate(fecha);
		return company;
	}

}
