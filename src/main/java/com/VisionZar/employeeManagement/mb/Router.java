/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VisionZar.employeeManagement.mb;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author S2028873
 */
@Getter
@Setter
public class Router {
  private boolean adminstrator;

    public Router reset() {
        this.adminstrator =Boolean.FALSE;
        return this;
    }
}