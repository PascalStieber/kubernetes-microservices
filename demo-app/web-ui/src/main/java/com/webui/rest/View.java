package com.webui.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webui.client.RestClient;

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
//		String defaultURL = "http://datawarehouse.default.example.com:8181/item";
		itemView.addObject("items", restClient.receiveAllAvailableItems(serviceUrl));
		return itemView;
	}
}
