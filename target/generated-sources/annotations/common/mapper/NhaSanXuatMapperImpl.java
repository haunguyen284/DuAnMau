package common.mapper;

import dto.NhaSanXuatDTO;
import javax.annotation.processing.Generated;
import model.NhaSanXuat;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T10:42:59+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
public class NhaSanXuatMapperImpl implements NhaSanXuatMapper {

    @Override
    public NhaSanXuat toModel(NhaSanXuatDTO nhaSanXuatDTO) {
        if ( nhaSanXuatDTO == null ) {
            return null;
        }

        NhaSanXuat nhaSanXuat = new NhaSanXuat();

        nhaSanXuat.setId( nhaSanXuatDTO.getId() );
        nhaSanXuat.setMa( nhaSanXuatDTO.getMa() );
        nhaSanXuat.setTen( nhaSanXuatDTO.getTen() );

        return nhaSanXuat;
    }

    @Override
    public NhaSanXuatDTO toDTO(NhaSanXuat nhaSanXuat) {
        if ( nhaSanXuat == null ) {
            return null;
        }

        NhaSanXuatDTO nhaSanXuatDTO = new NhaSanXuatDTO();

        nhaSanXuatDTO.setId( nhaSanXuat.getId() );
        nhaSanXuatDTO.setMa( nhaSanXuat.getMa() );
        nhaSanXuatDTO.setTen( nhaSanXuat.getTen() );

        return nhaSanXuatDTO;
    }
}
