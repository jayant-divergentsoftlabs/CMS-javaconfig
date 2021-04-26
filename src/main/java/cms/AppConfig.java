package cms;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.divergentsl.clinicmanagementsystem" , "com.divergentsl.clinicmanagementsystem.dao" , "com.divergentsl.clinicmanagementsystem.dto" , "com.divergentsl.clinicmanagementsystem.databaseconnection"})
@Profile("dev")
@PropertySource("classpath:/application.properties")
public class AppConfig {
 


}
