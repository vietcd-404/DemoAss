package com.example.Buoi_9.controller;

import com.example.Buoi_9.entity.ChucVu;
import com.example.Buoi_9.entity.KhachHang;
import com.example.Buoi_9.repository.ChucVuRepository;
import com.example.Buoi_9.repository.KhachHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChucVuServlet", value = {"/chuc-vu/hien-thi", "/chuc-vu/add", "/chuc-vu/detail", "/chuc-vu/update", "/chuc-vu/delete", "/chuc-vu/reset"})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<ChucVu> list = chucVuRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/chucvu.jsp").forward(request, response);
        } else if (uri.contains("detail")) {
            String id = request.getParameter("id");
            ChucVu chucVu = chucVuRepository.getById(id);
            request.setAttribute("cv", chucVu);
//            System.out.println(khachHang.getNgaySinh());
//            String ngaySinh = dateFormat.format(khachHang.getNgaySinh());
//            request.setAttribute("ngaySinh", ngaySinh);
            List<ChucVu> list = chucVuRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/chucvu.jsp").forward(request, response);

        } else if (uri.contains("delete")) {
            String id = request.getParameter("id");
            this.chucVuRepository.delete(id);
            response.sendRedirect("/chuc-vu/hien-thi");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu chucVu = new ChucVu();
            chucVu.setMa(ma);
            chucVu.setTen(ten);
            this.chucVuRepository.add(chucVu);
            response.sendRedirect("/chuc-vu/hien-thi");
        } else if (uri.contains("update")) {
                String id = request.getParameter("id");

            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu chucVu = new ChucVu();
            chucVu.setId(id);
            chucVu.setMa(ma);
            chucVu.setTen(ten);
            this.chucVuRepository.update(chucVu);
            response.sendRedirect("/chuc-vu/hien-thi");
        } else if (uri.contains("reset")) {
            String id = "";
            String ma = "";
            String ten = "";

            // Reset các giá trị đầu vào trong Session
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
            session.setAttribute("ma", ma);
            session.setAttribute("ten", ten);

            // Redirect về trang form và hiển thị các giá trị mặc định
            request.setAttribute("id", id);
            request.setAttribute("ma", ma);
            request.setAttribute("ten", ten);
            List<ChucVu> list = chucVuRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/chucvu.jsp").forward(request, response);
        }
    }
}

