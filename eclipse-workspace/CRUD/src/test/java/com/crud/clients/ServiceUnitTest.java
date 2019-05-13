package com.crud.clients;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crud.clients.domain.Client;
import com.crud.clients.entity.ClientEntity;
import com.crud.clients.mapper.OrikaMapper;
import com.crud.clients.repository.CrudRepository;
import com.crud.clients.service.CrudServiceImpl;

import ma.glasnost.orika.MapperFacade;

@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceUnitTest {
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Mock
	CrudRepository repo;
	
	@InjectMocks
	CrudServiceImpl service;
	
	@Mock
	MapperFacade facade = new OrikaMapper();

	private Dummy dummy = new Dummy();
	
	private ClientEntity clientEntity = new ClientEntity();
	private Client clientDomain = new Client();
	long id=1;
	
	// One assertions for test
	@Test
	public void getClients() {
		List<ClientEntity> clients = dummy.getClientsEntityDummy();
		when(repo.getClients()).thenReturn(clients);
		assertNotNull(service.getClients());
	}
	
//	@Test
//	public void getClients() {
//		when(repo.getClients()).thenReturn(Collections.singletonList(clientEntity));
//		assertThat(response).asList();
//		when(facade.map(clientEntity, Client.class)).thenReturn(clientDomain);
//		assertNotNull(service.getClients());
//	}
	
	@Test
	public void getByIdClient() {
		when(repo.getById(id)).thenReturn(clientEntity);
		when(facade.map(clientEntity, Client.class)).thenReturn(clientDomain);
		assertNotNull(service.getById(id));
	}
	
	@Test
	public void createClient() {
		
		when(facade.map(clientDomain, ClientEntity.class)).thenReturn(clientEntity);
		doNothing().when(repo).createClient(clientEntity);
		service.createClient(clientDomain);
	}
	
	@Test
	public void deleteClient() {
		doNothing().when(repo).deleteById(id);
		service.deleteById(id);
	}
	
	@Test
	public void updateClient() {
		when(facade.map(clientDomain, ClientEntity.class)).thenReturn(clientEntity);
		doNothing().when(repo).updateClient(clientEntity, id);
		//Without assert because I can't assert something if the method doesn't retun anything (its a void).
		service.updateClient(id, clientDomain);
	}
}
