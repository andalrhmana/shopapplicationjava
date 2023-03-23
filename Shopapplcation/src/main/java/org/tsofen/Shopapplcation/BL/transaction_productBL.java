package org.tsofen.Shopapplcation.BL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsofen.Shopapplcation.Bean.transaction_product;
import org.tsofen.Shopapplcation.DAO.transaction_productDAO;

@Service
public class transaction_productBL {
	
	@Autowired
	transaction_productDAO tran_prDAO;

	public void save(transaction_product newproduct) {
		tran_prDAO.save(newproduct);
		
	}

}
