package com.crud.clients;

import java.util.ArrayList;
import java.util.List;

import com.crud.clients.entity.ClientEntity;

public class Dummy {

	private List<ClientEntity> clients = new ArrayList<ClientEntity>();
	
	public List<ClientEntity> getClientEntityDummy() {
		
		ClientEntity client = new ClientEntity();
		clients.add(client);
		
		//References in Java
		
		client.setAge("23");
		client.setGender("StrongWomen");
		client.setId(3l);
		client.setLastName("Diana");
		client.setName("Apolinar");		
		return clients;
	}
}
