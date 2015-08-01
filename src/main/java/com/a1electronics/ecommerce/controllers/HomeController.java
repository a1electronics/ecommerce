package com.a1electronics.ecommerce.controllers;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.a1electronics.ecommerce.dbo.ProductCategory;
import com.a1electronics.ecommerce.dbo.Products;
import com.a1electronics.ecommerce.services.ProductCategoryService;
import com.a1electronics.ecommerce.services.ProductsService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	ProductCategoryService productCategoryService;
	ProductsService productsService;
	
	
    @Autowired
	public HomeController(ProductCategoryService productCategoryService , ProductsService productsService){
		this.productCategoryService=productCategoryService;
		this.productsService=productsService;
	}
	
	/**
	 * Home Page.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("In home");
		return "home";
	}
	
	@RequestMapping(value = "/pdc", method = RequestMethod.GET)
	@ResponseBody
	public List<Products> getProductCategoryAll(){
		Products product=  new Products();
		product.setProductName("Sony Tape Recorder+2");
		product.setPrice(1000);
		product.setQuantity(100000);
		product.setProductCategory(productCategoryService.findById(1L));
		product=productsService.create(product);
		product=productsService.findById(product.getId());
		product.setProductName("Edited Name");
		productsService.update(product, product.getId());
		productsService.delete(product.getId());
		return productsService.findAll();
	}
	
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductCategory> getAllCategories(){
		return productCategoryService.findAll();
	}
	
	@RequestMapping (value = "/products/{catId}", method = RequestMethod.GET)
	@ResponseBody
	public Set<Products> getProductsInCategory(@PathVariable("catId") int catId){
		//return productCategoryService.
		return productCategoryService.getProductsByCategory(catId);
	}
	
	@RequestMapping (value = "/product/{productId}", method = RequestMethod.GET)
	@ResponseBody
	public Products getProductsInCategory(@PathVariable("productId") long productId){
		//return productCategoryService.
		return productsService.findById(productId);
	}
}
