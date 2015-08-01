package com.a1electronics.ecommerce.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( transactionManagerRef="transactionManager",
						entityManagerFactoryRef="entityManagerFactory",
						basePackages ="com.a1electronics.ecommerce.dao"
						)
@ComponentScan(basePackages = {"com.a1electronics.ecommerce.dao"})
@PropertySource(value = { "classpath:application-local.properties" })

public class PersistenceContextConfig {
	private static final Logger logger = LoggerFactory
			.getLogger(PersistenceContextConfig.class);

	@Autowired
	private Environment env;

	@Value("${init-db:false}")
	private String initDatabase;

	@Bean(name = "mainDataSource")
	public DataSource dataSource() {

		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(env.getProperty("jdbc.driverClassName"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			logger.info("PropertyVetoException : {}", e.getMessage());
		}
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		dataSource.setAcquireIncrement(20);
		dataSource.setAcquireRetryAttempts(30);
		dataSource.setAcquireRetryDelay(1000);
		dataSource.setAutoCommitOnClose(false);
		dataSource.setDebugUnreturnedConnectionStackTraces(true);
		dataSource.setIdleConnectionTestPeriod(100);
		dataSource.setInitialPoolSize(10);
		dataSource.setMaxConnectionAge(1000);
		dataSource.setMaxIdleTime(200);
		dataSource.setMaxIdleTimeExcessConnections(3600);
		dataSource.setMaxPoolSize(10);
		dataSource.setMinPoolSize(2);
		dataSource.setPreferredTestQuery("select 1");
		dataSource.setTestConnectionOnCheckin(false);
		dataSource.setUnreturnedConnectionTimeout(1000);
		return dataSource;

	}

	
	@Bean
	public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScript(new ClassPathResource(env.getProperty("jdbc.initLocation")));
		databasePopulator.addScript(new ClassPathResource(env.getProperty("jdbc.dataLocation")));
		dataSourceInitializer.setDatabasePopulator(databasePopulator);
		dataSourceInitializer.setEnabled(Boolean.parseBoolean(initDatabase));
		return dataSourceInitializer;
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPersistenceUnitName("a1ecommerceEntityManager");
		factoryBean
				.setPackagesToScan(new String[] { "com.a1electronics.ecommerce.dbo" });
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		Properties jpaProperties = new Properties();

		// Configures the used database dialect. This allows Hibernate to create
		// SQL
		// that is optimized for the used database.
		jpaProperties.put("hibernate.dialect",env.getRequiredProperty("hibernate.dialect"));


		// If the value of this property is true, Hibernate writes all SQL
		// statements to the console.
		jpaProperties.put("hibernate.show_sql",	env.getRequiredProperty("hibernate.show_sql"));

		// If the value of this property is true, Hibernate will format the SQL
		// that is written to the console.
		jpaProperties.put("hibernate.format_sql",env.getRequiredProperty("hibernate.format_sql"));
		//jpaProperties.put("hibernate.hbm2ddl.auto",env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		//To fix the followinf issue
		//HHH000424: Disabling contextual LOB creation as createClob() method threw error : java.lang.reflect.InvocationTargetException
		jpaProperties.put("hibernate.temp.use_jdbc_metadata_defaults",false);

		factoryBean.setJpaProperties(jpaProperties);
		factoryBean.afterPropertiesSet(); 
		factoryBean.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
//		factoryBean.setPersistenceUnitName(env.getRequiredProperty("persistence.unitName"));
		return factoryBean;
	}

	@Bean(name="transactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean()
				.getObject());
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
