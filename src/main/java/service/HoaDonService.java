/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import dto.HoaDonDTO;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author macbook
 */
public interface HoaDonService {
    
    List<HoaDonDTO> findAll(int position, int pageSize);

    HoaDonDTO findById(UUID id);

    String create(HoaDonDTO hoaDonDTO);

    String update(HoaDonDTO hoaDonDTO);

    boolean delete(UUID id);

    long totalCount();
}
