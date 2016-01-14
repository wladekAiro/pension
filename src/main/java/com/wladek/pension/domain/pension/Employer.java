package com.wladek.pension.domain.pension;

import com.wladek.pension.domain.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by wladek on 11/23/15.
 */
@Entity
public class Employer extends AbstractModel {
    private String name;
    private String employer_id;
    private String employerNumber;

    @OneToMany(mappedBy = "employer")
    private Set<Employee> employee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployer_id() {
        return employer_id;
    }

    public void setEmployer_id(String employer_id) {
        this.employer_id = employer_id;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }

    public String getEmployerNumber() {
        return employerNumber;
    }

    public void setEmployerNumber(String employerNumber) {
        this.employerNumber = employerNumber;
    }
}
