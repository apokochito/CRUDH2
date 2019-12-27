package com.crud.clients;


import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crud.clients.entity.ClientEntity;
import com.crud.clients.repository.CrudRepositoryImpl;
import com.crud.clients.repository.JPAClients;

@RunWith(SpringJUnit4ClassRunner.class) //for the null error
public class RepositoryImplUnitTest {
	//Back my test

	@Mock JPAClients jPAClients;
	
	@InjectMocks
	CrudRepositoryImpl repo;
	
	private long id = 1;
	private ClientEntity client = new ClientEntity();
	private Optional<ClientEntity> oPclient = Optional.of(client);
	//DummyFactory dummyFactory;
	
	@Test
	public void getClients() {
		//client = dummy.getDummyClient();
		when(jPAClients.findAll()).thenReturn(Collections.singletonList(client));
		assertNotNull(repo.getClients());
	}
	
	@Test
	public void getById() {
		//doReturn(clients).when(clientsRepository.findById(id));
		//Here the .get(); by Optional
		when(jPAClients.findById(id)).thenReturn(oPclient);
		assertNotNull(repo.getById(id));
	}
	
	@Test
	public void createClient() {
		when(jPAClients.save(client)).thenReturn(new ClientEntity());
		repo.createClient(client);
	}
	
	@Test
	public void deleteById() {
		doNothing().when(jPAClients).deleteById(id);
		repo.deleteById(id);
	}
	
	@Test
	public void updateClient() {
		//Because findById returns another type of object (doNothing(). doesn't apply).
		when(jPAClients.findById(id)).thenReturn(oPclient);
		when(jPAClients.save(client)).thenReturn(client);
		repo.updateClient(client, id);
	}
}