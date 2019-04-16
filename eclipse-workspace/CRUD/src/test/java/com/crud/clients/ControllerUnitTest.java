package com.crud.clients;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.crud.clients.domain.Client;

@RunWith(Suite.class)
@SuiteClasses({ CrudApplicationTests.class })
public class ControllerUnitTest {
	
	@MockBean
//	CrudServiceImpl crudserviceimpl;
	
	Client client = new Client();
	
	@Test
	public void shouldReturnAClient() {
		
		//Arrange
		//Act
		//Assert
	}
}
