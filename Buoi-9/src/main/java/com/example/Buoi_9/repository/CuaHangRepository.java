package com.example.Buoi_9.repository;

import com.example.Buoi_9.entity.CuaHang;

import com.example.Buoi_9.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
    public CuaHang getById(String id) {
        CuaHang chucVu = new CuaHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            Query query = session.createQuery("from KhachHang where id =: id");
//            query.setParameter("id", id);
//            khachHang= (KhachHang) query.getSingleResult();
            chucVu = session.get(CuaHang.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return chucVu;
    }
    public Boolean add(CuaHang chucVu) {
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
    public Boolean update(CuaHang chucVu) {
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
            CuaHang user = session.get(CuaHang.class, id);
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
        ArrayList<CuaHang> list = new CuaHangRepository().getAll();
        for (CuaHang kh : list) {
            System.out.println(kh.toString());
        }
    }
}
