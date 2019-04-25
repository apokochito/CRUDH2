package com.crud.clients.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crud.clients.domain.Client;
import com.crud.clients.service.CrudService;

@RestController // Mapping web requests, base URI
@RequestMapping(value = "/crud")
public class CrudController {
	
	private final CrudService service;

	public CrudController(CrudService service) {
		this.service = service;
	} //The best way

	// @Autowired
	// CrudService service;
	
	// private static final Logger log=LoggerFactory.getLogger(CrudControllerImpl.class);
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/Clients")
	public List<Client> getClients(){
		List<Client> client = service.getClients();
		return client;
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/Clients/{id}")
	// Represents the whole HTTP response, generic type for more flexibility.
	public ResponseEntity<Client> getById(@PathVariable("id") long id){
		Client client = service.getById(id);
		return ResponseEntity.ok().body(client);
	}

	@PostMapping(value = "/Clients")
	public ResponseEntity<String> createClient(@RequestBody Client client){
		service.createClient(client);
		return new ResponseEntity<>(" Client CREATED : client ", HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/Clients/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable("id") long id){
		service.deleteById(id);
		return new ResponseEntity<>(" Client DELETED   : client ", HttpStatus.OK);
	}

	@PutMapping(value = "/Clients/{id}")
	public ResponseEntity<String> updateClient(@PathVariable("id") long id, @RequestBody Client client){
		service.updateClient(id, client);
		return new ResponseEntity<>(" Client UPDATED   : client ", HttpStatus.OK);
	}

}
