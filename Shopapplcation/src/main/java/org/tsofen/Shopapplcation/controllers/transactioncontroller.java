package org.tsofen.Shopapplcation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsofen.Shopapplcation.BL.transactionBL;
import org.tsofen.Shopapplcation.Bean.Product;

@RestController
@RequestMapping("deals")
@CrossOrigin
public class transactioncontroller {
	
	@Autowired
	transactionBL tranBL;

	@PostMapping("buy")
	public ResponseEntity addUser(@RequestBody List<Product> products){
		List<Product> pro1 = tranBL.makenewtransaction(products);
		if(pro1.isEmpty()) {	
			return ResponseEntity.ok(pro1);
		}
		String s = "";
		for(Product p:pro1) {
			s += p.getName() + "\n";
		}
			
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Products not exist:" + s); 
			
	}
}
