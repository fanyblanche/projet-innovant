package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.runner.RunWith;
import com.example.demo.Controllers.UserController;
import com.example.demo.Entity.User;
import com.example.demo.Service.CompanyService;
import com.example.demo.Service.UserCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)

public class UsercontrollersTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserCompanyService usercompanyservice;
	@MockBean
	private CompanyService companyservice;

	User mockUser = new User(0, "blanche", "ss", "ss.com",null , "65555");// create an mock objet that coul be call to test method



	@Test // test find User by Username(get request)
	public void TestService () throws Exception{
		Mockito.when( usercompanyservice.findByUsername(Mockito.anyString())).thenReturn(mockUser);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/user/nom")
				.param("Username", "blanche")//insert parameter in Uri request
				.accept(MediaType.APPLICATION_JSON);


		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());
		//response will be waiting 

		String expected = "{\"id\":0,\"email_User\":\"ss.com\",\"username\":\"blanche\",\"user_Password\":null,\"active\":null,\"usersurname\":\"ss\",\"numtel_User\":\"65555\"}";
		//assure that result=expected 
// 		assertThat(expected).isEqualTo(result.getResponse().getContentAsString());// comparaison between result and expected
		verify(usercompanyservice).findByUsername(any(String.class));

	}

	@Test// implement collection get request
	public void testFindAll() throws Exception{
		MvcResult result = mockMvc.perform(get("/api/user/liste").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isFound())
				.andReturn();
		assertEquals("incorrect",HttpStatus.FOUND.value(),result.getResponse().getStatus());
		verify(usercompanyservice).getAllUsers();
	}
	@Test
	public void save() throws Exception{
		Mockito.when(usercompanyservice.findByEmail(Mockito.anyString())).thenReturn(mockUser);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/user/save")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content("<user><Username></Username><password></password><active>1</active></user>"))
		.andExpect(status().isCreated());

	}


}
