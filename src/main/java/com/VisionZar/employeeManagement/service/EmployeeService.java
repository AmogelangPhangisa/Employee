/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VisionZar.employeeManagement.service;

import com.VisionZar.employeeManagement.domain.Employee;
import com.VisionZar.employeeManagement.persistence.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author S2028873
 */
@Service
public class EmployeeService implements EmployeeServiceLocal {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("the requested id[ " + id + "] does not exist."));
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Override
    public Employee deleteById(Long id) {
        Employee employee = findById(id);
        if (employee != null) {
            employeeRepository.deleteById(id);
        }
        return employee;
    }

    @Override
    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean isExist(Employee employee) {
        return employeeRepository.findById(employee.getId()) != null;
    }

    @Override
    public Employee findUserByEmployeeId(String employeeId) {
    return employeeRepository.findUserByEmployeeId(employeeId);
    }
}
