package com.example.demo.Service;

import java.util.Collection;
import com.example.demo.Entity.Company;

public interface CompanyService {

	 Collection<Company> getAllCompany();
	    
	   Company getCompanyById(Long id);
	    
	   Company findByname_Company(String name_Company);
	    
	   Company saveOrUpdateCompany(Company Company); 
	
	
}
