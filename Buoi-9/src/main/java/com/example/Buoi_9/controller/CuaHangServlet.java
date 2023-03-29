package com.example.Buoi_9.controller;

import com.example.Buoi_9.entity.CuaHang;
import com.example.Buoi_9.entity.KhachHang;
import com.example.Buoi_9.repository.CuaHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CuaHangServlet", value = "/cua-hang/hien-thi")
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<CuaHang> list = cuaHangRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/cuahang.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
