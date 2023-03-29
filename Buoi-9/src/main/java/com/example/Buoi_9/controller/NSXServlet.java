package com.example.Buoi_9.controller;

import com.example.Buoi_9.entity.NSX;
import com.example.Buoi_9.entity.NhanVien;
import com.example.Buoi_9.repository.NSXRepository;
import com.example.Buoi_9.repository.NhanVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "NSXServlet", value = "/nsx/hien-thi")
public class NSXServlet extends HttpServlet {
    private NSXRepository nsxRepository= new NSXRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<NSX> list = nsxRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/nsx.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
