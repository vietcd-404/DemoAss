package com.example.Buoi_9.repository;

import com.example.Buoi_9.entity.KhachHang;
import com.example.Buoi_9.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class KhachHangRepository {
    Session ses = HibernateUtil.getFACTORY().openSession();
    public List<KhachHang> getAll(){
        Query q = ses.createQuery("from KhachHang");
        List<KhachHang> list = q.getResultList();
        return list;
    }
    public static void main(String[] args) {
        new KhachHangRepository().getAll().forEach(s -> System.out.println(s));
//        System.out.println(new KhachHangRepository().getOne(1L));
//        Ka lopHoc = new LopHoc("M10", "IT17317", 39, "P");
////        System.out.println(new LopHocRepository().add(lopHoc));
//        LopHoc lopHoc = new LopHoc(1L, "M10_Update", "IT17317_Update", 39, "P");
//        System.out.println(new LopHocRepository().delete(lopHoc));
//        new LopHocRepository().getAll().forEach(s -> System.out.println(s));

    }
}
