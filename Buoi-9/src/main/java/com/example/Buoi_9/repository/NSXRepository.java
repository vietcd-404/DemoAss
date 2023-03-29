package com.example.Buoi_9.repository;

import com.example.Buoi_9.entity.NSX;
import com.example.Buoi_9.entity.NSX;

import com.example.Buoi_9.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
    public NSX getById(String id) {
        NSX nsx = new NSX();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            Query query = session.createQuery("from KhachHang where id =: id");
//            query.setParameter("id", id);
//            khachHang= (KhachHang) query.getSingleResult();
            nsx = session.get(NSX.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nsx;
    }
    public Boolean add(NSX nsx) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(NSX nsx) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(nsx);
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
            NSX nsx = session.get(NSX.class, id);
            transaction = session.beginTransaction();
            if (nsx != null) {
                session.delete(nsx);

            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<NSX> list = new NSXRepository().getAll();
        for (NSX kh : list) {
            System.out.println(kh.toString());
        }
    }
}
