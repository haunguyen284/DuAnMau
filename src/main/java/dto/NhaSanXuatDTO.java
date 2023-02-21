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
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class NhaSanXuatDTO {

    private UUID id;
    private String ma;
    private String ten;
}
