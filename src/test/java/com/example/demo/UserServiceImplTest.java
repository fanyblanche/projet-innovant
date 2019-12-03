package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserCompanyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {



	@Autowired
	private UserCompanyService userservice;

	@MockBean
	private  UserRepository userRepository ;

	User user = new User(0, "blanche", "ss", "ss.com",null , "65555");

	@Test
	public void testFindByUsername() throws Exception{
		//User user = new User(0, "sandy", "ss", "ss.com",null , "65555");
		User userMock = new User(0, "blanche", "ss", "ss.com",null , "65555");
		Mockito.when(userRepository.findByUsername((user.getUsername()))).thenReturn(userMock);
		User usertest = userservice.findByUsername(user.getUsername());
		assertNotNull(usertest);
		assertThat(usertest.getUsername(),is(user.getUsername()));
		/* String expected= "{id:O,Username:blanche,Usersurname:ss,Email_User:ss.com,Password_User:,Numtel_User:65555}";
			 JSONAssert.assertEquals(expected, userMock.getUsername(), false);*/


	}
}
