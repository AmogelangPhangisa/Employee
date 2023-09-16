/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VisionZar.employeeManagement.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author S2028873
 */
@Setter
@Getter
@Entity
@Table(name = "employee")
@Audited
public class Employee extends Person{
   
    @Column(name = "employee_id")
     @Pattern(regexp = "^[0-9]{8}$", message = "Employee Number should Be 8 Digits")
    private String employeeId;

}