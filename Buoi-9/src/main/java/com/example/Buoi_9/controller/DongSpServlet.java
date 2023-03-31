package com.example.Buoi_9.controller;


import com.example.Buoi_9.entity.DongSP;
import com.example.Buoi_9.repository.DongSpRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DongSpServlet", value = {"/dongsp/hien-thi","/dongsp/add", "/dongsp/detail", "/dongsp/update", "/dongsp/delete"})
public class DongSpServlet extends HttpServlet {
    private DongSpRepository dongSpRepository= new DongSpRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<DongSP> list =  dongSpRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/dongsp.jsp").forward(request, response);
        }else if (uri.contains("detail")) {
            String id = request.getParameter("id");
            DongSP dongSP = dongSpRepository.getById(id);
            request.setAttribute("dongSP", dongSP);
//            System.out.println(khachHang.getNgaySinh());
//            String ngaySinh = dateFormat.format(khachHang.getNgaySinh());
//            request.setAttribute("ngaySinh", ngaySinh);
            List<DongSP> list = dongSpRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/dongsp.jsp").forward(request, response);

        } else if (uri.contains("delete")) {
            String id = request.getParameter("id");
            this.dongSpRepository.delete(id);
            response.sendRedirect("/dongsp/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            DongSP dongSP = new DongSP();
            dongSP.setMa(ma);
            dongSP.setTen(ten);
            this.dongSpRepository.add(dongSP);
            response.sendRedirect("/dongsp/hien-thi");
        } else if (uri.contains("update")) {
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            DongSP dongSP = new DongSP();
            dongSP.setId(id);
            dongSP.setMa(ma);
            dongSP.setTen(ten);
            this.dongSpRepository.update(dongSP);
            response.sendRedirect("/dongsp/hien-thi");
        }
    }
}
