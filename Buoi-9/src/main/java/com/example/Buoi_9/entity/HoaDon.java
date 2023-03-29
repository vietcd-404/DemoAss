package com.example.Buoi_9.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "HoaDon")
public class HoaDon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "IdKH", nullable = false)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "IdNV", nullable = false)
    private NhanVien nhanVien;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "NgayShip")
    private Date ngayShip;

    @Column(name = "NgayNhan")
    private Date ngayNhan;

    @Column(name = "TinhTrang")
    private int tinhTrang;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @OneToMany(mappedBy = "hoaDon",fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> hoaDonChiTietList;

    public HoaDon() {

    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "id='" + id + '\'' +

                ", ma='" + ma + '\'' +
                ", ngayTao=" + ngayTao +
                ", ngayThanhToan=" + ngayThanhToan +
                ", ngayShip=" + ngayShip +
                ", ngayNhan=" + ngayNhan +
                ", tinhTrang=" + tinhTrang +
                ", tenNguoiNhan='" + tenNguoiNhan + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +

                '}';
    }
}
