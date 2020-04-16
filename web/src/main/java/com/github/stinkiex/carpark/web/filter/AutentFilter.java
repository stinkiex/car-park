package com.github.stinkiex.carpark.web.filter;

import com.github.stinkiex.carpark.model.AuthUser;
import com.github.stinkiex.carpark.service.SecurityService;
import com.github.stinkiex.carpark.service.impl.DefaultSecurityService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/page/")
public class AutentFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        String checkUser = (String) req.getSession().getAttribute("userRole");
        if (checkUser.equalsIgnoreCase("DISPATCHER")){
            //todo Дописать
        }

    }

    @Override
    public void destroy() {

    }
}
