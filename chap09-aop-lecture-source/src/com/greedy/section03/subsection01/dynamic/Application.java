package com.greedy.section03.subsection01.dynamic;

import java.lang.reflect.Proxy;

public class Application {

	public static void main(String[] args) {
		
		/* 프록시(Proxy)란 
		 * 실제 Target의 기능을 수행하면서 기능을 확장하거나 추가하는 실제 객체를 의미한다.
		 * --> 디자인패턴의 프록시 패턴과는 조금 다른 개념이긴하다.
		 * 
		 * 여러분이 실제 응용 프로그램을 만들 시에 프록시를 직접 기능을 구현할 일은 없다!!!!
		 * 그래서 프록시는 통해 대상의 요청을 가로채 기능을 확장시킬 목적으로 사용한다.
		 * */
		
		/* 프록시 생성은 크게 두가지 방식 제공
		 * 1. JDK Dynamic Proxy 방식
		 * 2. CGLib방식
		 * 
		 * Aspectj에서 사용하는 프록시 생성은 1번 방식
		 * 
		 * 1번 방식은 리플렉션을 이용해서 proxy클래스를 동적으로 생성해주는 방식이며, 타겟의 인터페이스를 기준으로 proxy를 생성해준다.
		 * 사용자의 요청이 타겟을 바라보고 실행될 수 있도록 타겟 자체에 대한 코드 수정이 아닌 리플렉션을 이용한 방식으로 타겟의
		 * 위임코드를 InvocationHandler를 이용하여 작성하게된다.
		 * -> 사용자가 타겟에 대한 정보를 잘못 주입하는 경우가 발생할 수 있기 때문에 내부적으로 주입된 타겟에 대한 검증 코드를 거친 후
		 *    invoke가 동작하게 된다.
		 * */
		
		Student student = new GreedyStudent();
		Handler handler = new Handler(student);
		
		// 클래스로더, 프록시를 만들 클래스 메타정보(인터페이스만 가능), 프록시 동작할 때 적용될 핸들러 
		Student proxy = (Student) Proxy.newProxyInstance(
							Student.class.getClassLoader(), new Class[] {Student.class}, handler);
		
		// 프록시로 감싸진 인스턴스의 메소드를 호출하게되면 핸들러에 정의한 메소드가 호출
		proxy.study(16);
	}
}
