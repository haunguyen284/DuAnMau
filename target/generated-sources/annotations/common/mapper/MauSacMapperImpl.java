package common.mapper;

import dto.MauSacDTO;
import javax.annotation.processing.Generated;
import model.MauSac;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T10:42:59+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
public class MauSacMapperImpl implements MauSacMapper {

    @Override
    public MauSac toModel(MauSacDTO mauSacDTO) {
        if ( mauSacDTO == null ) {
            return null;
        }

        MauSac mauSac = new MauSac();

        mauSac.setId( mauSacDTO.getId() );
        mauSac.setMa( mauSacDTO.getMa() );
        mauSac.setTen( mauSacDTO.getTen() );

        return mauSac;
    }

    @Override
    public MauSacDTO toDTO(MauSac mauSac) {
        if ( mauSac == null ) {
            return null;
        }

        MauSacDTO mauSacDTO = new MauSacDTO();

        mauSacDTO.setId( mauSac.getId() );
        mauSacDTO.setMa( mauSac.getMa() );
        mauSacDTO.setTen( mauSac.getTen() );

        return mauSacDTO;
    }
}
