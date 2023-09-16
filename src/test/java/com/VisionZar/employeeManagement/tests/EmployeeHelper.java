/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VisionZar.employeeManagement.tests;

import com.VisionZar.employeeManagement.common.PersonType;
import com.VisionZar.employeeManagement.common.SystemUserStatus;
import com.VisionZar.employeeManagement.domain.Employee;
import com.VisionZar.employeeManagement.domain.User;
import java.util.Date;

/**
 *
 * @author S2028873
 */
public class EmployeeHelper {

    public static Employee addEmployee(String employeeId) {
        Employee employee = new Employee();
        employee.setCreatedBy("Test");
        employee.setCreatedDate(new Date());
        employee.setPersonType(PersonType.EMPLOYEE);
        employee.setEmployeeId(employeeId);
        employee.setFirstName("Amogelang");
        employee.setLastName("Phangisa");
        employee.setEmail("amogelangphangi@gmail.com");
        employee.setCellphoneNumber("0837352893");
        employee.setIdentityNumber("9303105724044");

        return employee;
    }

    public static User addUser(String UserName, String password, String confirmPassword, String changePassword, SystemUserStatus systemUserStatus) {

        User user = new User();
        user.setCreatedBy("Test");
        user.setCreatedDate(new Date());
        user.setPersonType(PersonType.ADMINISTRATOR);
        user.setUserName(UserName);
        user.setPassword(password);
        user.setChangePassword(changePassword);
        user.setConfirmPassword(confirmPassword);
        user.setSystemUserStatus(systemUserStatus);
        user.setFirstName("Amo");
        user.setLastName("Park");
        user.setEmail("amogelangphangi@gmail.com");
        user.setCellphoneNumber("0837352893");
        user.setIdentityNumber("9309105724088");
        user.setIdentifer(user.getIdentityNumber());

        return user;
    }
}
