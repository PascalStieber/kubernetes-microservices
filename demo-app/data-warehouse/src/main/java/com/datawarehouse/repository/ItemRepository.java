package com.datawarehouse.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.datawarehouse.entity.Item;

@RepositoryRestResource(collectionResourceRel = "item", path = "item")
public interface ItemRepository extends MongoRepository<Item, String> {

	List<Item> findByNumber(@Param("number") int number);
	List<Item> findByName(@Param("name") String name);
	
}
