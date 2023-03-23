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
@Table(name = "transaction_Products")
public class transaction_product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
    private String name;
    
    private int code;
    
    private int amount;
    
    private float price;
    
    @ManyToMany
    private List<transaction> tran = new LinkedList<>();
    
    public transaction_product() {
    	
    }
    
    
    
    
    public transaction_product(String name, int code, int amount, float price) {
    	this.name = name;
	    
	    this.code = code;
	    
	    this.amount = amount;
	    
	    this.price = price;
	}




	public int getId() {
    	return id;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void addtran(transaction e){
		tran.add(e);
	}
	
	@Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }


}
