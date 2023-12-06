package com.ohgiraffers.pos.menu.service;

import com.ohgiraffers.pos.menu.dto.MenuDTO;
import com.ohgiraffers.pos.menu.model.MenuDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service // 빈에서 관리
public class MenuService {

    private MenuDAO menuDAO;

    public MenuService(MenuDAO menuDAO) { //
        this.menuDAO = menuDAO;
    }

    public List<MenuDTO> selectAllMenu() {
        List<MenuDTO> menus = menuDAO.selectAllMenu();

        if (Objects.isNull(menus)) { // menuDAO에서 작업 이후의 에러
            System.out.println("exception menus가 없음");
        }
        return menus;
    }
}
