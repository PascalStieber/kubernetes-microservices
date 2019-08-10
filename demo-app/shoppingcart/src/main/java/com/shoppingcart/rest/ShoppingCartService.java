package com.shoppingcart.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.shoppingcart.entity.Item;
import com.shoppingcart.repository.ItemRepository;


@Controller
public class ShoppingCartService {

	@Autowired
	private ItemRepository itemRepository;
	
	@PostMapping(value="/",  params={"saveItem"})
	public ResponseEntity<Item> save(final HttpServletRequest req) {
	    final Integer itemNumber = Integer.valueOf(req.getParameter("saveItem"));
	    Item itemToAdd = new Item("","",0.0,itemNumber,true);
		Item addedItem = itemRepository.save(itemToAdd);
		return ResponseEntity.ok(addedItem);
	}
	
	@PostMapping(value="/",  params={"deleteItem"})
	public ResponseEntity<Item> delete(final HttpServletRequest req) {
	    final Integer itemNumber = Integer.valueOf(req.getParameter("deleteItem"));
	    Item itemToDelete = new Item("","",0.0,itemNumber,true);
		itemRepository.deleteAll(itemRepository.findByNumber(itemNumber));
	    return ResponseEntity.ok(itemToDelete);
	}
	
}
