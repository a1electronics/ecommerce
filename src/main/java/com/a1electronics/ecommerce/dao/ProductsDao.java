package com.a1electronics.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.a1electronics.ecommerce.dbo.Products;

public interface ProductsDao extends JpaRepository<Products, Long>  {

}
