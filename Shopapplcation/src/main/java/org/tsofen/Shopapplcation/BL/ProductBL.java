package org.tsofen.Shopapplcation.BL;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsofen.Shopapplcation.Bean.Product;
import org.tsofen.Shopapplcation.Bean.Revenue;
import org.tsofen.Shopapplcation.DAO.ProductDAO;
import org.tsofen.Shopapplcation.Exptions.NoEnoughAmountException;
import org.tsofen.Shopapplcation.Exptions.ProductDontExistException;


@Service
public class ProductBL {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	RevenueBL revenuesBL;
	
	public void addnewProduct(Product newProduct) {
		List<Product> pro = productDAO.findBycode(newProduct.getCode());
		if(!pro.isEmpty()) {
			pro.get(0).setAmount(pro.get(0).getAmount() + newProduct.getAmount());
		}
		else {
			productDAO.save(newProduct);
		}	
	}
	
	public void addnewProduct(String image, String name, int code, int amount, int price) {
		Product newproduct = new Product();
		newproduct.setName(name);
		newproduct.setCode(code);
		newproduct.setAmount(amount);
		newproduct.setPrice(price);
		newproduct.setImage(image);
		addnewProduct(newproduct);
	}
	public void updatingProductAmount(int code, int amount) throws ProductDontExistException {
		List<Product> products = productDAO.findBycode(code);
		if(products.isEmpty()) {
			throw new ProductDontExistException();
		}
		products.get(0).setAmount(amount);
	}
	
	public void buyProduct(int code, int quantity) throws ProductDontExistException, NoEnoughAmountException {
		List<Product> products = productDAO.findBycode(code);
		if(products.isEmpty()) {
			throw new ProductDontExistException();
		}
		Product product = products.get(0);
		if(product.getAmount() < quantity) {
			throw new NoEnoughAmountException();
		}
		else {
			product.setAmount(product.getAmount() - quantity);
			Revenue revenue = new Revenue(product.getName(),product.getCode(),
					quantity,product.getPrice()*quantity);
			revenuesBL.save(revenue);
			productDAO.save(product);
		}
	}
	
	
	public void deleteProduct(int code) {
		productDAO.deleteBycode(code);
	}
	
	public void deleteProduct(Product product) {
		productDAO.delete(product);
	}
	
	public void deleteProductById(int id) {
		productDAO.deleteById(id);
	}
	
	public List<Product> findBycode(int code){
		return productDAO.findBycode(code);
	}

	public List<Product> findByAmountGreaterThan(int amount){
		return productDAO.findByAmountGreaterThan(amount);
	}
	public List<Product> findByAmount(int amount){
		return productDAO.findByAmount(amount);
	}

	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDAO.findAll();
	}

	public void buyProduct(Product product) throws ProductDontExistException, NoEnoughAmountException {
		List<Product> products = productDAO.findBycode(product.getCode());
		if(products.isEmpty()) {
			throw new ProductDontExistException();
		}
		Product pro = products.get(0);
		int quantity = product.getAmount();
		if(pro.getAmount() < quantity) {
			throw new NoEnoughAmountException();
		}
		else {
			pro.setAmount(pro.getAmount() - quantity);
			Revenue revenue = new Revenue(pro.getName(),pro.getCode(),
					quantity,pro.getPrice()*quantity);
			revenuesBL.save(revenue);
			productDAO.save(pro);
		}
	}

	

}
