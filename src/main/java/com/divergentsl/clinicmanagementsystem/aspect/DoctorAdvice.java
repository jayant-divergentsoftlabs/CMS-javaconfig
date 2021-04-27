package com.divergentsl.clinicmanagementsystem.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DoctorAdvice {
	private static Logger logger = LoggerFactory.getLogger(DoctorAdvice.class);

	@Before("execution(* com.divergentsl.clinicmanagementsystem.dao.DoctorDao.*(..))")
	public void beforeMethod() {
		logger.info("--------------------------------------Doctor Operation---------------------------------------------");
	}

	@AfterReturning("execution(* com.divergentsl.clinicmanagementsystem.dao.DoctorDao.*(..))")
	public void afterReturning() {
		logger.info("-------------------------------------*-----------*---------------------------------------------");
	}

}
