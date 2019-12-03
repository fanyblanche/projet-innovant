package com.example.demo.Entity;

import org.neo4j.ogm.annotation.GeneratedValue;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class User {
  
	;
	@Id @GeneratedValue private long id;
	private  String Username;
	private String Usersurname;
	private String Email_User;
	private String User_Password;
	private String Numtel_User;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(long id, String username, String usersurname, String email_User, String user_Password,
			String numtel_User) {
		super();
		this.id = id;
		this.Username = username;
		Usersurname = usersurname;
		Email_User = email_User;
		User_Password = user_Password;
		Numtel_User = numtel_User;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		this.Username = username;
	}
	public String getUsersurname() {
		return Usersurname;
	}
	public void setUsersurname(String usersurname) {
		Usersurname = usersurname;
	}
	public String getEmail_User() {
		return Email_User;
	}
	public void setEmail_User(String email_User) {
		Email_User = email_User;
	}
	public String getUser_Password() {
		return User_Password;
	}
	public void setUser_Password(String user_Password) {
		User_Password = user_Password;
	}
	public String getNumtel_User() {
		return Numtel_User;
	}
	public void setNumtel_User(String numtel_User) {
		Numtel_User = numtel_User;
	}
	public Object getActive() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setActive(Object active) {
		// TODO Auto-generated method stub
		
	}


}
     
     
     
     
     
     
     
     
     
     
     
     
     
      
     