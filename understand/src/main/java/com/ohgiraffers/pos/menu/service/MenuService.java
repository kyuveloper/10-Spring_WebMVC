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

    public List<MenuDTO> selectAllMenu() throws NullPointerException {
        List<MenuDTO> menus = menuDAO.selectAllMenu();

        return menus;
    }

    public int insertMenu(MenuDTO menuDTO) {
        int result = menuDAO.insertMenu(menuDTO);
        if(result <= 0){
            System.out.println("다시 시도");
        }else{
            System.out.println("성공");
        }
        return result;
    }

    public int deleteMenu(int code, String name) {
        int result = menuDAO.deleteMenu(code, name);
        if(result <= 0){
            System.out.println("다시 시도");
        }else{
            System.out.println("성공");
        }
        return result;
    }

    public int editMenu(MenuDTO menuDTO) {
        int result = menuDAO.editMenu(menuDTO);
        if(result <= 0){
            System.out.println("다시 시도");
        }else{
            System.out.println("성공");
        }
        return result;
    }
}
