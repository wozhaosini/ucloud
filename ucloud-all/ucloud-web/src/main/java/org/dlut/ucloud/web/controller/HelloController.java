/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package org.dlut.ucloud.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 类HelloController.java的实现描述
 * 
 * @author luojie.lj 2014年9月18日 下午8:36:38
 */
@RequestMapping("/student/hello.do")
@Controller
public class HelloController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String hello(String name, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        request.setAttribute("aa", "bb");
        model.put("message", name);
        model.put("screen", "student/hello.vm");
        log.info("xx");

        return "default";
        //        return "hello";
    }
}
