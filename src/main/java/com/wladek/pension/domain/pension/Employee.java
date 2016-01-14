package com.wladek.pension.domain.pension;

import com.wladek.pension.domain.AbstractModel;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by wladek on 11/22/15.
 * pensioner
 */
@Entity
public class Employee extends AbstractModel{
    @NotEmpty(message = "Please provide a first Name")
    private String firstName;
    @NotEmpty(message = "Please provide a second Name")
    private String secondName;
    @NotEmpty(message = "Please provide a sir name")
    private String sirName;
    @Email(message = "Please provide a valid email address")
    @NotEmpty(message = "Please provide an email address")
    private String email;
    @NotNull(message = "Please provide an id number")
    private Long idNumber;
    @NotEmpty(message = "Please provide KRA pin")
    private String kraPin;
    @NotEmpty(message = "Please provide a bank")
    private String bankName;
    @NotEmpty(message = "Please provide your branch")
    private String bankBranch;
    @NotEmpty(message = "Please provide account number")
    private String accountNumber;
    private Date expectedRetirementDate;
    private Date employmentDate;
    private Date dateOfBirth;
    @NotNull(message = "Please provide monthly salary")
    private Long monthlySalary;
    private Long rate;
    @ManyToOne
    private Employer employer;
    @OneToOne(mappedBy = "employee" , fetch = FetchType.EAGER)
    private File file;
    @OneToMany(mappedBy = "employee" , fetch = FetchType.LAZY)
    private List<NextOfKeen> nextOfKeen;
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "employee")
    private List<Transaction> transactions;

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

    public String getSirName() {
        return sirName;
    }

    public void setSirName(String sirName) {
        this.sirName = sirName;
    }

    public String getKraPin() {
        return kraPin;
    }

    public void setKraPin(String kraPin) {
        this.kraPin = kraPin;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public Date getExpectedRetirementDate() {
        return expectedRetirementDate;
    }

    public void setExpectedRetirementDate(Date expectedRetirementDate) {
        this.expectedRetirementDate = expectedRetirementDate;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Long monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<NextOfKeen> getNextOfKeen() {
        return nextOfKeen;
    }

    public void setNextOfKeen(List<NextOfKeen> nextOfKeen) {
        this.nextOfKeen = nextOfKeen;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getFullName(){
        return firstName + " "+secondName+" "+sirName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Transient
    private Long employerId;

    public Long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }
}
