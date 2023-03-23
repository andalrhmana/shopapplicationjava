package org.tsofen.Shopapplcation.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tsofen.Shopapplcation.Bean.Product;

public interface ProductDAO extends JpaRepository<Product, Integer>{
	public List<Product> findBycode(int code);
	public void deleteBycode(int code);
	public List<Product> findByAmountGreaterThan(int amount);
	public List<Product> findByAmount(int amount);
}
