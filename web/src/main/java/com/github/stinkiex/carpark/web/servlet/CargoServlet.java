package com.github.stinkiex.carpark.web.servlet;

import com.github.stinkiex.carpark.dao.impl.DefaultFlightApplicationDao;
import com.github.stinkiex.carpark.model.FlightApplication;
import com.github.stinkiex.carpark.service.FlightApplicationService;
import com.github.stinkiex.carpark.service.impl.DefaultFlightApplicationService;
import com.github.stinkiex.carpark.web.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CargoServlet", urlPatterns = "/cargoPage")
public class CargoServlet extends HttpServlet {

    FlightApplicationService flightApplicationService = DefaultFlightApplicationService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlightApplication> cargos = flightApplicationService.getList();
        req.setAttribute("cargos", cargos);
        WebUtil.forward("cargoPage", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
