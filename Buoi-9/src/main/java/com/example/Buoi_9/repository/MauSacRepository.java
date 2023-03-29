package com.example.Buoi_9.repository;

import com.example.Buoi_9.entity.MauSac;
import com.example.Buoi_9.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class MauSacRepository {
    public ArrayList<MauSac> getAll() {
        ArrayList<MauSac> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from MauSac");
            list = (ArrayList<MauSac>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
    public MauSac getById(String id) {
        MauSac mauSac = new MauSac();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            Query query = session.createQuery("from KhachHang where id =: id");
//            query.setParameter("id", id);
//            khachHang= (KhachHang) query.getSingleResult();
            mauSac = session.get(MauSac.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mauSac;
    }
    public Boolean add(MauSac chucVu) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(MauSac chucVu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(chucVu);
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
            MauSac user = session.get(MauSac.class, id);
            transaction = session.beginTransaction();
            if (user != null) {
                session.delete(user);

            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<MauSac> list = new MauSacRepository().getAll();
        for (MauSac kh : list) {
            System.out.println(kh.toString());
        }
    }
}
