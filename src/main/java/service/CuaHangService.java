/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import dto.CuaHangDTO;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author macbook
 */
public interface CuaHangService {

    List<CuaHangDTO> findAll(int position, int pageSize);
    
    List<CuaHangDTO> findAll();

    CuaHangDTO findById(UUID id);
    
    CuaHangDTO findByMa(String ma);


    String create(CuaHangDTO cuaHangDTO);

    String update(CuaHangDTO cuaHangDTO);

    boolean delete(UUID id);

    long totalCount();
}
