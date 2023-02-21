package common.mapper;

import dto.KhachHangDTO;
import javax.annotation.processing.Generated;
import model.KhachHang;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T10:42:59+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
public class KhachHangMapperImpl implements KhachHangMapper {

    @Override
    public KhachHangDTO toDTO(KhachHang khachHang) {
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

    @Override
    public KhachHang toModel(KhachHangDTO khachHangDTO) {
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
}
