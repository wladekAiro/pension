package com.wladek.pension.domain.pension;

import com.wladek.pension.domain.AbstractModel;

import javax.persistence.Entity;

/**
 * Created by wladek on 11/24/15.
 * Investment
 */
@Entity
public class Assets extends AbstractModel {
    private String name;
    private String type;
    private String cost;
    private String expectedAnnualReturn;
    private String actualReturn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getExpectedAnnualReturn() {
        return expectedAnnualReturn;
    }

    public void setExpectedAnnualReturn(String expectedAnnualReturn) {
        this.expectedAnnualReturn = expectedAnnualReturn;
    }

    public String getActualReturn() {
        return actualReturn;
    }

    public void setActualReturn(String actualReturn) {
        this.actualReturn = actualReturn;
    }
}
