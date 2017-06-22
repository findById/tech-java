package org.cn.web.rbac.web.interceptor;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

public class SessionContext {
    public static final String ACCESS_PERMISSION_LIST = "ACCESS_PERMISSION_LIST";
    public static final String ACCESS_SESSION = "sign.session";

    public static String getSessionId() {
        return RequestContextHolder.getRequestAttributes().getSessionId();
    }

    public static HttpSession getSession() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    }

    public static Object getAttribute(String key) {
        return getSession().getAttribute(key);
    }

    public static void setAttribute(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static void clearSession() {
        try {
            Enumeration enumeration = getSession().getAttributeNames();
            while (enumeration.hasMoreElements()) {
                getSession().setAttribute(String.valueOf(enumeration.nextElement()), "");
            }
        } catch (Throwable ignored) {
        }
    }
}
