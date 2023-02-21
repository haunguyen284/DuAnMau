/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.mapper;

import dto.SanPhamDTO;
import model.SanPham;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author macbook
 */
@Mapper
public interface SanPhamMapper {
    SanPhamMapper INSTANCE = Mappers.getMapper(SanPhamMapper.class);
    
    SanPham toModel(SanPhamDTO sanPhamDTO);
    
    SanPhamDTO toDTO(SanPham sanPham);
}
