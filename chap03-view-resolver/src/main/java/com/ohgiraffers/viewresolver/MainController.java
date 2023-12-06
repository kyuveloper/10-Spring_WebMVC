package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = {"/","/main"}) // value를 가진 주소를 main.html로 보내
    public String main(){
        return "main";
    }
}
