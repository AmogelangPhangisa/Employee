/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.VisionZar.employeeManagement.persistence;

import com.VisionZar.employeeManagement.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author S2028873
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    Employee findUserByEmployeeId(String employeeId);
}
