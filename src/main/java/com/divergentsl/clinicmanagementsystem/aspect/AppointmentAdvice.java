package com.divergentsl.clinicmanagementsystem.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AppointmentAdvice {
	private static Logger logger = LoggerFactory.getLogger(AppointmentAdvice.class);

	@Before("execution(* com.divergentsl.clinicmanagementsystem.dao.AppointmentDao.*(..))")
	public void beforeMethod() {
		logger.info("--------------------------------------Appointment Operation---------------------------------------------");
	}

	@AfterReturning("execution(* com.divergentsl.clinicmanagementsystem.dao.AppointmentDao.*(..))")
	public void afterReturning() {
		logger.info("-------------------------------------*-----------*---------------------------------------------");
	}
	

}
