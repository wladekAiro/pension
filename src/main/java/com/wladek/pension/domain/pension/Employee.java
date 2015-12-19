package com.wladek.pension.domain.pension;

import com.wladek.pension.domain.AbstractModel;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Created by wladek on 11/22/15.
 */
@Entity
public class Employee extends AbstractModel{
    @NotEmpty(message = "Please provide a first Name")
    private String firstName;
    @NotEmpty(message = "Please provide a second Name")
    private String secondName;
    @Email
    @NotEmpty(message = "Please provide an email address")
    private String email;
    @NotNull(message = "Please provide an id number")
    private Long idNumber;
    @ManyToOne
    private Employer employer;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getFullNames(){
        return getFirstName()+" "+getSecondName();
    }
}
