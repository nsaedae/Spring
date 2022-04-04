package kr.co.ch03.study;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class LogAdvice {

	@Pointcut("execution(* kr.co.ch03.study.PointService.insert*(..))")
	public void insertPointcut() {} // 내용이 없는 참조메서드
	
	
	@Before("insertPointcut()")
	public void beforeAdvice() {
		System.out.println("횡단관심 - beforeAdvice...");
	}
	
	
	@After("insertPointcut()")
	public void afterAdvice() {
		System.out.println("횡단관심 - afterAdvice...");
	}
	
}
