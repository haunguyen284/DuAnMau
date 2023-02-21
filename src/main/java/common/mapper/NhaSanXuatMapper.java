/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.mapper;

import dto.NhaSanXuatDTO;
import model.NhaSanXuat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author macbook
 */
@Mapper
public interface NhaSanXuatMapper {
    NhaSanXuatMapper INSTANCE = Mappers.getMapper(NhaSanXuatMapper.class);
    
    NhaSanXuat toModel(NhaSanXuatDTO nhaSanXuatDTO);
    
    NhaSanXuatDTO toDTO(NhaSanXuat nhaSanXuat);
}
