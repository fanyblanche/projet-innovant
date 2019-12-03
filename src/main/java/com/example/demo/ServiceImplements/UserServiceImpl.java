package com.example.demo.ServiceImplements;

import java.util.Collection;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserCompanyService;

@Service(value="UserService")
public class UserServiceImpl implements UserCompanyService {
	@Autowired
	private UserRepository UserRepository;

	@Override
	public Collection<User> getAllUsers() {
		// TODO Auto-generated method stub
		return IteratorUtils.toList(UserRepository.findAll().iterator());
	}

	@Override
	public User getUserByID(long id) {
		// TODO Auto-generated method stub
		return UserRepository.getUserByid( id);
	}

	@Override
	public User findByUsername(String Username) {
		// TODO Auto-generated method stub
		return UserRepository.findByUsername(Username);
	}

	@Override
	public User findByEmail(String Email_User) {
		// TODO Auto-generated method stub
		return UserRepository.findByEmail(Email_User);
	}

	@Override
	@Transactional(readOnly=false)
	public User saveorUpdateUser(User user) {
		// TODO Auto-generated method stub
		return UserRepository.save(user);
	}

	


}
