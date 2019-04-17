package com.crud.clients.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.clients.entity.ClientEntity;

@Repository
public class CrudRepositoryImpl implements CrudRepository{

	// Inject
	@Autowired
	private Jpa jpa;

	@Override
	public List<ClientEntity> getClients() {
		List<ClientEntity> daoResponse = (List<ClientEntity>) jpa.findAll();
		return daoResponse;
	}

	@Override
	public ClientEntity getById(long id) {
		// Finding and getting the client by Id in the table using JPA WHY?
		ClientEntity daoResponse = jpa.findById(id).get();
		return daoResponse;
	}

	@Override
	public void createClient(ClientEntity clientEntity) {
		jpa.save(clientEntity); // JPA why?
	}

	@Override
	public void deleteById(long id) {
		jpa.deleteById(id); // JPA why?
	}

	@Override
	public void updateClient(ClientEntity clientEntity, long id) {
		ClientEntity daoResponse = jpa.findById(id).get(); // JPA why?
		daoResponse.setName(clientEntity.getName());
		daoResponse.setLastName(clientEntity.getLastName());
		daoResponse.setGender(clientEntity.getGender());
		daoResponse.setAge(clientEntity.getAge());
		jpa.save(daoResponse);
	}
}