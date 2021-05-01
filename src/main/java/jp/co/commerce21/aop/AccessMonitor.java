package jp.co.commerce21.aop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccessMonitor {

	@Before("execution(* jp.co.commerce21.controller.*.*(..))")
	public void bfControllerLog(final JoinPoint jp) {
		
		final Logger logger = LogManager.getLogger(jp.getTarget().getClass());		
//		final Logger logger = Logger.getLogger(jp.getTarget().getClass());
		
		String cn = jp.getTarget().getClass().getSimpleName();
		String mn = jp.getSignature().getName();	
		logger.info("##  @Before " + cn + "." + mn + " ##");
	}
	
	@After("execution(* jp.co.commerce21.controller.*.*(..))")
	public void afControllerLog(final JoinPoint jp) {
		final Logger logger = LogManager.getLogger(jp.getTarget().getClass());
		
		String cn = jp.getTarget().getClass().getSimpleName();
		String mn = jp.getSignature().getName();	
		logger.info("##  @After " + cn + "." + mn + " ##");
	}
	
	@Before("execution(* jp.co.commerce21.service.*.*(..))")
	public void bfServiceLog(final JoinPoint jp) {
		final Logger logger = LogManager.getLogger(jp.getTarget().getClass());
		
		String cn = jp.getTarget().getClass().getSimpleName();
		String mn = jp.getSignature().getName();	
		logger.info("##  @Before " + cn + "." + mn + " ##");
	}
	
	@After("execution(* jp.co.commerce21.service.*.*(..))")
	public void afserviceLog(final JoinPoint jp) {
		final Logger logger = LogManager.getLogger(jp.getTarget().getClass());
		
		String cn = jp.getTarget().getClass().getSimpleName();
		String mn = jp.getSignature().getName();	
		logger.info("##  @After " + cn + "." + mn + " ##");
	}
	
	@Before("execution(* jp.co.commerce21.dao.*.*(..))")
	public void bfDaoLog(final JoinPoint jp) {
		final Logger logger = LogManager.getLogger(jp.getTarget().getClass());
		
		String cn = jp.getTarget().getClass().getSimpleName();
		String mn = jp.getSignature().getName();	
		logger.info("##  @Before " + cn + "." + mn + " ##");
	}
	
	@After("execution(* jp.co.commerce21.dao.*.*(..))")
	public void afDaoLog(final JoinPoint jp) {
		final Logger logger = LogManager.getLogger(jp.getTarget().getClass());
		
		String cn = jp.getTarget().getClass().getSimpleName();
		String mn = jp.getSignature().getName();	
		logger.info("##  @After " + cn + "." + mn + " ##");
	}
}
