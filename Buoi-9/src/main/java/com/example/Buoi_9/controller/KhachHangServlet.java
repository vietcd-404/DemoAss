package com.example.Buoi_9.controller;


import com.example.Buoi_9.entity.KhachHang;
import com.example.Buoi_9.repository.KhachHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "KhachHangServlet", value = {"/khach-hang/hien-thi", "/khach-hang/add", "/khach-hang/detail", "/khach-hang/update", "/khach-hang/delete"})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<KhachHang> list = khachHangRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/khachhang.jsp").forward(request, response);
        } else if (uri.contains("detail")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String id = request.getParameter("id");
            KhachHang khachHang = khachHangRepository.getById(id);
            String ngaySinh = dateFormat.format(khachHang.getNgaySinh());
            request.setAttribute("ngaySinh",ngaySinh);
            request.setAttribute("khachHang", khachHang);
            List<KhachHang> list = khachHangRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/views/khachhang.jsp").forward(request, response);

        } else if (uri.contains("delete")) {
            String id = request.getParameter("id");
            this.khachHangRepository.delete(id);
            response.sendRedirect("/khach-hang/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");

            KhachHang khachHang = new KhachHang();

            khachHang.setMatKhau(matKhau);
            khachHang.setDiaChi(diaChi);
            khachHang.setNgaySinh(ngaySinh);
            khachHang.setMa(ma);
            khachHang.setHo(ho);
            khachHang.setQuocGia(quocGia);
            khachHang.setTenDem(tenDem);
            khachHang.setThanhPho(thanhPho);
            khachHang.setTen(ten);
            khachHang.setSdt(sdt);
            this.khachHangRepository.add(khachHang);
            response.sendRedirect("/khach-hang/hien-thi");
        }else if (uri.contains("update")) {
            String id = request.getParameter("id");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String diaChi =request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            KhachHang khachHang = new KhachHang();
            khachHang.setId(id);
            khachHang.setMatKhau(matKhau);
            khachHang.setDiaChi(diaChi);
            khachHang.setNgaySinh(ngaySinh);
            khachHang.setMa(ma);
            khachHang.setHo(ho);
            khachHang.setQuocGia(quocGia);
            khachHang.setTenDem(tenDem);
            khachHang.setThanhPho(thanhPho);
            khachHang.setTen(ten);
            khachHang.setSdt(sdt);
            this.khachHangRepository.update(khachHang);
            response.sendRedirect("/khach-hang/hien-thi");
        }
    }
}
