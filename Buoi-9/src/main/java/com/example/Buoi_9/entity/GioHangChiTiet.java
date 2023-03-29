package com.example.Buoi_9.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "GioHangChiTiet")
public class GioHangChiTiet implements Serializable {
//    @ManyToMany
//    @JoinTable(name = "GioHangChiTiet",
//            joinColumns = { @JoinColumn(name = "IdGioHang") },
//            inverseJoinColumns = { @JoinColumn(name = "IdChiTietSP") })
    @Id
    @ManyToOne
    @JoinColumn(name ="IdGioHang",nullable = false)
    private GioHang gioHang;

    @Id
    @ManyToOne
    @JoinColumn(name ="IdChiTietSP",nullable = false)
    private ChiTietSanPham chiTietSanPham;


    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private double donGia;

    @Column(name = "DonGiaKhiGiam")
    private double donGiaKhiGiam;

    public GioHangChiTiet() {

    }
}
