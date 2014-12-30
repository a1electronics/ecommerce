package com.a1electronics.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.a1electronics.ecommerce.dbo.ProductCategory;

public interface ProductCategoryDao extends JpaRepository <ProductCategory,Long> {
	
}
