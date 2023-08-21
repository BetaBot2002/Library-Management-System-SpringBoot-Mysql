package com.lms.librarymanagementsystem.Handlers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionHandler {
    public static boolean checkSession(HttpServletRequest req){
       HttpSession session=req.getSession(false);
       if(session!=null && (String)session.getAttribute("user")!=null){
        return true;
       }
        return false;
    }

    public static String getUserSession(HttpServletRequest req){
        if(checkSession(req)){
            return (String)req.getSession(false).getAttribute("user");
        }
        return null;
    }

    public static String getAccessSession(HttpServletRequest req){
        if(checkSession(req)){
            return (String)req.getSession(false).getAttribute("access");
        }
        return null;
    }

    public  static void setSession(HttpServletRequest req,String user,String access){
        HttpSession session=req.getSession();
        session.setAttribute("user", user);
        session.setAttribute("access", access);
    }

    public  static void setOtpSession(HttpServletRequest req,String OTP,Integer timeout){
        HttpSession session=req.getSession();
        session.setAttribute("otp", OTP);
        session.setMaxInactiveInterval(timeout);
    }

    public  static String getOtpSession(HttpServletRequest req){
        HttpSession session=req.getSession(false);
        if(session!=null){
            String otp= (String)session.getAttribute("otp");
            return otp;
        }
        return null;
    }

    public static void deleteSession(HttpServletRequest req){
        HttpSession session=req.getSession(false);
        session.invalidate();
    }
}
