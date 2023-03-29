package com.example.Buoi_9.repository;

import com.example.Buoi_9.entity.NSX;

import com.example.Buoi_9.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class NSXRepository {
    public ArrayList<NSX> getAll() {
        ArrayList<NSX> listKhachHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NSX");
            listKhachHang = (ArrayList<NSX>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;

    }
    public static void main(String[] args) {
        ArrayList<NSX> list = new NSXRepository().getAll();
        for (NSX kh : list) {
            System.out.println(kh.toString());
        }
    }
}
