package com.example.Buoi_9.controller;

import com.example.Buoi_9.entity.GioHang;
import com.example.Buoi_9.entity.KhachHang;
import com.example.Buoi_9.repository.GioHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GioHangServlet", value = "/gio-hang/hien-thi")
public class GioHangServlet extends HttpServlet {
    private GioHangRepository gioHangRepository = new GioHangRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<GioHang> list = gioHangRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/giohang.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
