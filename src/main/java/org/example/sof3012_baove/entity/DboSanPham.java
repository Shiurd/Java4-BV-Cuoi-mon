package org.example.sof3012_baove.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "dbo_san_pham")
public class DboSanPham {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 20)
    @Column(name = "ma", length = 20)
    private String ma;

    @Size(max = 30)
    @Column(name = "ten", length = 30)
    private String ten;

    @Size(max = 30)
    @Column(name = "mota", length = 30)
    private String mota;

    @Size(max = 30)
    @Column(name = "website", length = 30)
    private String website;

    @Column(name = "gia_ban")
    private Long giaBan;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @OneToMany(mappedBy = "idSp")
    private Set<DboHoaDonChiTiet> hoaDonChiTiet = new LinkedHashSet<>();
    

}