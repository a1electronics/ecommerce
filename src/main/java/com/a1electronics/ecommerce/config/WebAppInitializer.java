package com.a1electronics.ecommerce.config;

/*
import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import ch.qos.logback.classic.helpers.MDCInsertingServletFilter;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebMvcSpringConfig.class, PersistenceContextConfig.class};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        
        OpenEntityManagerInViewFilter viewFilter = new OpenEntityManagerInViewFilter();
        viewFilter.setEntityManagerFactoryBeanName("entityManagerFactory");
        MDCInsertingServletFilter mdcInsertingServletFilter= new  MDCInsertingServletFilter();
        return new Filter[] {characterEncodingFilter,mdcInsertingServletFilter,viewFilter};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("defaultHtmlEscape", "true");
        registration.setInitParameter("spring.profiles.active", "default");
    }
    
    }
*/


import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		// TODO Auto-generated method stub
		 
		WebApplicationContext context = getContext();
		
		
		servletContext.addListener(new ContextLoaderListener(context));
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
				"a1ecommerce", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		dispatcher.setAsyncSupported(true);
		
		
		servletContext.addFilter("HttpMethodFilter", org.springframework.web.filter.HiddenHttpMethodFilter.class).addMappingForUrlPatterns(null, false, "/");
		FilterRegistration charEncodingfilterReg = servletContext.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
		charEncodingfilterReg.setInitParameter("encoding", "UTF-8");
		charEncodingfilterReg.setInitParameter("forceEncoding", "true");
		charEncodingfilterReg.addMappingForUrlPatterns(null, false, "/");
		
		servletContext.addFilter("MDCInsertFilter",ch.qos.logback.classic.helpers.MDCInsertingServletFilter.class).addMappingForUrlPatterns(null, false, "/*");
		servletContext.addFilter("Spring OpenEntityManagerInViewFilter", org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter.class)
				.addMappingForUrlPatterns(null, false, "/*");
		
		servletContext.addServlet("ViewStatusMessages",ch.qos.logback.classic.ViewStatusMessagesServlet.class).addMapping("/lg/*");
		
	}

	private AnnotationConfigWebApplicationContext getContext() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation("com.a1electronics.ecommerce.config");
		return context;
	}
}
