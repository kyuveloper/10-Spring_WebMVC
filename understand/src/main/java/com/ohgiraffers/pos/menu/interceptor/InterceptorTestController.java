package com.ohgiraffers.pos.menu.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class InterceptorTestController {

    @PostMapping("auth")
    public String handlerMethod() {
        System.out.println("핸들러 메소드 호출");
        return "result";
    }
}
