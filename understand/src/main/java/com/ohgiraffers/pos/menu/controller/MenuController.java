package com.ohgiraffers.pos.menu.controller;

import com.ohgiraffers.pos.menu.dto.MenuDTO;
import com.ohgiraffers.pos.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller // 사용자 요청 받아주는 공간
@RequestMapping("menus")
public class MenuController {

    @Autowired //
    private MenuService menuService;

    @GetMapping
    public ModelAndView selectAllMenu(ModelAndView mv) {
        List<MenuDTO> menus = menuService.selectAllMenu();
        // 에러 만들기
        /*menus = null;
        System.out.println(menus.size());*/

        mv.addObject("menus", menus);
        mv.setViewName("menu/allMenus");

        return mv;
    }
}
