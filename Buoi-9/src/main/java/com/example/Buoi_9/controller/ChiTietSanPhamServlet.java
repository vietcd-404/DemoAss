package com.example.Buoi_9.controller;

import com.example.Buoi_9.entity.*;
import com.example.Buoi_9.repository.ChiTietSanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ChiTietSanPhamServlet", value = {"/ctsp/hien-thi","/ctsp/add","/ctsp/update","/ctsp/detail","/ctsp/delete"})
public class ChiTietSanPhamServlet extends HttpServlet {
    private ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            List<ChiTietSanPham> list = this.chiTietSanPhamRepository.getAll();
            ArrayList<SanPham> listsp = this.chiTietSanPhamRepository.getAllSanPham();
            ArrayList<NSX> listnsx = this.chiTietSanPhamRepository.getAllNSX();
            ArrayList<DongSP> listdongsp = this.chiTietSanPhamRepository.getAllDongSP();
            ArrayList<MauSac> listdms = this.chiTietSanPhamRepository.getAllMauSac();
            request.setAttribute("list",list);
            request.setAttribute("listsp",listsp);
            request.setAttribute("listnsx",listnsx);
            request.setAttribute("listdongsp",listdongsp);
            request.setAttribute("listdms",listdms);
            System.out.println(uri);
            request.getRequestDispatcher("/views/ctsp.jsp").forward(request,response);
        }
        else if(uri.contains("detail")){
            String id = request.getParameter("id");
            ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.getById(id);
            request.setAttribute("ctsp",chiTietSanPham);
            List<ChiTietSanPham> list = this.chiTietSanPhamRepository.getAll();
            ArrayList<SanPham> listsp = this.chiTietSanPhamRepository.getAllSanPham();
            ArrayList<NSX> listnsx = this.chiTietSanPhamRepository.getAllNSX();
            ArrayList<DongSP> listdongsp = this.chiTietSanPhamRepository.getAllDongSP();
            ArrayList<MauSac> listdms = this.chiTietSanPhamRepository.getAllMauSac();
            request.setAttribute("list",list);
            request.setAttribute("listsp",listsp);
            request.setAttribute("listnsx",listnsx);
            request.setAttribute("listdongsp",listdongsp);
            request.setAttribute("listdms",listdms);
            System.out.println(uri);
            request.getRequestDispatcher("/views/ctsp.jsp").forward(request,response);
        }else if(uri.contains("delete")){
            String id = request.getParameter("id");
            this.chiTietSanPhamRepository.delete(id);
            response.sendRedirect("/ctsp/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            String sanPhamId = request.getParameter("sanPhamId");
            String nsxId = request.getParameter("nsxId");
            String dongSPId = request.getParameter("dongSPId");
            String mauSacId = request.getParameter("mauSacId");
            Integer namBH = Integer.parseInt(request.getParameter("namBH"));
            try {
                Integer.parseInt(request.getParameter("namBH"));
            }catch (NumberFormatException e){
                String mess = "Năm bảo hành phải là số vui lòng nhập lại";
                request.setAttribute("mess",mess);
            }
            Integer soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
            Double giaNhap = Double.parseDouble(request.getParameter("giaNhap"));
            Double giaBan = Double.parseDouble(request.getParameter("giaBan"));
            String moTa = request.getParameter("moTa");
            SanPham sanPham = new SanPham();
            sanPham.setId(sanPhamId);
            NSX nsx = new NSX();
            nsx.setId(nsxId);
            DongSP dongSP = new DongSP();
            dongSP.setId(dongSPId);
            MauSac mauSac = new MauSac();
            mauSac.setId(mauSacId);
            ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
            chiTietSanPham.setSanPham(sanPham);
            chiTietSanPham.setDongSP(dongSP);
            chiTietSanPham.setMauSac(mauSac);
            chiTietSanPham.setNsx(nsx);
            chiTietSanPham.setNamBH(namBH);
            chiTietSanPham.setGiaBan(giaBan);
            chiTietSanPham.setGiaNhap(giaNhap);
            chiTietSanPham.setMoTa(moTa);
            chiTietSanPham.setSoLuongTon(soLuongTon);
            this.chiTietSanPhamRepository.add(chiTietSanPham);
            response.sendRedirect("/ctsp/hien-thi");
        }else if(uri.contains("update")){
            String id = request.getParameter("id");
            String sanPhamId = request.getParameter("sanPhamId");
            String nsxId = request.getParameter("nsxId");
            String dongSPId = request.getParameter("dongSPId");
            String mauSacId = request.getParameter("mauSacId");
            Integer namBH = Integer.parseInt(request.getParameter("namBH"));
            Integer soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
            Double giaNhap = Double.parseDouble(request.getParameter("giaNhap"));
            Double giaBan = Double.parseDouble(request.getParameter("giaBan"));
            String moTa = request.getParameter("moTa");
            SanPham sanPham = new SanPham();
            sanPham.setId(sanPhamId);
            NSX nsx = new NSX();
            nsx.setId(nsxId);
            DongSP dongSP = new DongSP();
            dongSP.setId(dongSPId);
            MauSac mauSac = new MauSac();
            mauSac.setId(mauSacId);
            ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
            chiTietSanPham.setId(id);
            chiTietSanPham.setSanPham(sanPham);
            chiTietSanPham.setDongSP(dongSP);
            chiTietSanPham.setMauSac(mauSac);
            chiTietSanPham.setNsx(nsx);
            chiTietSanPham.setNamBH(namBH);
            chiTietSanPham.setGiaBan(giaBan);
            chiTietSanPham.setGiaNhap(giaNhap);
            chiTietSanPham.setMoTa(moTa);
            chiTietSanPham.setSoLuongTon(soLuongTon);
            this.chiTietSanPhamRepository.update(chiTietSanPham);
            response.sendRedirect("/ctsp/hien-thi");
        }
    }

}
