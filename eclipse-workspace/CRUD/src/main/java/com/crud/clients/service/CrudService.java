package com.crud.clients.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.clients.domain.Client;
import com.crud.clients.entity.ClientEntity;
import com.crud.clients.mapper.OrikaMapper;
import com.crud.clients.repository.CrudRepository;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;

@Slf4j
// To detect this interface by ScanComponent like Service
@Service
public class CrudService {
	
	// Instantiate Orika Mapper (mapper of beans)
		static MapperFacade facade = new OrikaMapper();

	// Conduct to Service Implementation
	public static List<Client> getClients(){
		List<ClientEntity> reponseEntity = CrudRepository.getClients();
		List<Client> response = new ArrayList<Client>();
		// stream - To process collections of objects: for each element(variable) (->)
		// do that sequence
		reponseEntity.stream().forEach((clientD) -> {
			response.add(facade.map(clientD, Client.class)); // Adding every element to domain response
		});
		log.info("---------"+response);
		return response;
	}

	public static Client getById(long id) {
		// Instantiate a client of the entity
				ClientEntity clientEntity = new ClientEntity();
				// Instantiate the domain
				Client clientD = new Client();
				clientEntity = CrudRepository.getById(id);
				clientD.setId(clientEntity.getId());
				clientD.setName(clientEntity.getName());
				clientD.setLastName(clientEntity.getLastName());
				clientD.setGender(clientEntity.getGender());
				clientD.setAge(clientEntity.getAge());
				return clientD;
	}

	public static void createClient(Client client) {
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setName(client.getName());
		clientEntity.setLastName(client.getLastName());
		clientEntity.setGender(client.getGender());
		clientEntity.setAge(client.getAge());
		CrudRepository.createClient(clientEntity);
	}

	public static void deleteById(long id) {
		CrudRepository.deleteById(id);
	}

	public static void updateClient(long id, Client client) {
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setName(client.getName());
		clientEntity.setLastName(client.getLastName());
		clientEntity.setGender(client.getGender());
		clientEntity.setAge(client.getAge());
		CrudRepository.updateClient(clientEntity, id);
	}
}