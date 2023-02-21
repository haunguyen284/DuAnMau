/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import dto.NhaSanXuatDTO;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author macbook
 */
public interface NhaSanXuatService {
    List<NhaSanXuatDTO> findAll(int position, int pageSize);
    
    List<NhaSanXuatDTO> findAll();

    NhaSanXuatDTO findById(UUID id);
    
    NhaSanXuatDTO findByMa(String ma);

    String create(NhaSanXuatDTO nhaSanXuatDTO);

    String update(NhaSanXuatDTO nhaSanXuatDTO);

    boolean delete(UUID id);

    long totalCount();
}
