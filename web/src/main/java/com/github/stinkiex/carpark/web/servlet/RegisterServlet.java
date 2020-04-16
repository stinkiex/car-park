package com.github.stinkiex.carpark.web.servlet;

import com.github.stinkiex.carpark.model.AuthUser;
import com.github.stinkiex.carpark.model.User;
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
        Object userRole = rq.getSession().getAttribute("userRole");
        if (authUser != null) {
            WebUtil.forward("cabinet", rq, rs);
            return;
        }
        WebUtil.forward("/register.jsp", rq, rs);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        String repass = req.getParameter("repassword");
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        if (pass.compareTo(repass) != 0) {
            req.setAttribute("error", "passwords missmatch");
            WebUtil.forward("register", req, resp);
            return;
        }
        if (securityService.login(login, pass) != null ) {
            req.setAttribute("error", "user already exists");
            WebUtil.forward("register", req, resp);
            return;
        }
        Long flag = securityService.createUser(login, pass, firstName, lastName);
        if (flag == null) {
            req.setAttribute("error", "login or password invalid");
            WebUtil.forward("register", req, resp);
            return;
        }
        log.info("user {} registered", login);
        req.getSession().setAttribute("authUser", login);
        WebUtil.redirect("/cabinet", req, resp);//todo Запилить валидацию полей
    }


}
