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
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author macbook
 */
@Entity(name = "NSX")
@AllArgsConstructor
@Getter
@Setter
public class NhaSanXuat extends BaseEntity implements Serializable {
}
