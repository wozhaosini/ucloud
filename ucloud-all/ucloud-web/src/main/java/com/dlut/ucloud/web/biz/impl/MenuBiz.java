/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package com.dlut.ucloud.web.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.dlut.ucloud.usermanage.common.RoleEnum;

import com.dlut.ucloud.web.biz.IMenuBiz;
import com.dlut.ucloud.web.obj.menu.MenuEnum;
import com.dlut.ucloud.web.obj.menu.MenuVO;

/**
 * 类MenuBiz.java的实现描述：TODO 类实现描述
 * 
 * @author luojie.lj 2014年9月23日 下午8:57:55
 */
public class MenuBiz implements IMenuBiz {

    public List<MenuVO> getMenuListByRole(RoleEnum role) {
        List<MenuVO> menuVOs = new ArrayList<MenuVO>();
        for (MenuEnum menuEnum : MenuEnum.values()) {

        }
        return null;
    }

}
