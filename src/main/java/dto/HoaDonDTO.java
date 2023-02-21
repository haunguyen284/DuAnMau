/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author macbook
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HoaDonDTO {
    private UUID id;
    
    private KhachHangDTO khachHang;
    
    private NhanVienDTO nhanVien;
    
    private String ma;
    
    private Date ngayTao;
    
    private Date ngayThanhToan;
    
    private Date ngayShip;
    
    private Date ngayNhan;
    
    private int tinhTrang;
    
    private String tenNguoiNhan;
    
    private String diaChi;
    
    private String sdt;
    
}
