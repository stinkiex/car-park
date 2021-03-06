package com.github.stinkiex.carpark.web.filter;

import com.github.stinkiex.carpark.web.WebUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/page/", "/carPage.jsp"})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        Object authUser = req.getAttribute("authUser");
        if (authUser == null){
            WebUtil.redirect("login", req, (HttpServletResponse) servletResponse);
        }
        filterChain.doFilter(req, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
