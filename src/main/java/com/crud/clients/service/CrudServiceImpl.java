package com.crud.clients.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.clients.domain.Client;
import com.crud.clients.entity.ClientEntity;
import com.crud.clients.mapper.OrikaMapper;
import com.crud.clients.repository.CrudRepository;

import ma.glasnost.orika.MapperFacade;

@Service
public class CrudServiceImpl implements CrudService {

	@Autowired // Inject
	private CrudRepository repo;

	// Instantiate Orika Mapper (mapper of beans)
	private MapperFacade facade = new OrikaMapper();

	@Override
	public List<Client> getClients() {
		List<ClientEntity> responseEntity = repo.getClients();
		List<Client> clientDomain = new ArrayList<Client>();
		// stream - To process collections of objects: for each element(variable) (->)
		// do that sequence
		responseEntity.stream().forEach((clientD) -> {
			clientDomain.add(facade.map(clientD, Client.class)); // Adding every element to domain response
		});
		return clientDomain;
	}

	@Override
	public Client getById(long id) {
		ClientEntity clientEntity = new ClientEntity();
		Client clientDomain = new Client();
		clientEntity = repo.getById(id);
		clientDomain = facade.map(clientEntity, Client.class);
		return clientDomain;
	}

	@Override
	public void createClient(Client client) {
		ClientEntity clientEntity = new ClientEntity();
		clientEntity = facade.map(client, ClientEntity.class);
		repo.createClient(clientEntity);
	}

	@Override
	public void deleteById(long id) {
		repo.deleteById(id);
	}

	@Override
	public void updateClient(long id, Client client) {
		ClientEntity clientEntity = new ClientEntity();
		clientEntity = facade.map(client, ClientEntity.class);
		repo.updateClient(clientEntity, id);
	}
}