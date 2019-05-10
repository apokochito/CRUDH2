package com.crud.clients;

import com.crud.clients.entity.ClientEntity;

public class DummyFactory {
	
	//wkdj
	
	public ClientEntity getDummyClient() {
		
		ClientEntity clientEntity = new ClientEntity();
		
		clientEntity.setId(1L);
		clientEntity.setName("Dummy");
		clientEntity.setLastName("DummyLastName");
		clientEntity.setAge("23");
		clientEntity.setGender("GenderDummy");
		
		return clientEntity;
	}
	
}
