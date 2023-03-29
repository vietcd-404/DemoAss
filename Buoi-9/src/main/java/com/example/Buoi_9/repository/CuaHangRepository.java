package com.example.Buoi_9.repository;

import com.example.Buoi_9.entity.ChucVu;
import com.example.Buoi_9.entity.CuaHang;
import com.example.Buoi_9.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class CuaHangRepository {
    public ArrayList<CuaHang> getAll() {
        ArrayList<CuaHang> listKhachHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from CuaHang ");
            listKhachHang = (ArrayList<CuaHang>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;

    }
    public static void main(String[] args) {
        ArrayList<CuaHang> list = new CuaHangRepository().getAll();
        for (CuaHang kh : list) {
            System.out.println(kh.toString());
        }
    }
}
