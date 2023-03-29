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
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet implements Serializable {
//    @Id
//    @ManyToMany
//    @JoinTable(name = "GioHangChiTiet",
//            joinColumns = {@JoinColumn(name = "IdChiTietSP")},
//            inverseJoinColumns = {@JoinColumn(name = "IdChiTietSP")})
    @Id
    @ManyToOne
    @JoinColumn(name ="IdHoaDon",nullable = false)
    private HoaDon hoaDon;

    @Id
    @ManyToOne
    @JoinColumn(name ="IdChiTietSP",nullable = false)
    private ChiTietSanPham chiTietSanPham;


    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private double donGia;

    public HoaDonChiTiet() {
    }

}
