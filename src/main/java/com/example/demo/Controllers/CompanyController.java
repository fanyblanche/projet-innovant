package com.example.demo.Controllers;


import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entity.Company;
import com.example.demo.Entity.User;
import com.example.demo.Service.CompanyService;

@RestController
@RequestMapping("/api/company")

public class CompanyController {
	private final static Logger LOG = (Logger) LoggerFactory.getLogger(CompanyController.class);
	
	private CompanyService  CompanyService ;  
	
	@Autowired
	public CompanyController(CompanyService CompanyService) {
		this.CompanyService= CompanyService;
	}
	//lister toutes les compagnies
	@RequestMapping(value="/listeCompany", method = RequestMethod.GET)
	public ResponseEntity<Collection<Company>> getAllCompany() {
		Collection<Company> Company =CompanyService.getAllCompany();
		LOG.info("liste des utilisateurs : " + Company.toString());
		return new ResponseEntity<Collection<Company>>(Company, HttpStatus.FOUND);
	}
	//rechercher les utilisateurs
	@RequestMapping(value="/nomComp", method= RequestMethod.GET)
	public ResponseEntity<Company>  findByname_Company(@RequestParam("name_Company") String name_Company) {
		Company company = CompanyService.findByname_Company(name_Company);
		LOG.debug("Utilisateur trouvé : " + company);
		return new ResponseEntity<Company>(company, HttpStatus.FOUND);
	}

}
