package org.blog.advice;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component("loggerAdvice")
public class LoggerAdvice {
	// log4j日志类

	Logger logger = Logger.getLogger("LoggerAdvice.class");

	//通过日志记录每个方法调用的时间、参数和返回值
	@AfterReturning(pointcut = "execution(* org.blog.service..*.*(..))", returning = "ret")
	public void afterReturning(JoinPoint join, Object ret) {
		String method = join.getSignature().getName();
		Object[] args = join.getArgs();
		logger.info("调用方法:" + method + ",方法参数:" + Arrays.toString(args)
				+ ",返回值:" + ret);
	}
}
