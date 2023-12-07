package com.ohgiraffers.pos.menu.controller;

import com.ohgiraffers.pos.menu.dto.MenuDTO;
import com.ohgiraffers.pos.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("edit")
public class editController {

    @Autowired
    private MenuService menuService;

    @GetMapping("editPage")
    public String edit() {
        return "menu/editMenu";
    }

    @PostMapping("edit")
    public String editMenu(MenuDTO menuDTO) {
        menuService.editMenu(menuDTO);
        return "redirect:/";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) // 메뉴 수정
    public String MethodArgumentNotValidException(Model model, MethodArgumentNotValidException exception) {
        model.addAttribute("message", "메뉴 수정 필수 값 미입력");
        return "error/exception";
    }
}
