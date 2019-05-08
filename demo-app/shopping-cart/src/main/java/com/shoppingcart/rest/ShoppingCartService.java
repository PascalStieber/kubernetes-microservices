package com.shoppingcart.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShoppingCartService {

	@PostMapping(value="/",  params={"saveItem"})
	public void save(final HttpServletRequest req) {
	    final Integer itemNumber = Integer.valueOf(req.getParameter("saveItem"));
	}
	
	@PostMapping(value="/",  params={"deleteItem"})
	public void delete(final HttpServletRequest req) {
	    final Integer itemNumber = Integer.valueOf(req.getParameter("deleteItem"));
	}
	
}
