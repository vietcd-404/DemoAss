package com.example.Buoi_9.repository;

import com.example.Buoi_9.entity.SanPham;
import com.example.Buoi_9.entity.SanPham;
import com.example.Buoi_9.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class SanPhamRepository {
    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> listKhachHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from SanPham");
            listKhachHang = (ArrayList<SanPham>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;

    }
    public SanPham getById(String id) {
        SanPham sanPham = new SanPham();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            Query query = session.createQuery("from KhachHang where id =: id");
//            query.setParameter("id", id);
//            khachHang= (KhachHang) query.getSingleResult();
            sanPham = session.get(SanPham.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }
    public Boolean add(SanPham sanPham) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(sanPham);
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
            SanPham sanPham = session.get(SanPham.class, id);
            transaction = session.beginTransaction();
            if (sanPham != null) {
                session.delete(sanPham);
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<SanPham> list = new SanPhamRepository().getAll();
        for (SanPham kh : list) {
            System.out.println(kh.toString());
        }
    }
}
