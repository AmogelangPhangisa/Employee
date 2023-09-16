/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.VisionZar.employeeManagement.service;

import com.VisionZar.employeeManagement.domain.Employee;
import java.util.List;
/**
 *
 * @author S2028873
 */
public interface EmployeeServiceLocal {

    Employee save(Employee employee);

    Employee findById(Long id);

    Employee update(Employee employee);

    void deleteAll();

    Employee deleteById(Long id);

    List<Employee> listAll();

    boolean isExist(Employee employee);

    Employee findUserByEmployeeId(String employeeId);
}
