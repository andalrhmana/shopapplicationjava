package org.tsofen.Shopapplcation.BL;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsofen.Shopapplcation.Bean.Product;
import org.tsofen.Shopapplcation.Bean.transaction;
import org.tsofen.Shopapplcation.Bean.transaction_product;
import org.tsofen.Shopapplcation.DAO.transactionDAO;
import org.tsofen.Shopapplcation.Exptions.NoEnoughAmountException;
import org.tsofen.Shopapplcation.Exptions.OneOfProductsAreFinishedExption;
import org.tsofen.Shopapplcation.Exptions.ProductDontExistException;

@Service
public class transactionBL {
	
	@Autowired
	transaction_productBL tran_prBL;

	
	@Autowired
	transactionDAO tranDAO;
	
	@Autowired
	ProductBL productBL;
	
	public void makenewtransaction(Map<Integer,Integer> codestoamount) throws OneOfProductsAreFinishedExption {
		transaction newtransaction = new transaction();
		Date date = new Date();
		newtransaction.setDate(date.toString());
		float sumtransaction = 0;
		for(int code : codestoamount.keySet()) {
			try {
				productBL.buyProduct(code, codestoamount.get(code));
			} catch (ProductDontExistException | NoEnoughAmountException e) {
				// TODO Auto-generated catch block
				throw new OneOfProductsAreFinishedExption();
			}
			
			transaction_product newproduct = new transaction_product();
			newproduct.setName(productBL.findBycode(code).get(0).getName());
			newproduct.setCode(productBL.findBycode(code).get(0).getCode());
			newproduct.setPrice(productBL.findBycode(code).get(0).getPrice());
			newproduct.setAmount(codestoamount.get(code));
			sumtransaction+= newproduct.getAmount()*newproduct.getPrice();
			newtransaction.addProducts(newproduct);
			tran_prBL.save(newproduct);
		}
		newtransaction.setSumtransaction(sumtransaction);
		tranDAO.save(newtransaction);
	
	}
	public List<Product> makenewtransaction(List<Product> products) {
		List<Product> pros = new LinkedList<>();
		transaction newtransaction = new transaction();
		Date date = new Date();
		newtransaction.setDate(date.toString());
		float sumtransaction = 0;
		for(Product product : products) {
	        
			try {
				productBL.buyProduct(product);
			} catch (ProductDontExistException | NoEnoughAmountException e) {
				pros.add(product);
				
			}
			
			transaction_product newproduct = new transaction_product();
			newproduct.setName(product.getName());
			newproduct.setCode(product.getCode());
			newproduct.setPrice(product.getPrice());
			newproduct.setAmount(product.getAmount());
			sumtransaction+= newproduct.getAmount()*newproduct.getPrice();
			newtransaction.addProducts(newproduct);
			tran_prBL.save(newproduct);
		}
		newtransaction.setSumtransaction(sumtransaction);
		tranDAO.save(newtransaction);
		return pros;
	
	}


	public List<transaction> findAll() {
		// TODO Auto-generated method stub
		return tranDAO.findAll();
	}
}
