package com.example.Buoi_9.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "ChiTietSanPham")
public class ChiTietSanPham implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private String id;

    @ManyToOne
    @JoinColumn(name ="IdSP",nullable = false)
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name ="IdNsx",nullable = false)
    private NSX nsx;

    @ManyToOne
    @JoinColumn(name ="IdMauSac",nullable = false)
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name ="IdDongSP",nullable = false)
    private DongSP dongSP;

    @Column(name = "NamBH")
    private int namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private String soLuongTon;

    @Column(name = "GiaNhap")
    private double giaNhap;

    @Column(name = "GiaBan")
    private double giaBan;

    @OneToMany(mappedBy = "chiTietSanPham",fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> hoaDonChiTietList;

    @OneToMany(mappedBy = "chiTietSanPham",fetch = FetchType.LAZY)
    private List<GioHangChiTiet> gioHangChiTietList;

    public ChiTietSanPham() {
    }

}
