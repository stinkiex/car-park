package com.github.stinkiex.carpark.web.servlet;

import com.github.stinkiex.carpark.dao.impl.DefaultRepairRequestDao;
import com.github.stinkiex.carpark.model.RepairStatus;
import com.github.stinkiex.carpark.service.RepairService;
import com.github.stinkiex.carpark.service.impl.DefaultRepairService;
import com.github.stinkiex.carpark.web.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addrepairrequest")
public class AddRepairRequestServlet extends HttpServlet {

    RepairService repairService = DefaultRepairService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String regnumber = req.getParameter("regnumber");
        String reason = req.getParameter("reason");
        repairService.saveRepair(name, regnumber, reason, RepairStatus.SENT);
        WebUtil.forward("repairPage", req, resp);

    }
}
