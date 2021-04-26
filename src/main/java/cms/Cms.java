package cms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.divergentsl.clinicmanagementsystem.ClinicManagementSystem;

public class Cms {
	private static Logger logger = LoggerFactory.getLogger(Cms.class);

	public static void main(String[] args) {
		logger.info("---*---Login Panel---*--------- ");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("dev");
		context.register(AppConfig.class);
		context.refresh();
		logger.debug("ApplicationContext:{}", context);
		ClinicManagementSystem clinicManagement = context.getBean(ClinicManagementSystem.class);
		logger.info("Property Value:{}",clinicManagement.getPropertyValue());
		logger.info("ClinicManagementSystem:{}", clinicManagement.show());
		
	}

}
