package com.example.Buoi_9.repository;

import com.example.Buoi_9.entity.ChucVu;
import com.example.Buoi_9.entity.SanPham;
import com.example.Buoi_9.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class SanPhamRepository {
    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> listKhachHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from SanPham");
            listKhachHang = (ArrayList<SanPham>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;

    }
    public static void main(String[] args) {
        ArrayList<SanPham> list = new SanPhamRepository().getAll();
        for (SanPham kh : list) {
            System.out.println(kh.toString());
        }
    }
}
