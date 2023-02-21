package common.mapper;

import dto.ChucVuDTO;
import dto.CuaHangDTO;
import dto.NhanVienDTO;
import javax.annotation.processing.Generated;
import model.ChucVu;
import model.CuaHang;
import model.NhanVien;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T10:42:59+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
public class NhanVienMapperImpl implements NhanVienMapper {

    @Override
    public NhanVienDTO toDTO(NhanVien nhanVien) {
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
        nhanVienDTO.setNhanVien( toDTO( nhanVien.getNhanVien() ) );
        nhanVienDTO.setTrangThai( nhanVien.getTrangThai() );

        return nhanVienDTO;
    }

    @Override
    public NhanVien toModel(NhanVienDTO nhanVienDTO) {
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
        nhanVien.setNhanVien( toModel( nhanVienDTO.getNhanVien() ) );
        nhanVien.setTrangThai( nhanVienDTO.getTrangThai() );

        return nhanVien;
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
}
