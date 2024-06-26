package pojo;

import java.util.Date;

public class PlaceOrder {
	
	boolean isadult;
	private int id;
	private int typeid;
	private int quantity;
	private String name;
	private String email;
	private double price;
	private Date date;
	
	public boolean isIsadult() {
		return isadult;
	}
	public void setIsadult(boolean isadult) {
		this.isadult = isadult;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double d) {
		this.price = d;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {  
        this.date = date;
    }
	

}
