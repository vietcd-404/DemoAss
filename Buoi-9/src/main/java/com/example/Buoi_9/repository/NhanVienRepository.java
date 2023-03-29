package com.example.Buoi_9.repository;

import com.example.Buoi_9.entity.ChucVu;
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
