package org.tsofen.Shopapplcation.Bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tsofen.Shopapplcation.BL.ProductBL;
import org.tsofen.Shopapplcation.BL.RevenueBL;



@Component
public class Report {
	
	
	
	@Autowired
	ProductBL productBL;
	
	@Autowired
	RevenueBL revenuesBL;
	
	
	private List<Product> getInventory(){
		return productBL.findByAmountGreaterThan(0);
	}
	
	private List<Product> getmissingproducts(){
		return productBL.findByAmount(0);
	}
	
	private List<Revenue> getrevenues(){
		return revenuesBL.findAll();
	}
	
	public void Inventory() {
		for(Product prod : getInventory()) {
			System.out.println(prod);
		}
	}
	
	public void missingproducts() {
		for(Product prod : getmissingproducts()) {
			System.out.println(prod);
		}	
	}	
	
	public void revenues() {
		int sum = 0;
		for(Revenue revenue : getrevenues()) {
			System.out.println(revenue);
			sum += revenue.getRevenueprofit();
		}	
		System.out.println("totalrevenueprofits= " + sum);
	}	
    

}
