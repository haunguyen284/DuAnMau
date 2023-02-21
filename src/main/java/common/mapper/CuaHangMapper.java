/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.mapper;

import dto.CuaHangDTO;
import model.CuaHang;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author macbook
 */
@Mapper
public interface CuaHangMapper {
    CuaHangMapper INSTANCE = Mappers.getMapper(CuaHangMapper.class);
    
    CuaHangDTO toDTO(CuaHang cuaHang);
    
    CuaHang toModel(CuaHangDTO cuaHangDTO);
    
}
