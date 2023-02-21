/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package common.mapper;

import dto.MauSacDTO;
import model.MauSac;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author macbook
 */
@Mapper
public interface MauSacMapper {
    MauSacMapper INSTANCE = Mappers.getMapper(MauSacMapper.class);
    
    MauSac toModel(MauSacDTO mauSacDTO);
    
    MauSacDTO toDTO(MauSac mauSac);
}
