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

@WebServlet(name = "Car Add Servlet", urlPatterns = "/addcar")
public class CarAddServlet extends HttpServlet{

    private static final Logger log = LoggerFactory.getLogger(Car.class);
    private CarService carService = DefaultCarService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carname = req.getParameter("carName");
        String carModel = req.getParameter("carModel");
        String carNumber = req.getParameter("regNumber");
        long flag = carService.addCar(carname, carModel, carNumber);
        if ( flag == 0) {
            req.setAttribute("error", "Failed to creat car");
            WebUtil.forward("cars", req, resp);
            return;
        }
        WebUtil.forward("cars", req, resp);
    }
}
