/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.mapper;

import dto.DongSanPhamDTO;
import model.DongSanPham;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author macbook
 */
@Mapper
public interface DongSanPhamMapper {
    DongSanPhamMapper INSTANCE = Mappers.getMapper(DongSanPhamMapper.class);
    
    DongSanPham toModel(DongSanPhamDTO dongSanPhamDTO);
    
    DongSanPhamDTO toDTO(DongSanPham dongSanPham);
}
