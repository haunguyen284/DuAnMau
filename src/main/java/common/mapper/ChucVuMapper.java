/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.mapper;

import dto.ChucVuDTO;
import model.ChucVu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author macbook
 */
@Mapper
public interface ChucVuMapper {
    ChucVuMapper INSTANCE = Mappers.getMapper(ChucVuMapper.class);
    
    ChucVuDTO toDTO(ChucVu chucVu);
    
    ChucVu toModel(ChucVuDTO chucVuDTO);
}
