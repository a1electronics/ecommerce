package com.a1electronics.ecommerce.dbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "Products")


public class Products extends BaseEntity{
	@Column(name = "Name")
	String productName;
	
	@Column(name = "Description")
	String description;
	
	@Column (name="Quantity")
	Integer quantity;
	
	@Column (name="Price")
	Integer price;
	
	@Column (name="ImagePath")
	String imagePath;

	@JsonBackReference
	@ManyToOne(fetch= FetchType.LAZY)
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


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
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
