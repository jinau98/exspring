package kr.ac.hit.myapp;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	@RequestMapping("/test/a.do")
	public String aaa() {
		return "test";
	}

	@RequestMapping("/test/c.do")
	public String bbb(int x, @RequestParam("y")int b, Map m) {		
		//원래는 @RequestParam("name")String name이 정석이지만 변수명과 파라미터가 같은 경우 생략할 수 있다.
		//변수 타입에 맞게 자동으로 형변환도 된다. (String으로 넘어와도 int로 받고 싶으면 int로 넣어주면 됨)
		System.out.println(x);
		System.out.println(b);
		int sum = x+b;
//		컨트롤러 메서드의 인자로 Map, Model, ModelMap 타입의 변수를 선언하고,
//		해당 Map, Model, ModelMap 변수에 데이터를 저장하여 JSP에 전달 가능
		
//		JSP 파일로 저장할 데이터를 담는 모델에 "total"이라는 이름으로 sum을 저장
//		JSP 파일에서 ${total} 표현으로 sum 값 사용 가능
		m.put("total", sum);
		return "result";
	}

	@RequestMapping("/test/b.do")
	public String ccc(@ModelAttribute("pointVo") PointVo vo, Map m) {
//		사용자가 정의한 클래스 타입의 인자를 선언하면, 스프링이 메서드를 실행할 때 해당 클래스의 객체를 생성하고, 객체의 속성(변수)명과 동일한 이름의 파라미터 값을 저장하여 전달해준다.
		int sum = vo.getX()+vo.getY();
//		컨트롤러 메서드의 인자로 Map, Model, ModelMap 타입의 변수를 선언하고,
//		해당 Map, Model, ModelMap 변수에 데이터를 저장하여 JSP에 전달 가능
		
//		JSP 파일로 저장할 데이터를 담는 모델에 "total"이라는 이름으로 sum을 저장
//		JSP 파일에서 ${total} 표현으로 sum 값 사용 가능
		m.put("total", sum);
		return "result";
	}
}
