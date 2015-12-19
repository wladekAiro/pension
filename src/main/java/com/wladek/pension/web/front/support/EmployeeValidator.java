package com.wladek.pension.web.front.support;

import com.wladek.pension.domain.pension.Employee;
import com.wladek.pension.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * Created by george on 12/18/15.
 */

@Component
public class EmployeeValidator {

    @Autowired
    EmployeeRepository repository;

    public boolean validateNewEmployee(Employee employee, BindingResult result) {
        Employee existingEmployee = repository.findByIdNumber(employee.getIdNumber());
        if(existingEmployee != null) {
            result.rejectValue("idNumber", "user.idNumber.duplicate");
        }

        return result.hasErrors();
    }
}
