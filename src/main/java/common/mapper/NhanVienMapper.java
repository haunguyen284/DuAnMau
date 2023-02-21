/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package common.mapper;

import dto.NhanVienDTO;
import model.NhanVien;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author macbook
 */
@Mapper
public interface NhanVienMapper {
    NhanVienMapper INSTANCE = Mappers.getMapper(NhanVienMapper.class);
    
    NhanVienDTO toDTO(NhanVien nhanVien);
    
    NhanVien toModel(NhanVienDTO nhanVienDTO);
    
}
