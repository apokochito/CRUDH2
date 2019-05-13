package com.crud.clients;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crud.clients.entity.ClientEntity;
import com.crud.clients.repository.CrudRepositoryImpl;
import com.crud.clients.repository.JPAClients;

@RunWith(SpringJUnit4ClassRunner.class) //for the null error
public class RepositoryUnitTest {
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Mock JPAClients jPAClients;
	
	@InjectMocks
	CrudRepositoryImpl repo;
	
	private long id = 1L;
	private Dummy dummy = new Dummy();
	private Optional<ClientEntity> oClient = Optional.of(dummy.getClientEntityDummy());
	
	//private ClientEntity client = new ClientEntity();
	//Collections.singletonList(client)
	//DummyFactory dummyFactory;
	
	@Test
	public void getClients() {
		//client = dummy.getDummyClient();
		when(jPAClients.findAll()).thenReturn(dummy.getClientsEntityDummy());
		assertNotNull(repo.getClients());
	}
	
	@Test
	public void getById() {
		//Here the .get(); by Optional
		when(jPAClients.findById(id)).thenReturn(oClient);
		assertNotNull(repo.getById(id));
	}
	
	@Test
	public void createClient() {
		when(jPAClients.save(dummy.getClientEntityDummy())).thenReturn(new ClientEntity());
		// Why then return new ClientEntity? If its a void? .save();
		repo.createClient(dummy.getClientEntityDummy());
	}
	
	@Test
	public void deleteById() {
		doNothing().when(jPAClients).deleteById(id);
		repo.deleteById(id);
	}
	
	@Test
	public void updateClient() {
		//Because findById returns another type of object (doNothing(). doesn't apply).
		when(jPAClients.findById(id)).thenReturn(oClient);
		when(jPAClients.save(dummy.getClientEntityDummy())).thenReturn(dummy.getClientEntityDummy());
		repo.updateClient(dummy.getClientEntityDummy(), id);
	}
}
