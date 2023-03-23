package org.tsofen.Shopapplcation.BL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsofen.Shopapplcation.Bean.Revenue;
import org.tsofen.Shopapplcation.DAO.RevenueDAO;

@Service
public class RevenueBL {
	@Autowired
	RevenueDAO revenuesDAO;

	public List<Revenue> findAll() {
		// TODO Auto-generated method stub
		return revenuesDAO.findAll();
	}

	public void save(Revenue revenue) {
		// TODO Auto-generated method stub
		revenuesDAO.save(revenue);
	}
}
