package com.crud.clients.mapper;

import com.crud.clients.domain.Client;
import com.crud.clients.entity.ClientEntity;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

// Configurations inherited, provides a simplification for reuse of a particular Orika mapping configuration.
public class OrikaMapper extends ConfigurableMapper {

	// To generate instances will be used to perform the mapping functions
	public MapperFactory mappClientDaoToClient(MapperFactory factory) {
		// Create a mapperFactory that should be the configuration
		// ClassMap(sourceClass, DestinationClass) how must Orika mapping the beans
		// ByDefault() allows to mapping directly all fields with the same name.
		// Register the mapping in the application
		factory.classMap(ClientEntity.class, Client.class).byDefault().register();
		// Returns the factory object
		return factory;
	}
}
