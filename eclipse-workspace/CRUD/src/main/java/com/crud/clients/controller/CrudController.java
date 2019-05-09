package com.crud.clients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController // Mapping web requests, base URI
@RequestMapping(value = "/crud")
@Api(value="Microservices H2", tags="Microservices H2")
public class CrudController {
	
	private final CrudService service;

	@Autowired
	public CrudController(CrudService service) {
		this.service = service;
	} //The best way

	// @Autowired
	// CrudService service;
	
	// private static final Logger log=LoggerFactory.getLogger(CrudControllerImpl.class);
	
	@ApiOperation(value=" GET CLIENTS ",  notes=" THIS OPERATION WILL RETURN A LIST OF CLIENTS ")
	@ApiResponses({@ApiResponse(code = 200 , message =" SUCCESS OPERATION ")})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/Clients")
	public List<Client> getClients(){
		List<Client> client = service.getClients();
		return client;
	}

	@ApiOperation(value=" GET A CLIENT ",  notes=" THIS OPERATION WILL RETURN ONE CLIENT ")
	@ApiResponses({@ApiResponse(code = 200 , message =" SUCCESS OPERATION ")})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/Clients/{id}")
	// Represents the whole HTTP response, generic type for more flexibility.
	public ResponseEntity<Client> getById(@PathVariable("id") long id){
		Client client = service.getById(id);
		return ResponseEntity.ok().body(client);
	}

	@ApiOperation(value=" CREATE A CLIENT ",  notes=" THIS OPERATION WILL CREATE A CLIENT ")
	@ApiResponses({@ApiResponse(code = 200 , message =" SUCCESS OPERATION ")})
	@PostMapping(value = "/Clients")
	public ResponseEntity<String> createClient(@RequestBody Client client){
		service.createClient(client);
		return new ResponseEntity<>(" Client CREATED : client ", HttpStatus.CREATED);
	}

	@ApiOperation(value=" DELETE A CLIENT ",  notes=" THIS OPERATION WILL DELETE A CLIENT ")
	@ApiResponses({@ApiResponse(code = 200 , message =" SUCCESS OPERATION ")})
	@DeleteMapping(value = "/Clients/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable("id") long id){
		service.deleteById(id);
		return new ResponseEntity<>(" Client DELETED   : client ", HttpStatus.OK);
	}

	@ApiOperation(value=" UPDATE A CLIENT ",  notes=" THIS OPERATION WILL UPDATE A CLIENT ")
	@ApiResponses({@ApiResponse(code = 200 , message =" SUCCESS OPERATION ")})
	@PutMapping(value = "/Clients/{id}")
	public ResponseEntity<String> updateClient(@PathVariable("id") long id, @RequestBody Client client){
		service.updateClient(id, client);
		return new ResponseEntity<>(" Client UPDATED   : client ", HttpStatus.OK);
	}

}
