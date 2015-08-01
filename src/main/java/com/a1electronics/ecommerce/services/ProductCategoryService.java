package com.a1electronics.ecommerce.services;

import java.util.List;
import java.util.Set;

import com.a1electronics.ecommerce.dbo.ProductCategory;
import com.a1electronics.ecommerce.dbo.Products;

public interface ProductCategoryService extends GenericService<ProductCategory, ProductCategory, Long> 
{
	
	void doNoob(String data);
	Set<Products> getProductsByCategory(int catId);
	
}