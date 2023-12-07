package com.ohgiraffers.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {

    @GetMapping("controller-null")
    public String nullPointerExceptionTest() {
        String str = null;
        System.out.println(str.charAt(0)); // 여기서 에러가 발생해서 return이 실행 안됨..
        return "/main";
    }

    @ExceptionHandler(NullPointerException.class) // 컨트롤러 안에 작성하면 이 메소드가 먼저 Exception을 처리한다. // 상황에 따라 작성 위치 정해야함
    public String nullPointerExceptionHandler(NullPointerException e) {
        System.out.println("controller 레벨의 Exception 처리");
        return "error/nullPointer";
    }



    @GetMapping("controller-user")
    public String userException() throws MemberRegistException {
        boolean check = true;
        if (check) {
            throw new MemberRegistException("입사가 불가능합니다.");
        }
        return "/";
    }
}
