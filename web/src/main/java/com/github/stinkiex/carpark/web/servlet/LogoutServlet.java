package com.github.stinkiex.carpark.web.servlet;

import com.github.stinkiex.carpark.service.SecurityService;
import com.github.stinkiex.carpark.web.WebUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private SecurityService securityService;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) {
        rq.getSession().removeAttribute("authUser");
        rq.getSession().invalidate();
        WebUtil.forward("login", rq, rs);
    }

}
