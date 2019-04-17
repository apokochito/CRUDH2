package com.crud.clients.service;

import java.util.List;

import com.crud.clients.domain.Client;

public interface CrudService {

	// Conduct to Service Implementation
	public List<Client> getClients();
	
	public Client getById(long id);

	public void createClient(Client client);

	public void deleteById(long id);

	public void updateClient(long id, Client client);
}