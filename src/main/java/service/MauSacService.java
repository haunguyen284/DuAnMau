/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import dto.MauSacDTO;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author macbook
 */
public interface MauSacService {
    List<MauSacDTO> findAll(int position, int pageSize);
    
    List<MauSacDTO> findAll();

    MauSacDTO findById(UUID id);
    
    MauSacDTO findByMa(String ma);

    String create(MauSacDTO mauSacDTO);

    String update(MauSacDTO mauSacDTO);

    boolean delete(UUID id);

    long totalCount();
}
