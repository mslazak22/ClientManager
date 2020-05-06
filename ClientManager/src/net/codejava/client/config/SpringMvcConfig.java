package net.codejava.client.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import net.codejava.client.dao.ClientDAO;
import net.codejava.client.dao.ClientDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "net.codejava.client")
public class SpringMvcConfig implements WebMvcConfigurer {
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/clientsdb");
		dataSource.setUsername("root");
		dataSource.setPassword("yourpassword");
		
		return dataSource;
	}
	@Bean
	public ViewResolver getViewResolve() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	@Bean
	public ClientDAO getClientDAO() {
		return new ClientDAOImpl(getDataSource());
	}
	
	
	
	
	
}
