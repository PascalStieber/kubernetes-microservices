package com.webui.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webui.entity.Item;

@Service
public class RestClient {

	public List<Item> receiveAllAvailableItems() {
		RestTemplate restTemplate = new RestTemplate();
		
		   ParameterizedTypeReference<PagedResources<Item>> responseTypeRef = new ParameterizedTypeReference<PagedResources<Item>>() {
		    };

		    String API_URL = "http://datawarehouse:8181/item";
		    ResponseEntity<PagedResources<Item>> responseEntity = restTemplate().exchange(API_URL, HttpMethod.GET,
		            (HttpEntity<Item>) null, responseTypeRef);

		    PagedResources<Item> resources = responseEntity.getBody();
		    Collection<Item> items = resources.getContent();
		    List<Item> itemsList = new ArrayList<Item>(items);

		return itemsList;
	}
	
	private RestTemplate restTemplate() {

	    ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    mapper.registerModule(new Jackson2HalModule());

	    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	    converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
	    converter.setObjectMapper(mapper);

	    List<HttpMessageConverter<?>> converterList = new ArrayList<HttpMessageConverter<?>>();
	    converterList.add(converter);
	    RestTemplate restTemplate = new RestTemplate(converterList);

	    return restTemplate;
	}

}
