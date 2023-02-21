/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import common.model.BaseEntity;
import java.io.Serializable;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author macbook
 */
@Entity(name = "DongSP")
@AllArgsConstructor
@Getter
@Setter

public class DongSanPham extends BaseEntity implements Serializable {

}
