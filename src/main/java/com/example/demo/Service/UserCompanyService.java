package com.example.demo.Service;

import java.util.Collection;
import com.example.demo.Entity.User;

public interface UserCompanyService {
	Collection<User> getAllUsers();

	User getUserByID(long id);
	User findByUsername(String Username);
	User findByEmail(String Email_User);
	User saveorUpdateUser(User user);
	

}
