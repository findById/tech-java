package org.cn.web.rbac.web.interceptor;

import com.alibaba.fastjson.JSON;
import org.cn.web.rbac.domain.Permission;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

public class PermissionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) { // ignore
            return super.preHandle(request, response, handler);
        }
        PermissionRequired ann = PermissionHelper.findMethodOrDeclaringClassAnn(handler, PermissionRequired.class);
        if (ann == null) { // ignore
            return super.preHandle(request, response, handler);
        }

        // login status authorized first.
        Object session = SessionContext.getAttribute(SessionContext.ACCESS_SESSION);
        if (session == null) {
            response.sendRedirect("/");
            return false;
        }

        Object permissionCache = SessionContext.getAttribute(SessionContext.ACCESS_PERMISSION_LIST);
        List<Permission> permissionList = JSON.parseArray(String.valueOf(permissionCache), Permission.class);
        if (!assertAuthorized(ann, permissionList)) {
            System.err.println("User is not permitted [" + Arrays.toString(ann.value()) + "]");
            response.sendRedirect("/");
            return false;
        }
        return super.preHandle(request, response, handler);
    }

    boolean assertAuthorized(PermissionRequired ann, List<Permission> permissionList) {
        if (ann == null || ann.value() == null || ann.value().length <= 0) {
            System.err.println("Permission code is empty.");
            return true;
        }
        if (permissionList == null || permissionList.isEmpty()) {
            return false;
        }
        if ("AND".equalsIgnoreCase(ann.logical())) {
            for (String permCode : ann.value()) {
                if (permCode == null || permCode.isEmpty()) {
                    continue;
                }
                if (!isPermitted(permCode, permissionList)) {
                    return false;
                }
            }
            return true;
        } else if ("OR".equalsIgnoreCase(ann.logical())) {
            for (String permCode : ann.value()) {
                if (permCode == null || permCode.isEmpty()) {
                    continue;
                }
                if (isPermitted(permCode, permissionList)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isPermitted(String permCode, List<Permission> permissionList) {
        for (Permission perm : permissionList) {
            if (permCode.equals(perm.getPermCode())) {
                return true;
            }
        }
        return false;
    }
}
