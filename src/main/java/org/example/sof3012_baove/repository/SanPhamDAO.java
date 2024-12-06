package org.example.sof3012_baove.repository;

import org.example.sof3012_baove.entity.DboHoaDonChiTiet;
import org.example.sof3012_baove.entity.DboSanPham;
import org.example.sof3012_baove.utility.HibernateConnection;

import java.util.List;

public class SanPhamDAO {

    public List<DboSanPham> getAllSanPham() {
        try(var session = HibernateConnection.getFACTORY().openSession()) {
            return session.createQuery("from DboSanPham", DboSanPham.class).getResultList();
        }
    }

    public void addSanPham(DboSanPham sanPham) {
        try(var session = HibernateConnection.getFACTORY().openSession()) {
            session.beginTransaction();
            session.save(sanPham);
            session.getTransaction().commit();
        }
    }

    public DboSanPham getSanPhamById(int id) {
        try(var session = HibernateConnection.getFACTORY().openSession()) {
            return session.get(DboSanPham.class, id);
        }
    }

    public void deleteSanPham(int id) {
        try(var session = HibernateConnection.getFACTORY().openSession()) {
            session.beginTransaction();
            var sanPham = session.get(DboSanPham.class, id);
            session.delete(sanPham);
            session.getTransaction().commit();
        }
    }

    public List<DboHoaDonChiTiet> getAllHoaDonChiTiet() {
        try(var session = HibernateConnection.getFACTORY().openSession()) {
            return session.createQuery("from DboHoaDonChiTiet", DboHoaDonChiTiet.class).getResultList();
        }
    }

    public DboHoaDonChiTiet getHoaDonChiTietById(int id) {
        try(var session = HibernateConnection.getFACTORY().openSession()) {
            return session.get(DboHoaDonChiTiet.class, id);
        }
    }
}
