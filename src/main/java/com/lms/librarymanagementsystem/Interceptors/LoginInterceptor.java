package com.lms.librarymanagementsystem.Interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.lms.librarymanagementsystem.Handlers.SessionHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        if (!SessionHandler.checkSession(req)) {
            return true;
        } else if (SessionHandler.getAccessSession(req).equals("admin")) {
            res.sendRedirect("/admin");
        }else{
            res.sendRedirect("/user");
        }
        return false;
    }
}
