package ua.test.wicket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import ua.test.wicket.dao.UsersDao;
import ua.test.wicket.dao.UsersDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan("ua.test.wicket")
public class WebMvcConfig {
	
	String url = "jdbc:postgresql://localhost:5432/postgres";
	String userName = "postgres";
	String userPass = "123";
	
	@Bean
	InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Bean
	DriverManagerDataSource getDataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl(url);
		ds.setUsername(userName);
		ds.setPassword(userPass);

		return ds;
	} 
	
	@Bean
	public UsersDao getUserDao() {
		return new UsersDaoImpl(getDataSource());
	}

}
