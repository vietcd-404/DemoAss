package com.example.Buoi_9.repository;

import com.example.Buoi_9.entity.DongSP;

import com.example.Buoi_9.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class DongSpRepository {
    public ArrayList<DongSP> getAll() {
        ArrayList<DongSP> listKhachHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from DongSP");
            listKhachHang = (ArrayList<DongSP>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;

    }
    public static void main(String[] args) {
        ArrayList<DongSP> list = new DongSpRepository().getAll();
        for (DongSP kh : list) {
            System.out.println(kh.toString());
        }
    }
}
