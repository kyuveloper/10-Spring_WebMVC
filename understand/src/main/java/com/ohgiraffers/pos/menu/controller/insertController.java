package com.ohgiraffers.pos.menu.controller;

import com.ohgiraffers.pos.menu.dto.MenuDTO;
import com.ohgiraffers.pos.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("insert")
public class insertController {

    @Autowired
    private MenuService menuService;

    @GetMapping("insertPage")
    public String insert() {
        return "menu/insertMenu";
    }

    @PostMapping("insert")
    public String insertMenu(MenuDTO menuDTO) {
        menuService.insertMenu(menuDTO);

        return "result";
    }

}

