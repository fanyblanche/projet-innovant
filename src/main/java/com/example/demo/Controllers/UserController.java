package com.example.demo.Controllers;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserCompanyService;


@RestController
@CrossOrigin(origins = "http://localhost:8083", maxAge = 3600)
@RequestMapping("/api/user")

public class UserController {
	private final static Logger LOG = (Logger) LoggerFactory.getLogger(UserController.class);

	private UserCompanyService   userCompanyService ;  
	@Autowired
	public UserController(UserCompanyService UserCompanyService ) {
		this.userCompanyService= UserCompanyService ;
	}


	//lister les Utilisateurs
	@RequestMapping(value="/liste", method = RequestMethod.GET)
	public ResponseEntity<Collection<User>> getAllUsers() {
		Collection<User> users = userCompanyService.getAllUsers();
		LOG.info("liste des utilisateurs : " + users.toString());
		return new ResponseEntity<Collection<User>>(users, HttpStatus.FOUND);
	}


	//retrouver un utilisateur par son nom d'utilisateur 
	@RequestMapping(value="/nom", method= RequestMethod.GET)
	public ResponseEntity<User> findUserByUsername(@RequestParam("Username") String Username) {
		User user = userCompanyService.findByUsername(Username);
		LOG.debug("Utilisateur trouvé : " + user);
		return new ResponseEntity<User>(user, HttpStatus.FOUND);
	}

	//enregistrer un utilisateur 
	@RequestMapping(value = "/save",method =RequestMethod.POST)
	public ResponseEntity<User> saveorUpdateUser(User user) throws Exception {
		User userExist =  userCompanyService.findByEmail(user.getEmail_User());
		LOG.debug("Utilisateur trouvé : " + user);//should be corrected to save 
		if (userExist !=null) {
			LOG.debug("l'utilisateur avec l'email" +user.getEmail_User()+ "existe déjà");
			throw new Exception("error:Duplicate Email");
		}
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	//créer un nouvel utilisateur ou mettre a jour les données d'un utilisateur  déja existant
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id,User user) {

		User userToUpdate = userCompanyService.getUserByID(id);
		if (userToUpdate == null) {
			LOG.debug("L'utilisateur avec l'identifiant " + id + " n'existe pas");
			return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
		} 

		LOG.info("UPDATE User: "+userToUpdate.getUsername().toString());
		userToUpdate.setUsername(user.getUsername());
		userToUpdate.setUser_Password(user.getUser_Password());
		userToUpdate.setActive(user.getActive());
		User userUpdated = userCompanyService.saveorUpdateUser(userToUpdate);
		return new ResponseEntity<User>(userUpdated, HttpStatus.OK);
	}


}


