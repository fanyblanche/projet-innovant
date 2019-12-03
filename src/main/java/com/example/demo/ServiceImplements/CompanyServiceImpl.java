package com.example.demo.ServiceImplements;

import java.util.Collection;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Company;
import com.example.demo.Repository.CompanyRepository;
import com.example.demo.Service.CompanyService;

@Service(value="CompanyService")
public class CompanyServiceImpl implements  CompanyService{

	@Autowired
	private CompanyRepository CompanyRepository ;
	@Override
	public Collection<Company> getAllCompany() {
		// TODO Auto-generated method stub
		return IteratorUtils.toList(CompanyRepository .findAll().iterator());
	}

	@Override
	public Company getCompanyById(Long id) {
		// TODO Auto-generated method stub
		return CompanyRepository.getCompanyById(id);
	}

	@Override
	public Company findByname_Company(String name_Company) {
		// TODO Auto-generated method stub
		return CompanyRepository.findByname_Company(name_Company);
	}

	@Override
	public Company saveOrUpdateCompany(Company Company) {
		// TODO Auto-generated method stub
		return CompanyRepository.save(Company);
	}

}
