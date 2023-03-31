package com.example.Buoi_9.controller;

import com.example.Buoi_9.entity.ChucVu;
import com.example.Buoi_9.entity.SanPham;
import com.example.Buoi_9.entity.SanPham;
import com.example.Buoi_9.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = {"/san-pham/hien-thi","/san-pham/add", "/san-pham/detail", "/san-pham/update", "/san-pham/delete"})
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
        else if (uri.contains("detail")) {
            String id = request.getParameter("id");
            SanPham sanPham = sanPhamRepository.getById(id);
            request.setAttribute("sanPham", sanPham);
//            System.out.println(khachHang.getNgaySinh());
//            String ngaySinh = dateFormat.format(khachHang.getNgaySinh());
//            request.setAttribute("ngaySinh", ngaySinh);
            List<SanPham> list = sanPhamRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/sanpham.jsp").forward(request, response);

        } else if (uri.contains("delete")) {
            String id = request.getParameter("id");
            this.sanPhamRepository.delete(id);
            response.sendRedirect("/san-pham/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            SanPham sanPham = new SanPham();
            sanPham.setMa(ma);
            sanPham.setTen(ten);
            this.sanPhamRepository.add(sanPham);
            response.sendRedirect("/san-pham/hien-thi");
        } else if (uri.contains("update")) {
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            SanPham sanPham = new SanPham();
            sanPham.setId(id);
            sanPham.setMa(ma);
            sanPham.setTen(ten);
            this.sanPhamRepository.update(sanPham);
            response.sendRedirect("/san-pham/hien-thi");
        }
    }
}
