package common.mapper;

import dto.ChucVuDTO;
import dto.CuaHangDTO;
import dto.HoaDonDTO;
import dto.KhachHangDTO;
import dto.NhanVienDTO;
import javax.annotation.processing.Generated;
import model.ChucVu;
import model.CuaHang;
import model.HoaDon;
import model.KhachHang;
import model.NhanVien;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T10:42:58+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
public class HoaDonMapperImpl implements HoaDonMapper {

    @Override
    public HoaDonDTO toDTO(HoaDon hoaDon) {
        if ( hoaDon == null ) {
            return null;
        }

        HoaDonDTO hoaDonDTO = new HoaDonDTO();

        hoaDonDTO.setId( hoaDon.getId() );
        hoaDonDTO.setKhachHang( khachHangToKhachHangDTO( hoaDon.getKhachHang() ) );
        hoaDonDTO.setNhanVien( nhanVienToNhanVienDTO( hoaDon.getNhanVien() ) );
        hoaDonDTO.setMa( hoaDon.getMa() );
        hoaDonDTO.setNgayTao( hoaDon.getNgayTao() );
        hoaDonDTO.setNgayThanhToan( hoaDon.getNgayThanhToan() );
        hoaDonDTO.setNgayShip( hoaDon.getNgayShip() );
        hoaDonDTO.setNgayNhan( hoaDon.getNgayNhan() );
        hoaDonDTO.setTinhTrang( hoaDon.getTinhTrang() );
        hoaDonDTO.setTenNguoiNhan( hoaDon.getTenNguoiNhan() );
        hoaDonDTO.setDiaChi( hoaDon.getDiaChi() );
        hoaDonDTO.setSdt( hoaDon.getSdt() );

        return hoaDonDTO;
    }

    @Override
    public HoaDon toModel(HoaDonDTO hoaDonDTO) {
        if ( hoaDonDTO == null ) {
            return null;
        }

        HoaDon hoaDon = new HoaDon();

        hoaDon.setId( hoaDonDTO.getId() );
        hoaDon.setKhachHang( khachHangDTOToKhachHang( hoaDonDTO.getKhachHang() ) );
        hoaDon.setNhanVien( nhanVienDTOToNhanVien( hoaDonDTO.getNhanVien() ) );
        hoaDon.setMa( hoaDonDTO.getMa() );
        hoaDon.setNgayTao( hoaDonDTO.getNgayTao() );
        hoaDon.setNgayThanhToan( hoaDonDTO.getNgayThanhToan() );
        hoaDon.setNgayShip( hoaDonDTO.getNgayShip() );
        hoaDon.setNgayNhan( hoaDonDTO.getNgayNhan() );
        hoaDon.setTinhTrang( hoaDonDTO.getTinhTrang() );
        hoaDon.setTenNguoiNhan( hoaDonDTO.getTenNguoiNhan() );
        hoaDon.setDiaChi( hoaDonDTO.getDiaChi() );
        hoaDon.setSdt( hoaDonDTO.getSdt() );

        return hoaDon;
    }

    protected KhachHangDTO khachHangToKhachHangDTO(KhachHang khachHang) {
        if ( khachHang == null ) {
            return null;
        }

        KhachHangDTO khachHangDTO = new KhachHangDTO();

        khachHangDTO.setId( khachHang.getId() );
        khachHangDTO.setMa( khachHang.getMa() );
        khachHangDTO.setTen( khachHang.getTen() );
        khachHangDTO.setTenDem( khachHang.getTenDem() );
        khachHangDTO.setHo( khachHang.getHo() );
        khachHangDTO.setNgaySinh( khachHang.getNgaySinh() );
        khachHangDTO.setDiaChi( khachHang.getDiaChi() );
        khachHangDTO.setSdt( khachHang.getSdt() );
        khachHangDTO.setThanhPho( khachHang.getThanhPho() );
        khachHangDTO.setQuocGia( khachHang.getQuocGia() );
        khachHangDTO.setMatKhau( khachHang.getMatKhau() );

        return khachHangDTO;
    }

    protected CuaHangDTO cuaHangToCuaHangDTO(CuaHang cuaHang) {
        if ( cuaHang == null ) {
            return null;
        }

        CuaHangDTO cuaHangDTO = new CuaHangDTO();

        cuaHangDTO.setId( cuaHang.getId() );
        cuaHangDTO.setMa( cuaHang.getMa() );
        cuaHangDTO.setTen( cuaHang.getTen() );
        cuaHangDTO.setDiaChi( cuaHang.getDiaChi() );
        cuaHangDTO.setThanhPho( cuaHang.getThanhPho() );
        cuaHangDTO.setQuocGia( cuaHang.getQuocGia() );

        return cuaHangDTO;
    }

    protected ChucVuDTO chucVuToChucVuDTO(ChucVu chucVu) {
        if ( chucVu == null ) {
            return null;
        }

        ChucVuDTO chucVuDTO = new ChucVuDTO();

        chucVuDTO.setId( chucVu.getId() );
        chucVuDTO.setMa( chucVu.getMa() );
        chucVuDTO.setTen( chucVu.getTen() );

        return chucVuDTO;
    }

    protected NhanVienDTO nhanVienToNhanVienDTO(NhanVien nhanVien) {
        if ( nhanVien == null ) {
            return null;
        }

        NhanVienDTO nhanVienDTO = new NhanVienDTO();

        nhanVienDTO.setId( nhanVien.getId() );
        nhanVienDTO.setMa( nhanVien.getMa() );
        nhanVienDTO.setTen( nhanVien.getTen() );
        nhanVienDTO.setTenDem( nhanVien.getTenDem() );
        nhanVienDTO.setHo( nhanVien.getHo() );
        nhanVienDTO.setGioiTinh( nhanVien.getGioiTinh() );
        nhanVienDTO.setNgaySinh( nhanVien.getNgaySinh() );
        nhanVienDTO.setDiaChi( nhanVien.getDiaChi() );
        nhanVienDTO.setSdt( nhanVien.getSdt() );
        nhanVienDTO.setMatKhau( nhanVien.getMatKhau() );
        nhanVienDTO.setCuaHang( cuaHangToCuaHangDTO( nhanVien.getCuaHang() ) );
        nhanVienDTO.setChucVu( chucVuToChucVuDTO( nhanVien.getChucVu() ) );
        nhanVienDTO.setNhanVien( nhanVienToNhanVienDTO( nhanVien.getNhanVien() ) );
        nhanVienDTO.setTrangThai( nhanVien.getTrangThai() );

        return nhanVienDTO;
    }

    protected KhachHang khachHangDTOToKhachHang(KhachHangDTO khachHangDTO) {
        if ( khachHangDTO == null ) {
            return null;
        }

        KhachHang khachHang = new KhachHang();

        khachHang.setId( khachHangDTO.getId() );
        khachHang.setMa( khachHangDTO.getMa() );
        khachHang.setTen( khachHangDTO.getTen() );
        khachHang.setTenDem( khachHangDTO.getTenDem() );
        khachHang.setHo( khachHangDTO.getHo() );
        khachHang.setNgaySinh( khachHangDTO.getNgaySinh() );
        khachHang.setDiaChi( khachHangDTO.getDiaChi() );
        khachHang.setSdt( khachHangDTO.getSdt() );
        khachHang.setThanhPho( khachHangDTO.getThanhPho() );
        khachHang.setQuocGia( khachHangDTO.getQuocGia() );
        khachHang.setMatKhau( khachHangDTO.getMatKhau() );

        return khachHang;
    }

    protected CuaHang cuaHangDTOToCuaHang(CuaHangDTO cuaHangDTO) {
        if ( cuaHangDTO == null ) {
            return null;
        }

        CuaHang cuaHang = new CuaHang();

        cuaHang.setId( cuaHangDTO.getId() );
        cuaHang.setMa( cuaHangDTO.getMa() );
        cuaHang.setTen( cuaHangDTO.getTen() );
        cuaHang.setDiaChi( cuaHangDTO.getDiaChi() );
        cuaHang.setThanhPho( cuaHangDTO.getThanhPho() );
        cuaHang.setQuocGia( cuaHangDTO.getQuocGia() );

        return cuaHang;
    }

    protected ChucVu chucVuDTOToChucVu(ChucVuDTO chucVuDTO) {
        if ( chucVuDTO == null ) {
            return null;
        }

        ChucVu chucVu = new ChucVu();

        chucVu.setId( chucVuDTO.getId() );
        chucVu.setMa( chucVuDTO.getMa() );
        chucVu.setTen( chucVuDTO.getTen() );

        return chucVu;
    }

    protected NhanVien nhanVienDTOToNhanVien(NhanVienDTO nhanVienDTO) {
        if ( nhanVienDTO == null ) {
            return null;
        }

        NhanVien nhanVien = new NhanVien();

        nhanVien.setId( nhanVienDTO.getId() );
        nhanVien.setMa( nhanVienDTO.getMa() );
        nhanVien.setTen( nhanVienDTO.getTen() );
        nhanVien.setTenDem( nhanVienDTO.getTenDem() );
        nhanVien.setHo( nhanVienDTO.getHo() );
        nhanVien.setGioiTinh( nhanVienDTO.getGioiTinh() );
        nhanVien.setNgaySinh( nhanVienDTO.getNgaySinh() );
        nhanVien.setDiaChi( nhanVienDTO.getDiaChi() );
        nhanVien.setSdt( nhanVienDTO.getSdt() );
        nhanVien.setMatKhau( nhanVienDTO.getMatKhau() );
        nhanVien.setCuaHang( cuaHangDTOToCuaHang( nhanVienDTO.getCuaHang() ) );
        nhanVien.setChucVu( chucVuDTOToChucVu( nhanVienDTO.getChucVu() ) );
        nhanVien.setNhanVien( nhanVienDTOToNhanVien( nhanVienDTO.getNhanVien() ) );
        nhanVien.setTrangThai( nhanVienDTO.getTrangThai() );

        return nhanVien;
    }
}
