package com.lms.librarymanagementsystem.Interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.lms.librarymanagementsystem.Handlers.SessionHandler;
import com.lms.librarymanagementsystem.models.Users;
import com.lms.librarymanagementsystem.services.UsersServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SessionInterceptor implements HandlerInterceptor {
    private UsersServices usersServices;

    public SessionInterceptor(UsersServices usersServices) {
        this.usersServices = usersServices;
    }
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        if(SessionHandler.checkSession(req)){
            if(SessionHandler.getAccessSession(req).equals("nonadmin")){
                Users user=usersServices.findUserByUsername(SessionHandler.getUserSession(req));
                System.out.println(user);
                req.setAttribute("user", user);
            }
            return true;
        }
        res.sendRedirect("/login");
        return false;
    }
}
