/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author macbook
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DongSanPhamDTO{
    private UUID id;
    private String ma;
    private String ten;
    
}
