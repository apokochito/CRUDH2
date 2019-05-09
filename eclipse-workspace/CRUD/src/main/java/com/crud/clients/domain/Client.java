package com.crud.clients.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

// Generates getters for all fields (@Getter, @Setter, @ToString, etc)

// To returns a representation of a domain object that corresponds
// to the request accept type specified in the HTTP request.
@Data
public class Client {
	@ApiModelProperty(example="1", value="Identifier of the client")
	private long id;
	@ApiModelProperty(example="Juan", value="Name of the client")
	private String name;
	@ApiModelProperty(example="Perez", value="Lastname of the client")
	private String lastName;
	@ApiModelProperty(example="34", value="Age of the client")
	private String age;
	@ApiModelProperty(example="Male", value="Gender of the client")
	private String gender;
}
