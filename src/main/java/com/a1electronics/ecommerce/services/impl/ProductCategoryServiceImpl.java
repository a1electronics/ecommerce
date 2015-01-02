package com.a1electronics.ecommerce.services.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.a1electronics.ecommerce.dbo.ProductCategory;
import com.a1electronics.ecommerce.services.ProductCategoryService;

@Service("productCategoryService")
public class ProductCategoryServiceImpl extends GenericServiceImpl<ProductCategory, ProductCategory, Long> implements ProductCategoryService{

	private static final Logger log = (Logger) LoggerFactory.getLogger(ProductCategoryServiceImpl.class);
	

	@Override
	public void doNoob(String data) {
		// TODO Auto-generated method stub
		
	}

	
}
