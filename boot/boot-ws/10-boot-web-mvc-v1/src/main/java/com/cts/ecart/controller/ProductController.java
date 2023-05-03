package com.cts.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.ecart.model.Product;
import com.cts.ecart.repository.ProductRepository;

@Controller
@RequestMapping("/ecart")
public class ProductController {
	
	
	@Autowired
	private ProductRepository prodRepo;
	
	@GetMapping("/loadProductForm")
	public String f1() {
		return "product-form";
	}
	
	@PostMapping(value = "/saveProduct")
	public String f2(@RequestParam("productId") int prodId,@RequestParam("productName") String prodName,@RequestParam("price") double price) {
		System.out.println("ID: "+prodId);
		System.out.println("Name: "+prodName);
		System.out.println("Price: "+price);
		return "product-form";
	}
	@PostMapping(value = "/saveProductV1")
	public String saveProd(@ModelAttribute Product prod) {
		System.out.println(prod);
		prodRepo.save(prod);
		return "product-form";
	}
	
	@GetMapping("/listAllProducts")
	public String listAllProducts(Model model) {
		
		List<Product> products = prodRepo.findAll();
		model.addAttribute("prods", products);
		return "products";
	}
	
	

}
