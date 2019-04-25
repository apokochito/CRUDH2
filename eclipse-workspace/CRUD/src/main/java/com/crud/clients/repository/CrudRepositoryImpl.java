package com.crud.clients.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.clients.entity.ClientEntity;


@Repository
public class CrudRepositoryImpl implements CrudRepository{

	// Inject
	@Autowired
	private ClientsRepository clientsRepository;

	@Override
	public List<ClientEntity> getClients() {
		List<ClientEntity> response = (List<ClientEntity>) clientsRepository.findAll();
		return response;
	}

	@Override
	public ClientEntity getById(long id) {
		// Finding and getting the client by Id in the table using JPA WHY?
		ClientEntity response = clientsRepository.findById(id).get();
		return response;
	}

	@Override
	public void createClient(ClientEntity clientEntity) {
		clientsRepository.save(clientEntity); // JPA why?
	}

	@Override
	public void deleteById(long id) {
		clientsRepository.deleteById(id); // JPA why?
	}

	@Override
	public void updateClient(ClientEntity clientEntity, long id) {
		ClientEntity response = clientsRepository.findById(id).get();
		response.setName(clientEntity.getName());
		response.setLastName(clientEntity.getLastName());
		response.setGender(clientEntity.getGender());
		response.setAge(clientEntity.getAge());
		clientsRepository.save(response);
	}
}