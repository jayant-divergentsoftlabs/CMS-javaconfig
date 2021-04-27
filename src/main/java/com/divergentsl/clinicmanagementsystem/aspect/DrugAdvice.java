package com.divergentsl.clinicmanagementsystem.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DrugAdvice {

	private static Logger logger = LoggerFactory.getLogger(DrugAdvice.class);

	@Before("execution(* com.divergentsl.clinicmanagementsystem.dao.DrugDao.read())")
	public void beforeMethod() {
		logger.info("--------------------------------------Drug Operations---------------------------------------------");
	}

	@AfterReturning("execution(* com.divergentsl.clinicmanagementsystem.dao.DrugDao.read())")
	public void afterReturning() {
		logger.info("-------------------------------------*-----------*---------------------------------------------");
	}

}
