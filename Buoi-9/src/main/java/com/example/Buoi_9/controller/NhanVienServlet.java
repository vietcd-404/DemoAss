package com.example.Buoi_9.controller;

import com.example.Buoi_9.entity.*;
import com.example.Buoi_9.repository.NhanVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "NhanVienServlet", value = {"/nhan-vien/hien-thi", "/nhan-vien/add","/nhan-vien/update","/nhan-vien/detail","/nhan-vien/delete"})
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
        }else if(uri.contains("detail")){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String id = request.getParameter("id");
            NhanVien nhanVien = nhanVienRepository.getById(id);
            request.setAttribute("nhanVien", nhanVien);
            System.out.println(nhanVien.getNgaySinh());
            String ngaySinh = dateFormat.format(nhanVien.getNgaySinh());
            request.setAttribute("ngaySinh", ngaySinh);
            List<NhanVien> list = nhanVienRepository.getAll();
            List<ChucVu> chucVuList = nhanVienRepository.getAllChucVu();
            List<CuaHang> cuaHangList = nhanVienRepository.getAllCuaHang();
            request.setAttribute("list", list);
            request.setAttribute("listcv", chucVuList);
            request.setAttribute("listch", cuaHangList);
            request.getRequestDispatcher("/views/nhanvien.jsp").forward(request, response);
        }else if(uri.contains("delete")){
            String id = request.getParameter("id");
            this.nhanVienRepository.delete(id);
            response.sendRedirect("/nhan-vien/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String chucVuId = request.getParameter("chucVu.id");
            String cuaHangId = request.getParameter("cuaHang.id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
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

        }else if(uri.contains("update")){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String chucVuId = request.getParameter("chucVu.id");
            String cuaHangId = request.getParameter("cuaHang.id");
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            Integer trangThai = Integer.parseInt(request.getParameter("trangThai"));
            ChucVu chucVu = new ChucVu();
            chucVu.setId(chucVuId);
            CuaHang cuaHang = new CuaHang();
            cuaHang.setId(cuaHangId);
            NhanVien nhanVien = new NhanVien();
            nhanVien.setId(id);
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
            this.nhanVienRepository.update(nhanVien);
            response.sendRedirect("/nhan-vien/hien-thi");
        }
    }
}
