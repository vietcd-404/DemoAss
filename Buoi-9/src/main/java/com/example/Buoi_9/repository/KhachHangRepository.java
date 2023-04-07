package com.example.Buoi_9.repository;

import com.example.Buoi_9.entity.DongSP;
import com.example.Buoi_9.entity.KhachHang;
import com.example.Buoi_9.entity.KhachHang;
import com.example.Buoi_9.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {
    public ArrayList<KhachHang> getAll() {
        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from KhachHang");
            listKhachHang = (ArrayList<KhachHang>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;

    }
    public KhachHang getById(String id) {
        KhachHang khachHang = new KhachHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            Query query = session.createQuery("from KhachHang where id =: id");
//            query.setParameter("id", id);
//            khachHang= (KhachHang) query.getSingleResult();
            khachHang = session.get(KhachHang.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }
    public Boolean add(KhachHang khachHang) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(KhachHang khachHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }
    //    public Boolean delete(ChucVu chucVu) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            transaction = session.beginTransaction();
//            session.delete(chucVu);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return false;
//    }
    public Boolean delete(String id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            KhachHang khachHang = session.get(KhachHang.class, id);
            transaction = session.beginTransaction();
            if (khachHang != null) {
                session.delete(khachHang);

            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
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
