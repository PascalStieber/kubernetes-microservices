package com.webui.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webui.client.RestClient;

@Controller
public class View {
	
	private static final String DATAWAREHOUSE_ITEMS = "http://datawarehouse.myproject.svc.cluster.local";
	private static final String SHOPPINGCART_ITEMS = "http://shoppingcart.myproject.svc.cluster.local";
	

	@Autowired
	private RestClient restClient;

	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@GetMapping("/items")
//	public ModelAndView allItems(@RequestParam String serviceUrl) {
	public ModelAndView allItems() {
		ModelAndView itemView = new ModelAndView("index");
//		String datawarehouseItems = "http://datawarehouse.default.example.com:8181/item";
		itemView.addObject("allitems", restClient.receiveItems(DATAWAREHOUSE_ITEMS));
//		String shoppingCartItems = "http://shoppingcart.default.example.com:8181/item";
		itemView.addObject("shoppingitems", restClient.receiveItems(SHOPPINGCART_ITEMS));
		return itemView;
	}
	
	@GetMapping(value="/items", params={"saveItem"})
	public ModelAndView saveItem(final HttpServletRequest req) {
	    final Integer itemNumber = Integer.valueOf(req.getParameter("saveItem"));
		System.out.println("Itemnumber to persist:" +itemNumber);
		//rest call zum peristieren
		restClient.saveItemToBasket(itemNumber, SHOPPINGCART_ITEMS);
		return allItems();
	}
	@GetMapping(value="/items", params={"deleteItem"})
	public ModelAndView deleteItem(final HttpServletRequest req) {
	    final Integer itemNumber = Integer.valueOf(req.getParameter("deleteItem"));
		System.out.println("Itemnumber to delete:" +itemNumber);
		//rest call zum peristieren
		restClient.deleteItemFromBasket(itemNumber, SHOPPINGCART_ITEMS);
		return allItems();
	}
	
//	just for testing purposes
//	@GetMapping("/noitems")
//	public ModelAndView noItems() {
//		
//		Item item1 = new Item("Lenovo Notebook","Super tolles Notebook. Mega Power.", 1200.00, 123456789, true);
//		Item item2 = new Item("MacBook Pro","Super tolles MacBook. Voll viel Power.", 2200.00, 321654721, false);
//		Item item3 = new Item("Istio Manning", "Istio Buch vom Manning Verlag", 45.00, 278732782, true);
//		
//		List<Item> itemList = new ArrayList<Item>();
//		itemList.add(item2);
//		itemList.add(item3);
//		itemList.add(item1);
//		
//		
//		List<Item> shoppingList = new ArrayList<Item>();
//		shoppingList.add(item2);
//		shoppingList.add(item3);
//	
//		ModelAndView itemView = new ModelAndView("index");
//		itemView.addObject("allitems", itemList);
//		itemView.addObject("shoppingitems", shoppingList);
//		return itemView;
//	}
	
//	@GetMapping(value="/noitems",  params={"saveItem"})
//	public ModelAndView save(final HttpServletRequest req) {
//	    final Integer itemNumber = Integer.valueOf(req.getParameter("saveItem"));
//		System.out.println("Itemnumber to persist:" +itemNumber);
//		//rest call zum peristieren
//		restClient.saveItemToBasket(itemNumber, "");
//		ModelAndView itemView = new ModelAndView("index");
//		return noItems();
//	}
//	
//	@GetMapping(value="/noitems",  params={"deleteItem"})
//	public ModelAndView delete(final HttpServletRequest req) {
//	    final Integer itemNumber = Integer.valueOf(req.getParameter("saveItem"));
//		System.out.println("Itemnumber to delete:" +itemNumber);
//		//rest call zum löschen
//		restClient.deleteItemFromBasket(itemNumber, "");
//		ModelAndView itemView = new ModelAndView("index");
//		return noItems();
//	}
}
