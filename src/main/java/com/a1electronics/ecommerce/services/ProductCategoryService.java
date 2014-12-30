package com.a1electronics.ecommerce.services;

import com.a1electronics.ecommerce.dbo.ProductCategory;

public interface ProductCategoryService extends GenericService<ProductCategory, ProductCategory, Long> 
{
	void doNoob(String data);
}