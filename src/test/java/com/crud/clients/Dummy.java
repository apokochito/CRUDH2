package com.crud.clients;

import java.util.ArrayList;
import java.util.List;

import com.crud.clients.domain.Client;
import com.crud.clients.entity.ClientEntity;

//Return a list of clients (Entity or Domain)
//Return a client (Entity of Domain)

public class Dummy {

	private List<ClientEntity> clientsE = new ArrayList<ClientEntity>();
	private List<Client> clientD = new ArrayList<Client>();
	private ClientEntity oneClientE = new ClientEntity();
	private Client oneClientD = new Client();
	
	
	public List<ClientEntity> getClientsEntityDummy() {
		
		ClientEntity client = new ClientEntity();
		clientsE.add(client);
		
		//References in Java
		
		client.setAge("23");
		client.setGender("StrongWomen");
		client.setId(3l);
		client.setLastName("Diana");
		client.setName("Apolinar");		
		return clientsE;
	}
	
	public List<Client> getClientsDomainDummy(){
		
		Client client = new Client();
		clientD.add(client);
		
		client.setAge("19");
		client.setGender("StrongMan");
		client.setId(2L);
		client.setLastName("Raul");
		client.setName("Larios");	
		return clientD;
	}
	
public ClientEntity getClientEntityDummy() {
		
		ClientEntity client = new ClientEntity();
		clientsE.add(client);
		
		//References in Java
		
		client.setAge("23");
		client.setGender("StrongWomen");
		client.setId(3l);
		client.setLastName("Diana");
		client.setName("Apolinar");		
		return oneClientE;
	}
	
	public Client getClientDomainDummy(){
		
		Client client = new Client();
		clientD.add(client);
		
		client.setAge("19");
		client.setGender("StrongMan");
		client.setId(2L);
		client.setLastName("Raul");
		client.setName("Larios");	
		return oneClientD;
	}
}
