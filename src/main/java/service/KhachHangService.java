/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import dto.KhachHangDTO;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author macbook
 */
public interface KhachHangService {

    List<KhachHangDTO> findAll(int position, int pageSize);

    KhachHangDTO findById(UUID id);
    
    KhachHangDTO findByMa(String ma);

    String create(KhachHangDTO khachHangDTO);

    String update(KhachHangDTO khachHangDTO);

    boolean delete(UUID id);

    long totalCount();

    List<KhachHangDTO> findAll();
}
