package com.webui.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webui.client.RestClient;
import com.webui.entity.Item;

@Controller
public class View {

	@Autowired
	private RestClient restClient;

	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@GetMapping("/items")
	public ModelAndView allItems(@RequestParam String serviceUrl) {
		ModelAndView itemView = new ModelAndView("index");
//		String datawarehouseItems = "http://datawarehouse.default.example.com:8181/item";
		itemView.addObject("allitems", restClient.receiveItems(serviceUrl));
//		String shoppingCartItems = "http://shoppingcart.default.example.com:8181/item";
		itemView.addObject("shoppingitems", restClient.receiveItems(serviceUrl));
		return itemView;
	}
	
//	just for testing purposes
	@GetMapping("/noitems")
	public ModelAndView noItems() {
		
		Item item1 = new Item("Lenovo Notebook","Super tolles Notebook. Mega Power.", 1200.00, 123456789, true);
		Item item2 = new Item("MacBook Pro","Super tolles MacBook. Voll viel Power.", 2200.00, 321654721, false);
		Item item3 = new Item("Istio Manning", "Istio Buch vom Manning Verlag", 45.00, 278732782, true);
		
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item1);
	
		ModelAndView itemView = new ModelAndView("index");
		itemView.addObject("allitems", itemList);
		return itemView;
	}
	
	@GetMapping(value="/noitems",  params={"saveItem"})
	public ModelAndView save(final HttpServletRequest req) {
	    final Integer itemNumber = Integer.valueOf(req.getParameter("saveItem"));
		System.out.println("Itemnumber to persist:" +itemNumber);
		//rest call zum peristieren
		restClient.saveItemToBasket(itemNumber);
		ModelAndView itemView = new ModelAndView("index");
		return noItems();
	}
	
	@GetMapping(value="/noitems",  params={"deleteItem"})
	public ModelAndView delete(final HttpServletRequest req) {
	    final Integer itemNumber = Integer.valueOf(req.getParameter("saveItem"));
		System.out.println("Itemnumber to delete:" +itemNumber);
		//rest call zum löschen
		restClient.deleteItemFromBasket(itemNumber);
		ModelAndView itemView = new ModelAndView("index");
		return noItems();
	}
}
