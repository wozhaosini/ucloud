/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package org.dlut.ucloud.web.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.dlut.ucloud.usermanage.common.RoleEnum;
import org.dlut.ucloud.web.biz.IMenuBiz;
import org.dlut.ucloud.web.obj.menu.MenuEnum;
import org.dlut.ucloud.web.obj.menu.MenuVO;
import org.springframework.stereotype.Service;

/**
 * 类MenuBiz.java的实现描述：TODO 类实现描述
 * 
 * @author luojie.lj 2014年9月23日 下午8:57:55
 */
@Service
public class MenuBiz implements IMenuBiz {

    @Override
    public List<MenuVO> getMenuListByRole(RoleEnum role, MenuEnum currentMenu) {
        List<MenuVO> menuVOs = new ArrayList<MenuVO>();
        for (MenuEnum menuEnum : MenuEnum.values()) {
            if (menuEnum.getRole() == role) {
                MenuVO menuVO = new MenuVO();
                menuVO.setMenuEnum(menuEnum);
                if (menuEnum == currentMenu) {
                    menuVO.setCurrent(true);
                }
                menuVOs.add(menuVO);
            }
        }
        return menuVOs;
    }
}
