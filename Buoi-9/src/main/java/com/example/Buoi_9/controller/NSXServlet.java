package com.example.Buoi_9.controller;

import com.example.Buoi_9.entity.NSX;
import com.example.Buoi_9.repository.NSXRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "NSXServlet", value = {"/nsx/hien-thi","/nsx/add", "/nsx/detail", "/nsx/update", "/nsx/delete"})
public class NSXServlet extends HttpServlet {
    private NSXRepository nsxRepository= new NSXRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<NSX> list = nsxRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/nsx.jsp").forward(request, response);
        } else if (uri.contains("detail")) {
            String id = request.getParameter("id");
            NSX nsx = nsxRepository.getById(id);
            request.setAttribute("nsx", nsx);
//            System.out.println(khachHang.getNgaySinh());
//            String ngaySinh = dateFormat.format(khachHang.getNgaySinh());
//            request.setAttribute("ngaySinh", ngaySinh);
            List<NSX> list = nsxRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/nsx.jsp").forward(request, response);

        } else if (uri.contains("delete")) {
            String id = request.getParameter("id");
            this.nsxRepository.delete(id);
            response.sendRedirect("/nsx/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            NSX nsx = new NSX();
            nsx.setMa(ma);
            nsx.setTen(ten);
            this.nsxRepository.add(nsx);
            response.sendRedirect("/nsx/hien-thi");
        } else if (uri.contains("update")) {
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            NSX nsx = new NSX();
            nsx.setId(id);
            nsx.setMa(ma);
            nsx.setTen(ten);
            this.nsxRepository.update(nsx);
            response.sendRedirect("/nsx/hien-thi");
        }
    }
}
