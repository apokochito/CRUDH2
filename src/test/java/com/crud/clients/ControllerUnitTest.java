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

import com.crud.clients.controller.CrudController;
import com.crud.clients.domain.Client;
import com.crud.clients.service.CrudServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class ControllerUnitTest {
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Mock
	CrudServiceImpl service;
	
	@InjectMocks
	CrudController crudController;
	
	private Dummy dummy = new Dummy();
	private Client client = new Client();
	long id=1;
	 
	@Test
	public void getClients() {
		List<Client> clients = dummy.getClientsDomainDummy();
		when(service.getClients()).thenReturn(clients);
		assertNotNull(crudController.getClients());
	}
	
//	when(service.getClients()).thenReturn(Collections.singletonList(clients));
	
	@Test
	public void getClientsById() {
		Client client = dummy.getClientDomainDummy();
		when(service.getById(id)).thenReturn(client);
		assertNotNull(crudController.getById(id));
	}

	@Test
	public void createClient() {
		doNothing().when(service).createClient(client);
		assertNotNull(crudController.createClient(client));
	}
	
	@Test
	public void deleteClient() {
		doNothing().when(service).deleteById(id);
		assertNotNull(crudController.deleteClient(id));
	}
	
	@Test
	public void updateClient() {
		doNothing().when(service).updateClient(id, client);
		assertNotNull(crudController.updateClient(id, client));
	}
}
