package com.example.Buoi_9.repository;

import com.example.Buoi_9.entity.ChucVu;
import com.example.Buoi_9.entity.HoaDon;
import com.example.Buoi_9.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class HoaDonRepository {
    public ArrayList<HoaDon> getAll() {
        ArrayList<HoaDon> listKhachHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from HoaDon");
            listKhachHang = (ArrayList<HoaDon>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;

    }
    public static void main(String[] args) {
        ArrayList<HoaDon> list = new HoaDonRepository().getAll();
        for (HoaDon kh : list) {
            System.out.println(kh.toString());
        }
    }
}
