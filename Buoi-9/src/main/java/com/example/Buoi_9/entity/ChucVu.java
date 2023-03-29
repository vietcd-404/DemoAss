package com.example.Buoi_9.entity;



import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor

@Data
@Getter
@Setter
@Entity
@ToString
@Table(name = "ChucVu")
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @OneToMany(mappedBy = "chucVu",fetch = FetchType.EAGER)
    private List<NhanVien> listNv ;


    public ChucVu() {

    }

    @Override
    public String toString() {
        return "ChucVu{" +
                "id='" + id + '\'' +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +

                '}';
    }

}
