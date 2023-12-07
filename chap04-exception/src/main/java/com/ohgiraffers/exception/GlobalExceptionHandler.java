package com.ohgiraffers.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // 컨트롤러에서 문제가 발생시 안에서 이 클래스에서 해결..
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException e) {
        System.out.println("Global 레벨의 Exception 처리");
        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(Model model, MemberRegistException exception) {
        System.out.println("Global 레벨의 exception 처리");
        model.addAttribute("exception", exception);
        return "error/memberRegist";
    }
    /*@ExceptionHandler (MemberRegistException. class)
    public String MemberRegistExceptionHandler (MemberRegistException e) {
        System.out.println("controller 레벨의 Exception 처리");
        return "error/memberRegist";
    }*/



    @ExceptionHandler(Exception.class)
    public String nullPointerExceptionHandler(Exception e) {
        System.out.println(e.getClass());
        System.out.println("exception 발생함");
        return "error/default";
    }
}
