/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import dto.DongSanPhamDTO;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author macbook
 */
public interface DongSanPhamService {
    List<DongSanPhamDTO> findAll(int position, int pageSize);
    
    List<DongSanPhamDTO> findAll();

    DongSanPhamDTO findById(UUID id);
    
    DongSanPhamDTO findByMa(String ma);

    String create(DongSanPhamDTO dongSanPhamDTO);

    String update(DongSanPhamDTO dongSanPhamDTO);

    boolean delete(UUID id);

    long totalCount();
}
