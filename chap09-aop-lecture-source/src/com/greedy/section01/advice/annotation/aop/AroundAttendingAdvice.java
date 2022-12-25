package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.greedy.section01.advice.annotation.GreedyStudent;

@Aspect
@Component
public class AroundAttendingAdvice {

	/* Around Advice
	 * 
	 * 가장 강력한 어드바이스 
	 * 
	 * 해당 어드바이스는 조인포인트를 완전히 장악하기 때문에
	 * 앞에 살펴본 어드바이스 모두 Around 어드바이스로 조합할 수 있다.
	 * 심지어 원본 조인포인트를 언제 실행할지, 실행자체를 안할지, 계속 실횅할지 여부까지도 제어한다.
	 * 
	 * AroundAdvice의 조인포인트 매개변수는 ProceedingJoinPoint로 고정되어있다.
	 * 
	 * JoinPoint의 하위 인터페이스로 원본 조인포인트의 진행시점을 제어할 수 있다.
	 * 조인포인트 진행하는 호출을 잊는 경우가 자주 발생하기 때문에 주의해야하며
	 * 최소한의 요건을 충족하면서 가장 기능이 약한 어드바이스를 쓰는게 바람직하다
	 * */
	
	@Around("execution(* com.greedy.section01.advice.annotation..*(..))")
	public Object aroundAttending(ProceedingJoinPoint joinPoint) throws Throwable {
	
		System.out.println("================== around attending before =======================");
		System.out.println("오늘도 학원에 가서 열심히 공부해야지!! 라는 마음으로 아침 일찍 일어납니다.");
		System.out.println("===================================================================");
		
		/* 공부 시간을 체크하기 위해 스탑워치를 켠다. */
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object result = joinPoint.proceed(); // 원본 조인포인트를 실행
		
		System.out.println("================= around atteding after ==============================");
		
		/* 만약에 Greedy학생이면 학원 문이 닫을 때 까지 열심히 스터디를 합니다. */
		if(joinPoint.getTarget() instanceof GreedyStudent) {
			
			System.out.println("수업이 끝나도 학원이 닫을 떄 까지는 끝난게 아니다. 자율적 스터디 그룹과 함꼐 다시 공부합니다!!");
		}
		
		System.out.println("열심히 공부했으니 퇴실카드를 찍는다.");
		
		stopWatch.stop();
		
		System.out.println("총 공부 소요 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)");
		System.out.println("========================================================================");
		
		return result;
	}
}
