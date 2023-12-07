package com.ohgiraffers.pos.menu.controller;

import com.ohgiraffers.pos.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Controller
@RequestMapping("delete")
public class deleteController {

    @Autowired
    private MenuService menuService;

    @GetMapping("deletePage")
    public String delete() {
        return "menu/deleteMenu";
    }

    @PostMapping("delete")
    public String deleteMenu(@RequestParam(required = false) int code, @RequestParam(required = false) String name) {
        menuService.deleteMenu(code, name);

        return "redirect:/";
    }
}
