package common.mapper;

import dto.CuaHangDTO;
import javax.annotation.processing.Generated;
import model.CuaHang;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T10:42:59+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
public class CuaHangMapperImpl implements CuaHangMapper {

    @Override
    public CuaHangDTO toDTO(CuaHang cuaHang) {
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

    @Override
    public CuaHang toModel(CuaHangDTO cuaHangDTO) {
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
}
