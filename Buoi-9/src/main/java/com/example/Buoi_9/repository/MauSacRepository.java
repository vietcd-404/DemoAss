package com.example.Buoi_9.repository;

import com.example.Buoi_9.entity.MauSac;

import com.example.Buoi_9.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class MauSacRepository {
    public ArrayList<MauSac> getAll() {
        ArrayList<MauSac> listKhachHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from MauSac");
            listKhachHang = (ArrayList<MauSac>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;

    }
    public static void main(String[] args) {
        ArrayList<MauSac> list = new MauSacRepository().getAll();
        for (MauSac kh : list) {
            System.out.println(kh.toString());
        }
    }
}
