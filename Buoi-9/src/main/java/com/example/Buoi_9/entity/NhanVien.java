package com.example.Buoi_9.entity;



import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@Data
@Getter
@Setter
@Entity

@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "MatKhau")
    private String matKhau;

    @ManyToOne
    @JoinColumn(name ="IdCV",nullable = false)
    private ChucVu chucVu;

    @ManyToOne
    @JoinColumn(name ="IdCH",nullable = false)
    private CuaHang cuaHang;

    /*@ManyToOne
    @JoinColumn(name ="IdGuiBC",nullable = false)
    private NhanVien nhanVien;*/

    @Column(name = "TrangThai")
    private int trangThai;

    public NhanVien() {

    }

    @OneToMany(mappedBy = "nhanVien",fetch = FetchType.LAZY)
    private List<HoaDon> hoaDonList;

    @OneToMany(mappedBy = "nhanVien",fetch = FetchType.LAZY)
    private List<GioHang> gioHangList;

    @Override
    public String toString() {
        return "NhanVien{" +
                "id='" + id + '\'' +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                ", tenDem='" + tenDem + '\'' +
                ", ho='" + ho + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", chucVu=" + chucVu +
                ", cuaHang=" + cuaHang +

                ", trangThai=" + trangThai +
                '}';
    }
}

