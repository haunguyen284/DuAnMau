/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package common.mapper;

import dto.KhachHangDTO;
import model.KhachHang;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author macbook
 */
@Mapper
public interface KhachHangMapper {
    KhachHangMapper INSTANCE = Mappers.getMapper(KhachHangMapper.class);
    KhachHangDTO toDTO(KhachHang khachHang);
    KhachHang toModel(KhachHangDTO khachHangDTO);
    
}
