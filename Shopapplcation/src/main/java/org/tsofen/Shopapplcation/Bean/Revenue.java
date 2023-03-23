package org.tsofen.Shopapplcation.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Revenues")
public class Revenue {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
    private String name;
    
    private int code;
    
    private int amount;
    
    private float revenueprofit;

    public Revenue() {
    	
    }
    
    
	public Revenue(String name, int code, int amount, float revenueprofit) {
		this.name = name;
	    
	    this.code = code;
	    
	    this.amount = amount;
	    
	    this.revenueprofit = revenueprofit;
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

	public float getRevenueprofit() {
		return revenueprofit;
	}

	public void setRevenueprofit(float revenueprofit) {
		this.revenueprofit = revenueprofit;
	}
	
	@Override
    public String toString() {
        return "Revenue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", amount=" + amount +
                ", revenueprofit=" + revenueprofit +
                '}';
    }

}
