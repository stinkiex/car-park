package com.github.stinkiex.carpark.web;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebUtil {
    private static final Logger log = LoggerFactory.getLogger(WebUtil.class);

    public static void forword(String page, HttpServletRequest rq, HttpServletResponse rs) {
        try {
            rq.getRequestDispatcher("/" + page + ".jsp").forward(rq, rs);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
