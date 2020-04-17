package com.github.stinkiex.carpark.web.servlet;

import com.github.stinkiex.carpark.model.RepairRequest;
import com.github.stinkiex.carpark.service.RepairService;
import com.github.stinkiex.carpark.service.impl.DefaultRepairService;
import com.github.stinkiex.carpark.web.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RepairRequestServlet", urlPatterns = "/repairPage")
public class RepairRequestServlet extends HttpServlet {

    RepairService repairService = DefaultRepairService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<RepairRequest> repairs = repairService.getRepairs();
        req.setAttribute("repairs", repairs);
        WebUtil.forward("repairPage", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
