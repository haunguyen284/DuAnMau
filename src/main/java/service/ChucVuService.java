/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import dto.ChucVuDTO;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author macbook
 */
public interface ChucVuService {
    List<ChucVuDTO> findAll(int position, int pageSize);
    List<ChucVuDTO> findAll();
    ChucVuDTO findById(UUID id);
    ChucVuDTO findByMa(String ma);
    String create(ChucVuDTO chucVuDTO);
    String update(ChucVuDTO chucVuDTO);
    boolean delete(UUID id);
    long totalCount();
}
