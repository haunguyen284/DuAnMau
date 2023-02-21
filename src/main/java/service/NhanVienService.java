/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import dto.NhanVienDTO;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author macbook
 */
public interface NhanVienService {

    List<NhanVienDTO> findAll(int position, int pageSize);
    
    List<NhanVienDTO> findAll();

    NhanVienDTO findById(UUID id);

    String create(NhanVienDTO nhanVienDTO);

    String update(NhanVienDTO nhanVienDTO);

    boolean delete(UUID id);

    long totalCount();

    NhanVienDTO findByMa(String maNVBC);

}
