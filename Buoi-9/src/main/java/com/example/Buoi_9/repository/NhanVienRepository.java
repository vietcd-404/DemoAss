package com.example.Buoi_9.repository;

import com.example.Buoi_9.entity.ChucVu;
import com.example.Buoi_9.entity.NhanVien;
import com.example.Buoi_9.entity.CuaHang;
import com.example.Buoi_9.entity.NhanVien;
import com.example.Buoi_9.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
public class NhanVienRepository {
    public ArrayList<NhanVien> getAll() {
        ArrayList<NhanVien> listKhachHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NhanVien ");
            listKhachHang = (ArrayList<NhanVien>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;

    }
    public ArrayList<ChucVu> getAllChucVu() {
        ArrayList<ChucVu> listKhachHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from ChucVu ");
            listKhachHang = (ArrayList<ChucVu>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;

    }
    public ArrayList<CuaHang> getAllCuaHang() {
        ArrayList<CuaHang> listKhachHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from CuaHang ");
            listKhachHang = (ArrayList<CuaHang>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;

    }
    public Boolean add(NhanVien nhanVien) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public NhanVien getById(String id) {
        NhanVien nhanVien = new NhanVien();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            Query query = session.createQuery("from KhachHang where id =: id");
//            query.setParameter("id", id);
//            khachHang= (KhachHang) query.getSingleResult();
            nhanVien = session.get(NhanVien.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    public Boolean update(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(nhanVien);
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
            NhanVien nhanVien = session.get(NhanVien.class, id);
            transaction = session.beginTransaction();
            if (nhanVien != null) {
                session.delete(nhanVien);

            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<NhanVien> list = new NhanVienRepository().getAll();
        for (NhanVien kh : list) {
            System.out.println(kh.toString());
        }
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//
//        ChucVu chucVu = entityManager.find(ChucVu.class,);
//        System.out.println(chucVu);
    }
}
