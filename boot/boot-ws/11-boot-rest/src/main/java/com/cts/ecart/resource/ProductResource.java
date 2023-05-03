package com.cts.ecart.resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/products")
public class ProductResource {
	
	@GetMapping
	public String f1() {
		return "GET Request";
	}
	
	@PostMapping
	public String f2() {
		return "POST Request";
	}
	
	@PutMapping
	public String f3() {
		return "PUT Request";
	}
	
	@PatchMapping
	public String f4() {
		return "PATCH Request";
	}
	
	@DeleteMapping
	public String f5() {
		return "DELETE Request";
	}

}
