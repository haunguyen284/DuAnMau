package common.mapper;

import dto.ChucVuDTO;
import javax.annotation.processing.Generated;
import model.ChucVu;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T10:42:59+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
public class ChucVuMapperImpl implements ChucVuMapper {

    @Override
    public ChucVuDTO toDTO(ChucVu chucVu) {
        if ( chucVu == null ) {
            return null;
        }

        ChucVuDTO chucVuDTO = new ChucVuDTO();

        chucVuDTO.setId( chucVu.getId() );
        chucVuDTO.setMa( chucVu.getMa() );
        chucVuDTO.setTen( chucVu.getTen() );

        return chucVuDTO;
    }

    @Override
    public ChucVu toModel(ChucVuDTO chucVuDTO) {
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
