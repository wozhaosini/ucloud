/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package com.dlut.ucloud.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 类HelloController.java的实现描述
 * 
 * @author luojie.lj 2014年9月18日 下午8:36:38
 */
@RequestMapping("/hello.do")
@Controller
public class HelloController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public void hello(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        request.setAttribute("aa", "bb");
        System.out.println(model.get("aa"));
        //        model.addAttribute("message", "xixi");
        //        return "hello";

        model.put("cc", "dd");
        this.outputResponseJson(response, model.get("cc").toString());
    }
    //	public ModelAndView handleRequest(HttpServletRequest ar
    //			HttpServletResponse arg1) throws Exception {
    //		ModelAndView mv = new ModelAndView();
    //		mv.addObject("message", "xixi");
    //		mv.setViewName("hello");
    //
    //		return mv;
    //	}

}
