package com.github.stinkiex.carpark.web.servlet;

import com.github.stinkiex.carpark.service.CarService;
import com.github.stinkiex.carpark.service.impl.DefaultCarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Car Delete Servlet", urlPatterns = "/deletecar")
public class CarDeleteServlet extends HttpServlet {

    CarService carService = DefaultCarService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameter("carid");
        super.doPost(req, resp);
    }
}
