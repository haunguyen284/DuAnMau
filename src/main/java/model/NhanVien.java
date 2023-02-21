/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import common.model.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

/**
 *
 * @author macbook
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NhanVien extends BaseEntity implements Serializable{

    @Column(name = "TenDem")
    @Nationalized
    private String tenDem;

    @Column(name = "Ho")
    @Nationalized
    private String ho;

    @Column(name = "GioiTinh")
    @Nationalized
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "DiaChi")
    @Nationalized
    private String diaChi;

    @Column(name = "Sdt")
    @Pattern(regexp = "0[0-9]{9,10}", message = "SDT chưa hợp lệ")
    private String sdt;
    
    @Column(name = "MatKhau")
    private String matKhau;
    
    @ManyToOne
    @JoinColumn(name = "IdCH")
    private CuaHang cuaHang;
    
    @ManyToOne
    @JoinColumn(name = "IdCV")
    private ChucVu chucVu;
    
    @ManyToOne
    @JoinColumn(name = "IdGuiBC")
    private NhanVien nhanVien;
    
    @Column(name = "TrangThai")
    private int trangThai;

}
