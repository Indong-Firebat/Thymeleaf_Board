package com.board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/* 
	 * @Around : target 메소드 호출 이전과 이후 모두 적용
	 * execution : 시작하는 구문은 포인트컷을 지정하는 문법
	 * 포인트컷 : 어드바이스를 적용할 조인포인트를 선별하는 과정이나 기능을 정의한 모듈
	 * 어드바이스 : 실제로 부가적인 기능을 구현한 객체
	 * 조인포인트 : 어드바이스를 적용할 위치
	 * target : 실제 비즈니스 로직을 수행하는 객체, 어드바이스를 적용할 대상
	 * 
	 * 포인트컷 설명
	 * * com.board..controller.*Controller.*(..) : com.board 패키지의 모든 하위 패키지 중 controller로 시작하는 패키지에서 xxxController와 같은 패턴의 이름을 가진 클래스에서 파라미터가 0개 이상인 메소드
	 * * com.board..service.*Impl.*(..) : com.board 패키지의 모든 하위 패키지 중 service로 시작하는 패키지에서 xxxServceImpl과 같은 패턴의 이름을 가진 클래스에서 파라미터가 0개 이상인 메서드를 의미
	 * * com.board..mapper.*Mapper.*(..) : com.board 패키지에서 모든 하위 패키지 중 mapper로 시작하는 패키지에서 xxxMapper와 같은 패턴의 이름을 가진 인터페이스에서 파라미터가 0개 이상인 메서드를 의미
	 */
	@Around("execution(* com.board..controller.*Controller.*(..)) or execution(* com.board..service.*Impl.*(..)) or execution(* com.board..mapper.*Mapper.*(..))")
	public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {

		String type = "";
		String name = joinPoint.getSignature().getDeclaringTypeName();

		if (name.contains("Controller") == true) {
			type = "Controller ===> ";

		} else if (name.contains("Service") == true) {
			type = "ServiceImpl ===> ";

		} else if (name.contains("Mapper") == true) {
			type = "Mapper ===> ";
		}

		logger.debug(type + name + "." + joinPoint.getSignature().getName() + "()");
		return joinPoint.proceed();
	}

}