/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package common.mapper;

import dto.HoaDonDTO;
import model.HoaDon;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author macbook
 */
@Mapper
public interface HoaDonMapper {
    HoaDonMapper INSTANCE = Mappers.getMapper(HoaDonMapper.class);
    
    HoaDonDTO toDTO(HoaDon hoaDon);
    
    HoaDon toModel(HoaDonDTO hoaDonDTO);
    
}
