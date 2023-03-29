package com.example.Buoi_9.controller;

import com.example.Buoi_9.entity.ChucVu;
import com.example.Buoi_9.entity.SanPham;
import com.example.Buoi_9.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = "/san-pham/hien-thi")
public class SanPhamServlet extends HttpServlet {
    SanPhamRepository sanPhamRepository = new SanPhamRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<SanPham> list = sanPhamRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/sanpham.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
