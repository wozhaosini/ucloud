/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package org.dlut.ucloud.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.dlut.ucloud.usermanage.common.RoleEnum;
import org.dlut.ucloud.web.obj.constant.UrlConstant;
import org.springframework.ui.Model;

/**
 * 类BaseController.java的实现描述：TODO 类实现描述
 * 
 * @author luojie 2014年9月21日 下午5:30:34
 */
public class BaseController {

    protected void setDefaultEnv(Model model) {

    }

    /**
     * 重定向到登陆页面
     * 
     * @return
     */
    protected String goLoginPage() {
        return "redirect:" + UrlConstant.LOGIN_URL;
    }

    protected String goDefaultPage(RoleEnum role) {
        StringBuilder page = new StringBuilder("redirect:");
        if (role == RoleEnum.ADMIN) {
            page.append(UrlConstant.ADMIN_DEFAULT_URL);
        } else if (role == RoleEnum.STUDENT) {
            page.append(UrlConstant.STUDENT_DEFAULT_URL);
        } else if (role == RoleEnum.TEACHER) {
            page.append(UrlConstant.TEACHER_DEFAULT_URL);
        }
        return page.toString();
    }

    protected void outputResponseJson(HttpServletResponse response, String jsonMap) {
        try {
            response.getWriter().println(jsonMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
