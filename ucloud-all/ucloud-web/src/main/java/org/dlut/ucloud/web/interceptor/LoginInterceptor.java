package org.dlut.ucloud.web.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dlut.ucloud.usermanage.service.IUserManageService;
import org.dlut.ucloud.web.obj.constant.SessionConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 拦截未登陆用户
 * 
 * @author luojie 2014年9月21日 下午10:31:19
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    protected static Logger      log = LoggerFactory.getLogger(LoginInterceptor.class);

    @Resource(name = "userManageService")
    protected IUserManageService userManageService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        log.info("MyInterceptor.preHandle()" + url);

        String strUserId = (String) request.getSession().getAttribute(SessionConstant.USER_ID);
        if (strUserId == null) {

        }

        return super.preHandle(request, response, handler);
    }
}
