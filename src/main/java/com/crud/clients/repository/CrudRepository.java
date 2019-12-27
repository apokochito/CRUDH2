package com.crud.clients.repository;

import java.util.List;

import com.crud.clients.entity.ClientEntity;

public interface CrudRepository {
	
	public List<ClientEntity> getClients();

	public ClientEntity getById(long id);

	public void createClient(ClientEntity clientEntity);

	public void deleteById(long id);

	public void updateClient(ClientEntity clientEntity, long id);
}