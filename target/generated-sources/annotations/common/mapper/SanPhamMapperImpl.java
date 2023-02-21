package common.mapper;

import dto.SanPhamDTO;
import javax.annotation.processing.Generated;
import model.SanPham;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T10:42:59+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
public class SanPhamMapperImpl implements SanPhamMapper {

    @Override
    public SanPham toModel(SanPhamDTO sanPhamDTO) {
        if ( sanPhamDTO == null ) {
            return null;
        }

        SanPham sanPham = new SanPham();

        sanPham.setId( sanPhamDTO.getId() );
        sanPham.setMa( sanPhamDTO.getMa() );
        sanPham.setTen( sanPhamDTO.getTen() );

        return sanPham;
    }

    @Override
    public SanPhamDTO toDTO(SanPham sanPham) {
        if ( sanPham == null ) {
            return null;
        }

        SanPhamDTO sanPhamDTO = new SanPhamDTO();

        sanPhamDTO.setId( sanPham.getId() );
        sanPhamDTO.setMa( sanPham.getMa() );
        sanPhamDTO.setTen( sanPham.getTen() );

        return sanPhamDTO;
    }
}
