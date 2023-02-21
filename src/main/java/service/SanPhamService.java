/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import dto.SanPhamDTO;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author macbook
 */
public interface SanPhamService {
    List<SanPhamDTO> findAll(int position, int pageSize);
    
    List<SanPhamDTO> findAll();

    SanPhamDTO findById(UUID id);
    
    SanPhamDTO findByMa(String ma);

    String create(SanPhamDTO sanPhamDTO);

    String update(SanPhamDTO sanPhamDTO);

    boolean delete(UUID id);

    long totalCount();
}
