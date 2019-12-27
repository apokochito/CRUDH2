package com.crud.clients.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

// Generates getters for all fields (@Getter, @Setter, @ToString, etc)
// Relationship between an object and a database table
@Data
@Entity
@Table(name = "CLIENTS")
public class ClientEntity implements Serializable {

	// To ensure during deserialization process that it's the same class that was
	// loaded before.
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Column(name = "NAME")
	private String name;

	@NotNull
	@Column(name = "LAST_NAME")
	private String lastName;

	@NotNull
	@Column(name = "AGE")
	private String age;

	@Column(name = "GENDER")
	private String gender;

}
