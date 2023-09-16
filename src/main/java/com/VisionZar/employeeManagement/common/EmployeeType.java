/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.VisionZar.employeeManagement.common;

/**
 *
 * @author S2028873
 */
public enum EmployeeType {
   ADMIN("Administrator");

    private final String displayName;

    EmployeeType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }

}
