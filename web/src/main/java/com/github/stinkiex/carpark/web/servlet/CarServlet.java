package com.github.stinkiex.carpark.web.servlet;

import com.github.stinkiex.carpark.model.Car;
import com.github.stinkiex.carpark.service.CarService;
import com.github.stinkiex.carpark.service.impl.DefaultCarService;
import com.github.stinkiex.carpark.web.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CarServlet", urlPatterns = "/carPage")
public class CarServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(Car.class);
    private CarService carService = DefaultCarService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = carService.getCars();
        req.setAttribute("cars", cars);
        WebUtil.forward("carPage", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
