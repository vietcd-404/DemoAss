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
@Table(name = "DongSP")
public class DongSP implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @OneToMany(mappedBy = "dongSP",fetch = FetchType.LAZY)
    private List<ChiTietSanPham> chiTietSanPhamList;

    public DongSP() {

    }
}
