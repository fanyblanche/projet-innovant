package com.example.demo.Entity;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


@NodeEntity
public class Company {
//entite
	@Id @GeneratedValue private long id;
	private String name_Company;
	private String Statut_Company;
	private String Email_Company;
	private String Address_Company;
	//constructeur 
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	// relation un user pour une compagnie et une compagnie a plusieurs users
	  @Relationship(type="travaille",direction=Relationship.INCOMING)
	   Set<User> list_User_Company;

	public Company(long id, String name_Company, String statut_Company, String email_Company, String address_Company,
			Set<User> list_User_Company) {
		super();
		this.id = id;
		this.name_Company = name_Company;
		Statut_Company = statut_Company;
		Email_Company = email_Company;
		Address_Company = address_Company;
		this.list_User_Company = list_User_Company;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName_Company() {
		return name_Company;
	}

	public void setName_Company(String name_Company) {
		this.name_Company = name_Company;
	}

	public String getStatut_Company() {
		return Statut_Company;
	}

	public void setStatut_Company(String statut_Company) {
		Statut_Company = statut_Company;
	}

	public String getEmail_Company() {
		return Email_Company;
	}

	public void setEmail_Company(String email_Company) {
		Email_Company = email_Company;
	}

	public String getAddress_Company() {
		return Address_Company;
	}

	public void setAddress_Company(String address_Company) {
		Address_Company = address_Company;
	}

	public Set<User> getList_User_Company() {
		return list_User_Company;
	}

	public void setList_User_Company(Set<User> list_User_Company) {
		this.list_User_Company = list_User_Company;
	}
	
//methode d'ajout d'utilisateur a une compagnie
	public void addUser(User userCompany) {
	       if (this.list_User_Company == null) {
	           this.list_User_Company = new HashSet<>();
	       }
	       this.list_User_Company.add(userCompany);
	   }

	public Object getActive() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setActive(Object active) {
		// TODO Auto-generated method stub
		
	}
		
	
	
}
