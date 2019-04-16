package com.crud.clients.domain;

import lombok.Data;

// Generates getters for all fields (@Getter, @Setter, @ToString, etc)

// To returns a representation of a domain object that corresponds
// to the request accept type specified in the HTTP request.
@Data
public class Client {

	private long id;
	private String name;
	private String lastName;
	private String age;
	private String gender;
}
