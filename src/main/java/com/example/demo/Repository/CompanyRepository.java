package com.example.demo.Repository;

import java.util.Collection;


import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import com.example.demo.Entity.Company;


public interface CompanyRepository extends Neo4jRepository < Company, Long > {
	/* afficher une comagnie dont l'id est*/
	@Query("match(n:Company )return n;")
	Collection<Company> getAllCompany(); /*creer une nouvelle compagnie avec ses propriétes*/
	 @Query("match (ca:Company{Company:{0}) return ca;")
	Company findByname_Company(String name_Company);//créer une nouvelle compagnie 
	 @Query("match(ca:Company{name_Company:{0},email_Company:{1}, Statut_Company:{2}}) return ca;")
	Company getCompanyById(Long id);
}




