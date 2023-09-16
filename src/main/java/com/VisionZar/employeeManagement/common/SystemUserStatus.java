/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.VisionZar.employeeManagement.common;

/**
 *
 * @author S2028873
 */
public enum SystemUserStatus {

    INACTIVE("Inactive"),
    ACTIVE("Active"),
    SUSPENDED("Suspended");

    private final String displayName;

    private SystemUserStatus(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }

}
