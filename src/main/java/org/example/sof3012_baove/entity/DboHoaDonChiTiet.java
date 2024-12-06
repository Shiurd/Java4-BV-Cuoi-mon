package org.example.sof3012_baove.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dbo_hoa_don_chi_tiet")
public class DboHoaDonChiTiet {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_sp")
    private DboSanPham idSp;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "don_gia")
    private Long donGia;

}