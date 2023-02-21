/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author macbook
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CuaHang implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(name = "Ma")
    @NotBlank(message = "Mã không được trống")
    private String ma;

    @Column(name = "Ten")
    @NotBlank(message = "Tên không được trống")
    @Nationalized
    private String ten;

    @Column(name = "DiaChi")
    @Nationalized
    private String diaChi;

    @Column(name = "ThanhPho")
    @Nationalized
    private String thanhPho;

    @Column(name = "QuocGia")
    @Nationalized
    private String quocGia;

}
