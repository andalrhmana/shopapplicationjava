package org.tsofen.Shopapplcation.Bean;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class transaction {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
    private String date;
    
    @ManyToMany 
    private List<transaction_product> products = new LinkedList<>();
    
    private int count = 0;
    
    private float sumtransaction;
    
    
    public transaction() {
    	
    }

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<transaction_product> getProducts() {
		return products;
	}

	public void addProducts(transaction_product product) {
		this.products.add(product);
		count++;
	}

	public float getSumtransaction() {
		return sumtransaction;
	}

	public void setSumtransaction(float sumtransaction) {
		this.sumtransaction = sumtransaction;
	}
	
	@Override
    public String toString() {
		String s = "transaction{" +
                "id=" + id +
                ", Date='" + date + ", productsintransaction= [";
		for(int i = 0;i < count; i++) {
			s += this.products.get(i).toString();
		}
		s+= "], profitsofthetransaction=" + sumtransaction +
                '}';
		
        return s;
    }

}
