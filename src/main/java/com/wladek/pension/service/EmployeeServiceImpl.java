package com.wladek.pension.service;

import com.wladek.pension.domain.User;
import com.wladek.pension.domain.pension.Employee;
import com.wladek.pension.domain.enumeration.UserRole;
import com.wladek.pension.domain.enumeration.UserState;
import com.wladek.pension.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by george on 12/18/15.
 */

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;
    @Autowired
    EmployerService employerService;
    @Autowired
    UserService userService;

    @Override
    public Employee addNewEmployee(Employee employee) {
        employee.setEmployer(employerService.findOne(employee.getEmployerId()));

        User employeeUser = new User();

        employeeUser.setUserRole(UserRole.EMPLOYEE);
        employeeUser.setEmail(employee.getEmail());
        employeeUser.setLoginId(employee.getFirstName());
        employeeUser.setPassword("pass");
        employeeUser.setName(employee.getFirstName() + " "+employee.getSecondName());

        userService.addNewUser(employeeUser);

        Employee newEmployee = repository.save(employee);
        return newEmployee;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public Employee editEmployee(Employee employee) {
        Employee inDb = null;
        if(employee.getId() != null){
            inDb = getOne(employee.getId());

            inDb.setIdNumber(employee.getIdNumber());
            inDb.setEmail(employee.getEmail());
            inDb.setSecondName(employee.getSecondName());
            inDb.setFirstName(employee.getFirstName());

            repository.save(inDb);
        }
        return inDb;
    }

    @Override
    public boolean delete(Long id) {
        repository.delete(id);
        return true;
    }
}
