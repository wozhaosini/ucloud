package org.dlut.ucloud.web.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.dlut.ucloud.usermanage.service.IUserManageService;
import org.dlut.ucloud.web.obj.constant.SessionConstant;
import org.dlut.ucloud.web.obj.constant.UrlConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dlut.ucloud.web.utils.UrlUtil;

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

        String userAccount = (String) request.getSession().getAttribute(SessionConstant.USER_ACCOUNT);
        if (StringUtils.isBlank(userAccount)) {
            response.sendRedirect(UrlConstant.LOGIN_URL + "?redirect=" + UrlUtil.getCurUrl(request));
            return false;
        }

        return super.preHandle(request, response, handler);
    }
}
