package com.github.stinkiex.carpark.web.servlet;

import com.github.stinkiex.carpark.model.Car;
import com.github.stinkiex.carpark.service.CarService;
import com.github.stinkiex.carpark.service.impl.DefaultCarService;
import com.github.stinkiex.carpark.web.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Car Delete Servlet", urlPatterns = "/deletecar")
public class CarDeleteServlet extends HttpServlet {

    private CarService carService = DefaultCarService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long carId = Long.valueOf(req.getParameter("carid"));
        String name = req.getParameter("carname");
        String model = req.getParameter("carmodel");
        String regNumb = req.getParameter("regnumb");
        Integer repairStatus = Integer.valueOf(req.getParameter("repairstatus"));
        Car car = new Car(carId, name, model, regNumb, repairStatus);
        long flag = carService.deleteCar(car);
        if (flag == 0){
            req.setAttribute("error", "Ошибка при удалении машины");
            WebUtil.forward("cars", req, resp);
        }
        WebUtil.forward("cars", req, resp);
    }
}
