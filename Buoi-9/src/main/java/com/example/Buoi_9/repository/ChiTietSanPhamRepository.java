package com.example.Buoi_9.repository;

import com.example.Buoi_9.entity.*;

import com.example.Buoi_9.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class ChiTietSanPhamRepository {
    public ArrayList<ChiTietSanPham> getAll() {
        ArrayList<ChiTietSanPham> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from ChiTietSanPham ");
            list = (ArrayList<ChiTietSanPham>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
    public ArrayList<SanPham> getAllSanPham() {
        ArrayList<SanPham> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from SanPham");
            list = (ArrayList<SanPham>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
    public ArrayList<NSX> getAllNSX() {
        ArrayList<NSX> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NSX");
            list = (ArrayList<NSX>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }public ArrayList<DongSP> getAllDongSP() {
        ArrayList<DongSP> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from DongSP");
            list = (ArrayList<DongSP>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }public ArrayList<MauSac> getAllMauSac() {
        ArrayList<MauSac> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from MauSac");
            list = (ArrayList<MauSac>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
    public ChiTietSanPham getById(String id) {
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            Query query = session.createQuery("from KhachHang where id =: id");
//            query.setParameter("id", id);
//            khachHang= (KhachHang) query.getSingleResult();
            chiTietSanPham = session.get(ChiTietSanPham.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSanPham;
    }
    public Boolean add(ChiTietSanPham chiTietSanPham) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(chiTietSanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(ChiTietSanPham chiTietSanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(chiTietSanPham);
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
            ChiTietSanPham user = session.get(ChiTietSanPham.class, id);
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
        ArrayList<ChiTietSanPham> list = new ChiTietSanPhamRepository().getAll();
        for (ChiTietSanPham kh : list) {
            System.out.println(kh.toString());
        }
    }

}

