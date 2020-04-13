package com.github.stinkiex.carpark.web.servlet;

import com.github.stinkiex.carpark.model.AuthUser;
import com.github.stinkiex.carpark.service.SecurityService;
import com.github.stinkiex.carpark.service.impl.DefaultSecurityService;
import com.github.stinkiex.carpark.web.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(RegisterServlet.class);

    SecurityService securityService = DefaultSecurityService.getInstance();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) {
        Object authUser = rq.getSession().getAttribute("authUser");
        if (authUser != null) {
            WebUtil.forward("cabinet", rq, rs);
            return;
        }
        WebUtil.redirect("/register.jsp", rq, rs);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        AuthUser authUser = securityService.createUser(login, pass);
        if (authUser == null) {
            req.setAttribute("error", "login or password invalid");
            WebUtil.forward("register", req, resp);
            return;
        }
        log.info("user {} registered", authUser.getLogin());
        req.getSession().setAttribute("authUser", authUser.getLogin());
        WebUtil.redirect("/student", req, resp);//todo Запилить валидацию полей
    }


}
