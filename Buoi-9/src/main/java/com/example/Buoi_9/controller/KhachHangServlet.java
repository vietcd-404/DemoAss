package com.example.Buoi_9.controller;

import com.example.Buoi_9.entity.KhachHang;
import com.example.Buoi_9.repository.KhachHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "KhachHangServlet", value = {"/khach-hang/hien-thi","/khach-hang/add"})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khachHangRepository = new KhachHangRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<KhachHang> list = khachHangRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/khachhang.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
