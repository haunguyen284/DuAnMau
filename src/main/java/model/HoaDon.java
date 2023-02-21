/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class HoaDon implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;
    
    @JoinColumn(name = "IdKH")
    @ManyToOne
    private KhachHang khachHang;
    
    @ManyToOne
    @JoinColumn(name = "IdNV")
    private NhanVien nhanVien;
    
    @Column(name = "Ma", unique = true)
    private String ma;
    
    @Column(name = "NgayTao", nullable = true)
    private Date ngayTao;
    
    @Column(name = "NgayThanhToan", nullable = true)
    private Date ngayThanhToan;
    
    @Column(name = "NgayShip", nullable = true)
    private Date ngayShip;
    
    @Column(name = "NgayNhan", nullable = true)
    private Date ngayNhan;
    
    @Column(name = "TinhTrang", nullable = false)
    private int tinhTrang;
    
    @Column(name = "TenNguoiNhan", nullable = true)
    @Nationalized
    private String tenNguoiNhan;
    
    @Column(name = "DiaChi", nullable = true)
    @Nationalized
    private String diaChi;
    
    @Column(name = "Sdt", nullable = true)
    @Pattern(regexp = "0[0-9]{9,10}", message = "SDT chưa hợp lệ")
    private String sdt;  
}
