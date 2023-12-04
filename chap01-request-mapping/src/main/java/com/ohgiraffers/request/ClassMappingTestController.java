package com.ohgiraffers.request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //사용자의 요청을 받아주는 서블릿 //=WebServlet(?)
/*
* Controller의 역할 : 해당 클래스를 Controller로 사용한다고 Spring FrameWork에 알린다.
*                   필요한 비즈니스 로직을 호출하여 전달할 모델(Model)과 이동할 뷰(View) 정보를 Dispatcher Servlet에 반환한다.
* Bean으로 등록
* @Component의 구체화 된 어노테이션
* */
@RequestMapping("/order/*")
/*
* 요청에 대해 어떤 Controller, 어떤 메소드가 처리할지 맵핑하기 위한 어노테이션
* 클래스나 메서드 선언부에 @RequestMapping과 함께 URL을 명시하여 사용한다.
* viewName 생략시 @RequestMapping의 path로 설정한 URL이 default viewName 이다.
* */
// @RestController //사용자의 요청에 뷰를 생성하지 않고 데이터만 보냄 (화면이 필요 없음)
public class ClassMappingTestController {

    /*
    * @RequestMapping의 속성들
    * 1. value(String[]) : URL 값
    * 2. method(RequestMethod[]) : HTTP Request 메소드 값 (GET, POST, HEAD, OPTIONS, PUT, DELETE, TRACE)
    * 3. params(String[]) : HTTP Request 파라미터
    *   3-1. @RequestParam : 사용자가 원하는 매개변수에 값을 매핑하기 위해 사용한다.
    *   3-2. @PathVariable : URL 경로를 변수화하여 사용할 수 있도록 해준다.
    * 4. consumes(String[]) : Request Body에 담는 타입을 제한할 수 있다. (잘 사용하지 않는다고 한다..?)
    * */

    // port : 80 = web
    // port : 8080 = was server
    // port : 443 = https server

    // GET : localhost:8080/order/regist 요청들어오면 매핑해줌
    @GetMapping("/regist")
    public String registOrder(Model model) {
        model.addAttribute("message", "GET 방식의 주문 등록용 핸들러 메소드 호출");

        return "mappingResult";
    }

    @RequestMapping(value = {"modify", "delete"}, method = RequestMethod.POST)
    public String modifyAndDelete(Model model) {
        model.addAttribute("message", "post 방식의 주문 정보 수정과 주문 정보 삭제 공통 처리용 핸들러");
        return "mappingResult";
    }

    /*
    * 3. Path Variable
    * @PathVariable 어노테이션을 이용해 요청을 path로부터 변수를 받아올 수 있다.
    * path variable로 전달 되는 {변수명} 값은 반드시 매개변수명과 동일해야한다.
    * 만약 동일하지 않으면 @PathVariable("이름")을 설정해주어야 한다.
    * 이는 rest형 웹 서비스를 설계할 때 유용하게 사용된다.
    *
    * 인텔리제이의 builder 설정을 Intellij로 했을 경우에는 @PathVariable에 이름을 지정해주지 않으면 찾지 못한다.
    * */
    // 3 = orderNo
    @GetMapping("/detail/{orderNo}")
    public String selectOrderDetail(Model model, @PathVariable("orderNo") int orderNo) {
        model.addAttribute("message", orderNo + "번 주문 상세 내용 조회용 핸들러 메소드 호출");
        return "mappingResult";
    }

    @RequestMapping
    public String otherRequest(Model model) {
        model.addAttribute("message", "order 요청이긴 하지만 다른 기능이 준비되지 않음");
        return "mappingResult";
    }
}
