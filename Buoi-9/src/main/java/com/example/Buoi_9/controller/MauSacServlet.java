package com.example.Buoi_9.controller;

import com.example.Buoi_9.entity.MauSac;
import com.example.Buoi_9.repository.MauSacRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MauSacServlet", value = {"/mau-sac/hien-thi", "/mau-sac/add", "/mau-sac/detail", "/mau-sac/update", "/mau-sac/delete"})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<MauSac> list = mauSacRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/mausac.jsp").forward(request, response);
        } else if (uri.contains("detail")) {
            String id = request.getParameter("id");
            MauSac mauSac = mauSacRepository.getById(id);
            request.setAttribute("mauSac", mauSac);
//            System.out.println(khachHang.getNgaySinh());
//            String ngaySinh = dateFormat.format(khachHang.getNgaySinh());
//            request.setAttribute("ngaySinh", ngaySinh);
            List<MauSac> list = mauSacRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/mausac.jsp").forward(request, response);

        } else if (uri.contains("delete")) {
            String id = request.getParameter("id");
            this.mauSacRepository.delete(id);
            response.sendRedirect("/mau-sac/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            MauSac nsx = new MauSac();
            nsx.setMa(ma);
            nsx.setTen(ten);
            this.mauSacRepository.add(nsx);
            response.sendRedirect("/mau-sac/hien-thi");
        } else if (uri.contains("update")) {
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            MauSac nsx = new MauSac();
            nsx.setId(id);
            nsx.setMa(ma);
            nsx.setTen(ten);
            this.mauSacRepository.update(nsx);
            response.sendRedirect("/mau-sac/hien-thi");
        }
    }
}
