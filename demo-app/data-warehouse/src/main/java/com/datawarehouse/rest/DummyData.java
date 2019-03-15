package com.datawarehouse.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datawarehouse.entity.Item;
import com.datawarehouse.repository.ItemRepository;

@RestController
public class DummyData {

	@Autowired
	private ItemRepository itemRepository;
	
	
	@GetMapping("/dummydata")
	public void createDummyData() {
		Item item1 = new Item("Lenovo Notebook","Super tolles Notebook. Mega Power.", 1200.00, 123456789, true);
		Item item2 = new Item("MacBook Pro","Super tolles MacBook. Voll viel Power.", 2200.00, 321654721, false);
		Item item3 = new Item("Istio Manning", "Istio Buch vom Manning Verlag", 45.00, 278732782, true);
		itemRepository.save(item1);
		itemRepository.save(item2);
		itemRepository.save(item3);		
		
	}

}
