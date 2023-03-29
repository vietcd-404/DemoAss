package com.example.Buoi_9.controller;

import com.example.Buoi_9.entity.DongSP;
import com.example.Buoi_9.entity.MauSac;
import com.example.Buoi_9.repository.DongSpRepository;
import com.example.Buoi_9.repository.MauSacRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DongSpServlet", value = "/dongsp/hien-thi")
public class DongSpServlet extends HttpServlet {
    private DongSpRepository dongSpRepository= new DongSpRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<DongSP> list =  dongSpRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/dongsp.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
