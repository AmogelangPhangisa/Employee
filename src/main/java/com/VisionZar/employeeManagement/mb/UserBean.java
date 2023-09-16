/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VisionZar.employeeManagement.mb;

import com.VisionZar.employeeManagement.common.PersonType;
import com.VisionZar.employeeManagement.common.SystemUserStatus;
import com.VisionZar.employeeManagement.domain.Employee;
import com.VisionZar.employeeManagement.domain.User;
import com.VisionZar.employeeManagement.service.EmployeeServiceLocal;
import com.VisionZar.employeeManagement.service.UserServiceLocal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author S2028873
 */
@ManagedBean
@ViewScoped
public class UserBean extends BaseBean<User> {

    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private UserServiceLocal userService;

    private List<Employee> employees = new ArrayList<>();
    private List<PersonType> personTypes = new ArrayList<>();
    private List<SystemUserStatus> systemUserStatus = new ArrayList<>();

    private Employee employee;
    private boolean employeeVisible;

    @PostConstruct
    public void init() {
        reset().setList(true);
        setPanelTitleName("User");
        addCollections(userService.listAll());
        employees = employeeService.listAll();
        personTypes.addAll(Arrays.asList(PersonType.values()));
        systemUserStatus.addAll(Arrays.asList(SystemUserStatus.values()));
        employeeVisible = Boolean.FALSE;
    }

    public void addOrUpdate(User user) {
        reset().setAdd(true);
        if (user != null) {
            setPanelTitleName("Update User");
            
            if (user.getPersonType().equals(PersonType.ADMINISTRATOR) || user.getPersonType().equals(PersonType.EMPLOYEE)) {
                employeeVisible = Boolean.TRUE;
                employee = employeeService.findUserByEmployeeId(user.getIdentifer());
            }
            user.setUpdateDate(new Date());
            user.setUpdatedBy(getActiveUser().getIdentifier());
        } else {
            setPanelTitleName("Add new User");
            user = new User();
            user.setCreatedBy(getActiveUser().getIdentifier());
            user.setCreatedDate(new Date());

            addCollection(user);
        }
        addEntity(user);
    }

   public void save(User user) {
        if (user.getId() != null) {
            userService.update(user);
            addInformationMessage("User  was successfully updated.");
        } else {
            userService.save(user);
            addInformationMessage("User was successfully created.");
        }
        reset().setList(true);
        setPanelTitleName("User");
    }
   
    public void cancel(User user) {
        if (user.getId() == null && getUsers().contains(user)) {
            remove(user);
        }
        reset().setList(true);
        setPanelTitleName("Users");
    }

    public void delete(User user) {
        userService.deleteById(user.getId());
        synchronizeUser(user);
        addInformationMessage("User was successfully deleted");
        reset().setList(true);
    }

    public void synchronizeUser(User user) {
        if (getCollections().contains(user)) {
            getCollections().remove(user);
        }
    }

    public List<String> getIdentifier() {
        List<String> identifiers = new ArrayList<>();
        for (User user : userService.listAll()) {
            identifiers.add(user.getIdentifer());
        }
        return identifiers;
    }

    public void systemUserListener() {
        if (getEntity().getPersonType().equals(PersonType.EMPLOYEE) || getEntity().getPersonType().equals(PersonType.ADMINISTRATOR)) {
            employeeVisible = Boolean.TRUE;
        }

    }

    public List<User> getUsers() {
        return this.getCollections();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<PersonType> getPersonTypes() {
        return personTypes;
    }

    public void setPersonTypes(List<PersonType> personTypes) {
        this.personTypes = personTypes;
    }

    public List<SystemUserStatus> getSystemUserStatus() {
        return systemUserStatus;
    }

    public void setSystemUserStatus(List<SystemUserStatus> systemUserStatus) {
        this.systemUserStatus = systemUserStatus;
    }

    public boolean isEmployeeVisible() {
        return employeeVisible;
    }

    public void setEmployeeVisible(boolean employeeVisible) {
        this.employeeVisible = employeeVisible;
    }
}
