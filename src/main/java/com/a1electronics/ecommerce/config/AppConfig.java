package com.a1electronics.ecommerce.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages={"com.a1electronics.ecommerce"},
	excludeFilters=@ComponentScan.Filter(type=FilterType.REGEX, pattern={"com.a1electronics.ecommerce.controllers.*",
																		  "com.a1electronics.ecommerce.dbo.*",
																		  "com.a1electronics.ecommerce.dao.*"
																		 }
										)
			   )
@EnableAspectJAutoProxy
public class AppConfig {
	
	 @Bean
	 public DozerBeanMapper getMapper() {
	        return new DozerBeanMapper();
	 }

	 @Bean 
	 public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer(){ 
		 return new PropertySourcesPlaceholderConfigurer(); 
	 }
	 
}
