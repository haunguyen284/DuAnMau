/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author macbook
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass

public class BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    protected UUID id;

    @Column(name = "Ma", unique = true)
    @NotBlank(message = "Mã không được để trống")
    protected String ma;

    @Column(name = "Ten")
    @Nationalized
    @NotBlank(message = "Tên không được để trống")
    protected String ten;
}
