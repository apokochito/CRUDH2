package com.crud.clients.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.clients.entity.ClientEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CrudRepository {
	
	@Autowired
	static JpaRepository<ClientEntity, Long> jpa;
	
	public static List<ClientEntity> getClients() {
		List<ClientEntity> daoResponse = jpa.findAll();
		//List<ClientEntity> daoResponse = jpa.findAll();
		log.info("---------"+daoResponse);
		return daoResponse;
	}

	public static ClientEntity getById(long id) {
		// Finding and getting the client by Id in the table using JPA WHY?
		ClientEntity daoResponse = (ClientEntity) jpa.findById(id).get();
		return daoResponse;
	}

	public static void createClient(ClientEntity clientEntity) {
		jpa.save(clientEntity);
	}

	public static void deleteById(long id) {
		jpa.deleteById(id);
	}

	public static void updateClient(ClientEntity clientEntity, long id) {
		ClientEntity daoResponse = (ClientEntity) jpa.findById(id).get(); // JPA why?
		daoResponse.setName(clientEntity.getName());
		daoResponse.setLastName(clientEntity.getLastName());
		daoResponse.setGender(clientEntity.getGender());
		daoResponse.setAge(clientEntity.getAge());
		jpa.save(daoResponse);
	}
}