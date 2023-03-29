package com.example.Buoi_9.repository;

import com.example.Buoi_9.entity.ChucVu;
import com.example.Buoi_9.entity.GioHang;
import com.example.Buoi_9.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class GioHangRepository {
    public ArrayList<GioHang> getAll() {
        ArrayList<GioHang> listKhachHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from GioHang");
            listKhachHang = (ArrayList<GioHang>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;

    }
    public static void main(String[] args) {
        ArrayList<GioHang> list = new GioHangRepository().getAll();
        for (GioHang kh : list) {
            System.out.println(kh.toString());
        }
    }
}
