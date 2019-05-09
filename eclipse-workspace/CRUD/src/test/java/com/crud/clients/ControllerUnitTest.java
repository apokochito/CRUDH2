package com.crud.clients;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crud.clients.controller.CrudController;
import com.crud.clients.domain.Client;
import com.crud.clients.service.CrudServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class ControllerUnitTest {

	@Mock
	CrudServiceImpl service;
	
	@InjectMocks
	CrudController controller;
	
	private Client clients = new Client();
	long id=1;
	 
	@Test
	public void getClients() {
		when(service.getClients()).thenReturn(Collections.singletonList(clients));
		assertNotNull(controller.getClients());
	}
	
	@Test
	public void getClientsById() {
		when(service.getById(id)).thenReturn(clients);
		assertNotNull(controller.getById(id));
	}

	@Test
	public void createClient() {
		doNothing().when(service).createClient(clients);
		//when(service.createClient(client)).thenReturn(client);
		assertNotNull(controller.createClient(clients));
	}
	
	@Test
	public void deleteClient() {
		doNothing().when(service).deleteById(id);
		assertNotNull(controller.deleteClient(id));
	}
	
	@Test
	public void updateClient() {
		doNothing().when(service).updateClient(id, clients);
		assertNotNull(controller.updateClient(id, clients));
	}
}
