package com.github.stinkiex.carpark.web.servlet;

import com.github.stinkiex.carpark.model.AuthUser;
import com.github.stinkiex.carpark.service.SecurityService;
import com.github.stinkiex.carpark.service.impl.DefaultSecurityService;
import com.github.stinkiex.carpark.web.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);
    private SecurityService securityService = DefaultSecurityService.getInstance();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) {
        Object authUser = rq.getSession().getAttribute("authUser");
        if (authUser == null) {
            WebUtil.forward("login", rq, rs);
            return;
        }
        WebUtil.redirect("/cabinet", rq, rs);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) {
        String login = rq.getParameter("login");
        String password = rq.getParameter("password");
        AuthUser user = securityService.login(login, password);
        if (user == null) {
            rq.setAttribute("error", "login or password invalid");
            WebUtil.forward("login", rq, rs);
            return;
        }
        log.info("user {} logged", user.getLogin());
        rq.getSession().setAttribute("authUser", user);
        WebUtil.redirect("/student", rq, rs);
    }
}