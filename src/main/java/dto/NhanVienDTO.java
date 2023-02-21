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
public class NhanVienDTO {

    private UUID id;
    private String ma;
    private String ten;
    private String tenDem;

    private String ho;

    private String gioiTinh;

    private Date ngaySinh;

    private String diaChi;

    private String sdt;

    private String matKhau;

    private CuaHangDTO cuaHang;

    private ChucVuDTO chucVu;

    private NhanVienDTO nhanVien;

    private int trangThai;
}
