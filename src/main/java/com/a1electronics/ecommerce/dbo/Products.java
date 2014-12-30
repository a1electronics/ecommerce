package com.a1electronics.ecommerce.dbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "Products")


public class Products extends BaseEntity{
	@Column(name = "Name")
	String productName;
	
	@Column(name = "Description")
	String description;
	
	@Column (name="Quantity")
	String quantity;
	
	@Column (name="Price")
	Integer price;
	
	@Column (name="ImagePath")
	String imagePath;

	
	@ManyToOne
	@JoinColumn(name="ProductCategoryToProducts",nullable=false)
	private ProductCategory productCategory;

   public Products(){
	   super();
   }
	
	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public ProductCategory getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	} 

	
}
