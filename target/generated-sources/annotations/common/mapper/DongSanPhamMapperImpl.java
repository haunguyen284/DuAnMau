package common.mapper;

import dto.DongSanPhamDTO;
import java.util.UUID;
import javax.annotation.processing.Generated;
import model.DongSanPham;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T10:42:59+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
public class DongSanPhamMapperImpl implements DongSanPhamMapper {

    @Override
    public DongSanPham toModel(DongSanPhamDTO dongSanPhamDTO) {
        if ( dongSanPhamDTO == null ) {
            return null;
        }

        DongSanPham dongSanPham = new DongSanPham();

        dongSanPham.setId( dongSanPhamDTO.getId() );
        dongSanPham.setMa( dongSanPhamDTO.getMa() );
        dongSanPham.setTen( dongSanPhamDTO.getTen() );

        return dongSanPham;
    }

    @Override
    public DongSanPhamDTO toDTO(DongSanPham dongSanPham) {
        if ( dongSanPham == null ) {
            return null;
        }

        UUID id = null;
        String ma = null;
        String ten = null;

        id = dongSanPham.getId();
        ma = dongSanPham.getMa();
        ten = dongSanPham.getTen();

        DongSanPhamDTO dongSanPhamDTO = new DongSanPhamDTO( id, ma, ten );

        return dongSanPhamDTO;
    }
}
