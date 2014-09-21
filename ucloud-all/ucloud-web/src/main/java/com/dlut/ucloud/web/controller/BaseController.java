/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package com.dlut.ucloud.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.ui.Model;

/**
 * 类BaseController.java的实现描述：TODO 类实现描述
 * 
 * @author luojie 2014年9月21日 下午5:30:34
 */
public class BaseController {

    protected void setDefaultEnv(Model model) {

    }

    protected String getCurUrl(HttpServletRequest request) {
        String curUrl = request.getRequestURI();
        if (!StringUtils.isBlank(request.getQueryString())) {
            curUrl += "?" + request.getQueryString();
        }
        return curUrl;
    }

    protected void outputResponseJson(HttpServletResponse response, String jsonMap) {
        try {
            response.getWriter().println(jsonMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
