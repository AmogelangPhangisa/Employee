/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VisionZar.employeeManagement.tests;

import com.VisionZar.employeeManagement.common.SystemUserStatus;
import com.VisionZar.employeeManagement.config.TestDataSourceConfiguration;
import com.VisionZar.employeeManagement.domain.Employee;
import com.VisionZar.employeeManagement.domain.User;
import com.VisionZar.employeeManagement.service.EmployeeServiceLocal;
import com.VisionZar.employeeManagement.service.UserServiceLocal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
/**
 *
 * @author S2028873
 */
@EnableJpaAuditing
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestDataSourceConfiguration.class)
public class ServiceLayerTest {

    @Autowired
    private EmployeeServiceLocal employeeService;

    @Autowired
    private UserServiceLocal userService;

    public ServiceLayerTest() {

    }

    @BeforeClass
    public static void getUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void TestA() {
        Employee employee = EmployeeHelper.addEmployee("00000001");
        employeeService.save(employee);
    }

    @Test
    public void TestB() {
        User user = EmployeeHelper.addUser("Test", "Test", "Test", "", SystemUserStatus.ACTIVE);
        userService.save(user);
    }
}
