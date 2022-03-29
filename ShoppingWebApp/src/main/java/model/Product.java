package model;

import java.util.Objects;

public class Product {

	 String name;
	float price;
	int units;
	String category;
	int id;
	
	public Product()
	{
	      super();	
	}
	public Product(String name, float price, int units, String category) {
		super();
		this.name = name;
		this.price = price;
		this.units = units;
		this.category = category;
		
	}
	public Product(String name, float price, int units, String category,int id) {
		super();
		this.name = name;
		this.price = price;
		this.units = units;
		this.category = category;
		this.id=id;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getUnits() {
		return units;
	}


	public void setUnits(int units) {
		this.units = units;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public int hashCode() {
		return Objects.hash(category, id, name, price, units);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && id == other.id && Objects.equals(name, other.name)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price) && units == other.units;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", units=" + units + ", category=" + category + ", id="
				+ id + "]";
	}
	


	

}
