package com.wladek.pension.domain.pension;

import com.wladek.pension.domain.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 * Created by wladek on 1/13/16.
 * holds all links to uploaded files
 */
@Entity
public class File extends AbstractModel {
    private String name;

    @OneToOne
    private Employee employee;
    @OneToOne(mappedBy = "file")
    private NextOfKeen nextOfKeen;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public NextOfKeen getNextOfKeen() {
        return nextOfKeen;
    }

    public void setNextOfKeen(NextOfKeen nextOfKeen) {
        this.nextOfKeen = nextOfKeen;
    }
}
