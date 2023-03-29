package com.example.Buoi_9.repository;

import com.example.Buoi_9.entity.DongSP;


import com.example.Buoi_9.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
    public DongSP getById(String id) {
        DongSP dongSP = new DongSP();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            Query query = session.createQuery("from KhachHang where id =: id");
//            query.setParameter("id", id);
//            khachHang= (KhachHang) query.getSingleResult();
            dongSP = session.get(DongSP.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dongSP;
    }
    public Boolean add(DongSP dongSP) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(dongSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(DongSP dongSP) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(dongSP);
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
            DongSP dongSP = session.get(DongSP.class, id);
            transaction = session.beginTransaction();
            if (dongSP != null) {
                session.delete(dongSP);

            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<DongSP> list = new DongSpRepository().getAll();
        for (DongSP kh : list) {
            System.out.println(kh.toString());
        }
    }
}
