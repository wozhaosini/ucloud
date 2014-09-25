/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package com.dlut.ucloud.web.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类UrlUtil.java的实现描述：TODO 类实现描述
 * 
 * @author luojie.lj 2014年9月25日 上午11:15:00
 */
public class UrlUtil {

    private static Logger log = LoggerFactory.getLogger(UrlUtil.class);

    public static String getCurUrl(HttpServletRequest request) {
        if (request == null) {
            return "";
        }
        String curUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getRequestURI();
        if (!StringUtils.isBlank(request.getQueryString())) {
            curUrl += "?" + request.getQueryString();
        }
        try {
            return URLEncoder.encode(curUrl, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("编码不支持", e);
            return curUrl;
        }
    }
}
