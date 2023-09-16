/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VisionZar.employeeManagement.mb;

import com.VisionZar.employeeManagement.common.EmployeeType;
import com.VisionZar.employeeManagement.common.PersonType;
import com.VisionZar.employeeManagement.domain.Employee;
import com.VisionZar.employeeManagement.service.EmployeeServiceLocal;
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
public class EmployeeBean extends BaseBean<Employee> {

    @Autowired
    private EmployeeServiceLocal employeeService;
    private List<EmployeeType> employeeTpes = new ArrayList<>();
    private List<PersonType> personTypes = new ArrayList<>();
    private boolean employeeVisible;
    
    @PostConstruct
    public void init() {
        reset().setList(true);
        setPanelTitleName("Employee");
        addCollections(employeeService.listAll());
        employeeTpes.addAll(Arrays.asList(EmployeeType.values()));
        personTypes.addAll(Arrays.asList(PersonType.values()));
        employeeVisible = Boolean.FALSE;
    }

  
    public void addOrUpdate(Employee employee) {
        reset().setAdd(true);
        if (employee != null) {
            setPanelTitleName("Update Employee");
            employee.setUpdateDate(new Date());
            employee.setUpdatedBy(getActiveUser().getFirstName() + " "+ getActiveUser().getLastName());
        } else {
            employee = new Employee();
            setPanelTitleName("Add new Employee");
            employee.setCreatedBy(getActiveUser().getFirstName() + " "+ getActiveUser().getLastName());
            employee.setCreatedDate(new Date());
            employee.setPersonType(PersonType.EMPLOYEE);


            addCollection(employee);
        }
        addEntity(employee);
    }
    public void save(Employee employee) {
        if (employee.getId() != null ) {
            employeeService.update(employee);
            addInformationMessage("Employee was successfully updated");
        } else {
            employeeService.save(employee);
            addInformationMessage("Employee was successfully created");
        }
        reset().setList(true);
        setPanelTitleName("Employees");
    }

    public void cancel(Employee employee) {
        if (employee.getId() == null && getEmployees().contains(employee)) {
            remove(employee);
        }
        reset().setList(true);
        setPanelTitleName("Employees");
    }

    public void delete(Employee employee) {
 
        employeeService.deleteById(employee.getId());
        sychronizeEmployee(employee);
        addInformationMessage("Employee was successully deleted");
        reset().setList(true);
    }

    public void sychronizeEmployee(Employee employee) {
        if (getCollections().contains(employee)) {
            getCollections().remove(employee);
        }
    }

    public List<Employee> getEmployees() {
        return this.getCollections();
    }

    public List<EmployeeType> getEmployeeTpes() {
        return employeeTpes;
    }

    public void setEmployeeTpes(List<EmployeeType> employeeTpes) {
        this.employeeTpes = employeeTpes;
    }


    public List<PersonType> getPersonTypes() {
        return personTypes;
    }

    public void setPersonTypes(List<PersonType> personTypes) {
        this.personTypes = personTypes;
    }


    public boolean isEmployeeVisible() {
        return employeeVisible;
    }

    public void setEmployeeVisible(boolean employeeVisible) {
        this.employeeVisible = employeeVisible;
    }
}
