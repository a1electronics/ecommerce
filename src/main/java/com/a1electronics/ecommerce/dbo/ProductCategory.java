package com.a1electronics.ecommerce.dbo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "ProductCategory")
public class ProductCategory extends BaseEntity{

	@Column(name = "Name")
	String categoryName;

	@Column(name = "Description")
	String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productCategory", targetEntity=Products.class, cascade={CascadeType.REMOVE})
	private Set<Products> users = new HashSet<Products>(0);
	
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

	public Set<Products> getUsers() {
		return users;
	}

	public void setUsers(Set<Products> users) {
		this.users = users;
	}
	
}
