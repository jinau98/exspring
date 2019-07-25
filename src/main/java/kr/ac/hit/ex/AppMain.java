package kr.ac.hit.ex;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
//		App app = new App();
//		app.act();
		
//		ApplicationContext == BeanContainer == 스프링의 실체
//		: 설정파일에 등록된 자바 클래스의 객체를 생성하여 보관하는 컨테이너
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/kr/ac/hit/ex/context.xml");
		App app = (App)context.getBean("a");
		app.act();
//		규모가 커질 수록 더 편리
	}
}
