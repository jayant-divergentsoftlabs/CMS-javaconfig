package cms;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration

@ComponentScan(basePackages = {"com.divergentsl.clinicmanagementsystem" , "com.divergentsl.clinicmanagementsystem.dao" , "com.divergentsl.clinicmanagementsystem.dto" , "com.divergentsl.clinicmanagementsystem.databaseconnection"})
@Profile("dev")
@PropertySource("classpath:/application.properties")
@EnableAspectJAutoProxy
public class AppConfig {
	@Value("${spring.datasource.url}")
	public String url;
	@Value("${spring.datasource.username}")
	public String username;
	@Value("${spring.datasource.password}")
	public String password;
	
	 @Bean
	    public DataSource mysqlDataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setUrl(url);
	        dataSource.setUsername(username);
	        dataSource.setPassword(password);
	        return dataSource;
	    }
	 
	 @Bean
	 public JdbcTemplate jdbcTemplate() {
		 return new JdbcTemplate(mysqlDataSource());
	 }



}
