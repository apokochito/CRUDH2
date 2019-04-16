//package com.crud.clients.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//
//import com.crud.clients.domain.Client;
//import com.crud.clients.service.CrudService;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Component
//public class CrudControllerImpl {
//
//	// private static final Logger log=LoggerFactory.getLogger(CrudControllerImpl.class);
//	
//	
//	
////	@Autowired // To test
////	public CrudControllerImpl(final CrudService crudService) {
////		this.crudService = crudService;
////	}
//
//	// When a method implements an interface for the same benefits.
//	@Override
//	public List<Client> getClients() {
//		log.info(":LOG: GET CONTROLLER :  getAllClients : RUNNING :::");
//		return crudService.getClients();
//	}
//
//	@Override
//	public ResponseEntity<Client> getById(long id) {
//		Client client = crudService.getById(id);
//		log.info(":LOG: GET CONTROLLER :  getByIdClient : RUNNING :::");
//		return ResponseEntity.ok().body(client);
//	}
//
//	@Override
//	public ResponseEntity<String> createClient(Client client) {
//		crudService.createClient(client);
//		log.info(":LOG: GET CONTROLLER :  createClient : RUNNING :::");
//		return new ResponseEntity<>(" Client CREATED : client ", HttpStatus.CREATED);
//	}
//
//	@Override
//	public ResponseEntity<String> deleteClient(long id) {
//		crudService.deleteById(id);
//		log.info(":LOG: GET CONTROLLER :  deleteClient : RUNNING :::");
//		return new ResponseEntity<>(" Client DELETED   : client ", HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity<String> updateClient(long id, Client client) {
//		crudService.updateClient(id, client);
//		log.info(":LOG: GET CONTROLLER :  updateClient : RUNNING :::");
//		return new ResponseEntity<>(" Client UPDATED   : client ", HttpStatus.OK);
//	}
//
//}
