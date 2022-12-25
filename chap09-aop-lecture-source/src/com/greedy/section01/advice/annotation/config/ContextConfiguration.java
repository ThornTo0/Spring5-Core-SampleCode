package com.greedy.section01.advice.annotation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/* proxyTargetClass = true 설정은 cglib를 이용한 프록시를 생성하는 방식
 * spring 3.2부터 스프링프레임워크에 포함되어 별도 라이브러리 설정을 하지 않아도 사용할 수 있다.
 * 
 * 성능면에서 더 우수하다.
 * */

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ContextConfiguration {

}
