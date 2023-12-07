package com.ohgiraffers.pos.menu.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class) // 메뉴 확인
    public String nullPointerExceptionHandler(Model model, NullPointerException exception) {
        model.addAttribute("message", "메뉴 조회 중 에러 발생");

        return "error/exception";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) // 메뉴 추가
    public String MethodArgumentNotValidException(Model model, MethodArgumentNotValidException exception) {
        model.addAttribute("message", "메뉴 추가 필수 값 미입력");
        return "error/exception";
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class) // 메뉴 삭제
    public String MethodArgumentTypeMismatchException(Model model, MethodArgumentTypeMismatchException exception) {

        model.addAttribute("message", "메뉴 삭제 필수 값 미입력");

        return "error/exception";
    }


}
