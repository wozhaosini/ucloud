package com.dlut.ucloud.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dlut.ucloud.web.obj.constant.SessionConstant;

/**
 * 拦截未登陆用户
 * 
 * @author luojie 2014年9月21日 下午10:31:19
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        System.out.println("MyInterceptor.preHandle()" + url);

        String strUserId = (String) request.getSession().getAttribute(SessionConstant.USER_ID);
        if (strUserId == null) {

        }

        return super.preHandle(request, response, handler);
    }
}
