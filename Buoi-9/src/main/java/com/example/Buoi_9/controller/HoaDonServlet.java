package com.example.Buoi_9.controller;

import com.example.Buoi_9.entity.GioHang;
import com.example.Buoi_9.entity.HoaDon;
import com.example.Buoi_9.repository.GioHangRepository;
import com.example.Buoi_9.repository.HoaDonRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "HoaDonServlet", value = "/hoa-don/hien-thi")
public class HoaDonServlet extends HttpServlet {
    private HoaDonRepository hoaDonRepository = new HoaDonRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<HoaDon> list = hoaDonRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/hoadon.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
