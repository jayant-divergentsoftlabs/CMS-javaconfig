package com.divergentsl.clinicmanagementsystem.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LabtestAdvice {

	private static Logger logger = LoggerFactory.getLogger(LabtestAdvice.class);
	@Before("execution(* com.divergentsl.clinicmanagementsystem.dao.LabtestDao.read())")
	public void beforeMethod() {
		logger.info("--------------------------------------Test Operations---------------------------------------------");
	}
	@AfterReturning("execution(* com.divergentsl.clinicmanagementsystem.dao.LabtestDao.read())")
	public void afterReturning() {
		logger.info("-------------------------------------*-----------*---------------------------------------------");
	}
}
