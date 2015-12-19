package com.wladek.pension.service;

/**
 * Created by george on 12/18/15.
 */
import com.wladek.pension.domain.pension.Employee;
import java.util.List;

public interface EmployeeService {

    public Employee addNewEmployee(Employee employee);
    public List<Employee> findAllEmployees();
    public Employee getOne(Long id);
    public Employee editEmployee(Employee employee);
    public boolean delete(Long id);
}