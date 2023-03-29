package com.example.Buoi_9.controller;

import com.example.Buoi_9.entity.MauSac;
import com.example.Buoi_9.entity.NSX;
import com.example.Buoi_9.repository.MauSacRepository;
import com.example.Buoi_9.repository.NSXRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MauSacServlet", value = "/mau-sac/hien-thi")
public class MauSacServlet extends HttpServlet {
    private MauSacRepository mauSacRepository= new MauSacRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<MauSac> list = mauSacRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/mausac.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
