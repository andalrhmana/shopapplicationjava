package org.tsofen.Shopapplcation.Bean;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private String image;
	
    private String name;
    
    private int code;
    
    private int amount;
    
    private float price;
   
    
    public Product() {
    	
    }
    
    
    
    
    public Product(String image, String name, int code, int amount, float price) {
    	this.image = image;
    	
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






	public Product clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Product) super.clone();
	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}


}
