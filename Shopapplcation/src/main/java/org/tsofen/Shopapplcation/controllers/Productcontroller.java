package org.tsofen.Shopapplcation.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsofen.Shopapplcation.BL.ProductBL;
import org.tsofen.Shopapplcation.Bean.Product;

@RestController
@RequestMapping("products")
@CrossOrigin
public class Productcontroller {
	@Autowired
	ProductBL productBL;
	
	@PostMapping("add")
	public void addProduct(@RequestBody Product product){
		productBL.addnewProduct(product);
			
	}
	
	@PostMapping("delete")
	public void deletProduct(@RequestBody Product product){
		productBL.deleteProduct(product);
			
	}
	
	@GetMapping("all")
	public List<Product> getAllProducts(){
		return productBL.findAll();
		
	}
	
}

