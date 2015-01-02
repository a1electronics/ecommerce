package com.a1electronics.ecommerce.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.a1electronics.ecommerce.dbo.Products;
import com.a1electronics.ecommerce.services.ProductsService;

@Service("productsService")
public class ProductsServiceImpl extends GenericServiceImpl<Products, Products, Long> implements ProductsService {
	private static final Logger log = (Logger) LoggerFactory.getLogger(ProductsServiceImpl.class);
}
