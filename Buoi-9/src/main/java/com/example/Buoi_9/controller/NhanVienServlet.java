package com.example.Buoi_9.controller;

import com.example.Buoi_9.entity.ChucVu;
import com.example.Buoi_9.entity.CuaHang;
import com.example.Buoi_9.entity.KhachHang;
import com.example.Buoi_9.entity.NhanVien;
import com.example.Buoi_9.repository.NhanVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "NhanVienServlet", value = {"/nhan-vien/hien-thi","/nhan-vien/add"})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<NhanVien> list = nhanVienRepository.getAll();
            List<ChucVu> chucVuList = nhanVienRepository.getAllChucVu();
            List<CuaHang> cuaHangList = nhanVienRepository.getAllCuaHang();
            request.setAttribute("list", list);
            request.setAttribute("listcv", chucVuList);
            request.setAttribute("listch", cuaHangList);
            request.getRequestDispatcher("/views/nhanvien.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
           String chucVuId = request.getParameter("chucVu.id");
           String cuaHangId = request.getParameter("cuaHang.id");
            String ma = request.getParameter("ma");
           String ten = request.getParameter("ten");
           String tenDem = request.getParameter("tenDem");
           String ho = request.getParameter("ho");
           String gioiTinh = request.getParameter("gioiTinh");
           Date ngaySinh = Date.valueOf(request.getParameter("ngaySinh"));
           String diaChi = request.getParameter("diaChi");
           String sdt = request.getParameter("sdt");
           String matKhau = request.getParameter("matKhau");
           Integer trangThai = Integer.parseInt(request.getParameter("trangThai"));
           ChucVu chucVu = new ChucVu();
           chucVu.setId(chucVuId);
           CuaHang cuaHang = new CuaHang();
           cuaHang.setId(cuaHangId);
           NhanVien nhanVien = new NhanVien();
           nhanVien.setTen(ten);
           nhanVien.setTenDem(tenDem);
           nhanVien.setHo(ho);
           nhanVien.setGioiTinh(gioiTinh);
           nhanVien.setNgaySinh(ngaySinh);
           nhanVien.setDiaChi(diaChi);
           nhanVien.setSdt(sdt);
           nhanVien.setMatKhau(matKhau);
           nhanVien.setTrangThai(trangThai);
           nhanVien.setMa(ma);
           nhanVien.setChucVu(chucVu);
           nhanVien.setCuaHang(cuaHang);
           this.nhanVienRepository.add(nhanVien);
           response.sendRedirect("/nhan-vien/hien-thi");

        }
    }
}
