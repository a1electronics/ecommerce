package com.a1electronics.ecommerce.dbo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "ProductCategory")
public class ProductCategory extends BaseEntity{

	@Column(name = "Name")
	String categoryName;

	@Column(name = "Description")
	String description;
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productCategory", targetEntity=Products.class, cascade={CascadeType.REMOVE})
	private Set<Products> products = new HashSet<Products>(0);
	
	public ProductCategory(){
		super();
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Products> getProducts() {
		return products;
	}

	public void setProducts(Set<Products> users) {
		this.products = users;
	}
	
}
