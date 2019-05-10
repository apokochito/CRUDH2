package com.crud.clients;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crud.clients.domain.Client;
import com.crud.clients.entity.ClientEntity;
import com.crud.clients.mapper.OrikaMapper;
import com.crud.clients.repository.CrudRepository;
import com.crud.clients.service.CrudServiceImpl;

import ma.glasnost.orika.MapperFacade;

@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceUnitTest {
	//Back my test
	
	@Mock
	CrudRepository repo;
	
	@Mock
	MapperFacade facade = new OrikaMapper();
	
	@InjectMocks
	CrudServiceImpl service;
	
	private ClientEntity clientEntity = new ClientEntity();
	private List<Client> response = new ArrayList<Client>();
	private Client clientDomain = new Client();
	long id=1;

	@Test
	public void getClients() {
		when(repo.getClients()).thenReturn(Collections.singletonList(clientEntity));
		assertThat(response).asList();
		when(facade.map(clientEntity, Client.class)).thenReturn(clientDomain);
		assertNotNull(service.getClients());
	}
	
	@Test
	public void getByIdClient() {
		assertNotNull(clientEntity);
		assertNotNull(clientDomain);
		when(repo.getById(id)).thenReturn(clientEntity);
		when(facade.map(clientEntity, Client.class)).thenReturn(clientDomain);
		assertNotNull(service.getById(id));
	}
	
	@Test
	public void createClient() {
		assertNotNull(clientEntity);
		when(facade.map(clientDomain, ClientEntity.class)).thenReturn(clientEntity);
		doNothing().when(repo).createClient(clientEntity);
		//Assert
		service.createClient(clientDomain);
	}
	
	@Test
	public void deleteClient() {
		doNothing().when(repo).deleteById(id);
		//Assert
		service.deleteById(id);
	}
	
	@Test
	public void updateClient() {
		assertNotNull(clientEntity);
		when(facade.map(clientDomain, ClientEntity.class)).thenReturn(clientEntity);
		doNothing().when(repo).updateClient(clientEntity, id);
		//Without assert because I can't assert something if the method doesn't retun anything (its a void).
		service.updateClient(id, clientDomain);
	}

}
