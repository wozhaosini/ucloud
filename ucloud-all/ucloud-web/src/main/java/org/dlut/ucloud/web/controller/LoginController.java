/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package org.dlut.ucloud.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.dlut.ucloud.common.UCloudResult;
import org.dlut.ucloud.usermanage.domain.UserDTO;
import org.dlut.ucloud.usermanage.service.IUserManageService;
import org.dlut.ucloud.web.obj.constant.SessionConstant;
import org.dlut.ucloud.web.obj.constant.UrlConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dlut.ucloud.web.obj.LoginReqDTO;

/**
 * 类LoginController.java的实现描述：TODO 类实现描述
 * 
 * @author luojie.lj 2014年9月24日 下午7:55:39
 */
@RequestMapping("/login")
@Controller
public class LoginController extends BaseController {

    private static Logger      log = LoggerFactory.getLogger(LoginController.class);

    @Resource(name = "userManageService")
    private IUserManageService userManageService;

    @RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
    public String login(LoginReqDTO loginReqDTO, String redirect, HttpServletRequest request,
                        HttpServletResponse response, ModelMap model) {
        if (request.getMethod().equals("GET")) {
            return UrlConstant.LOGIN_URL;
        }
        // TODO 验证用户的合法性
        UCloudResult<UserDTO> resutlt = userManageService.getUserByAccount(loginReqDTO.getAccount());
        if (resutlt.isSuccess() && resutlt.getModel() != null) {
            request.getSession(true).setAttribute(SessionConstant.USER_ACCOUNT, resutlt.getModel().getAccount());
            if (StringUtils.isBlank(redirect)) {
                return goDefaultPage();
            }
            log.info("redirect:" + redirect);
            return "redirect:" + redirect;
        }

        return UrlConstant.LOGIN_URL;
    }
}
