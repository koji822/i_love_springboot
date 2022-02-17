package jp.co.commerce21.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class AccessMonitor {

	@Before("execution(* jp.co.commerce21.controller.*.*(..))")
	public void bfControllerLog(final JoinPoint jp) {	
//		final Logger logger = LogManager.getLogger(jp.getTarget().getClass());	
//		String cn = jp.getTarget().getClass().getSimpleName();
//		String mn = jp.getSignature().getName();	
//		logger.info("##  @Before " + cn + "." + mn + " ##");
	
		log.info("#### メソッド開始:" + jp.getSignature());
	}
	
	@After("execution(* jp.co.commerce21.controller.*.*(..))")
	public void afControllerLog(final JoinPoint jp) {
		log.info("#### メソッド終了:" + jp.getSignature());
	}
	
	@Before("execution(* jp.co.commerce21.service.*.*(..))")
	public void bfServiceLog(final JoinPoint jp) {
		log.info("#### メソッド開始:" + jp.getSignature());
	}
	
	@After("execution(* jp.co.commerce21.service.*.*(..))")
	public void afserviceLog(final JoinPoint jp) {
		log.info("#### メソッド終了:" + jp.getSignature());
	}
	
	@Before("execution(* jp.co.commerce21.dao.*.*(..))")
	public void bfDaoLog(final JoinPoint jp) {
		log.info("#### メソッド開始:" + jp.getSignature());
	}
	
	@After("execution(* jp.co.commerce21.dao.*.*(..))")
	public void afDaoLog(final JoinPoint jp) {
		log.info("#### メソッド終了:" + jp.getSignature());
	}
}
