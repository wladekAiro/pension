package com.wladek.pension.service;

import com.wladek.pension.domain.pension.Employee;
import com.wladek.pension.domain.pension.Employer;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by wladek on 1/13/16.
 */
public interface EmployerService {
    public Employer create(Employer employer);
    public Employer findOne(Long id);
    public List<Employer> findAll();
    public boolean delete(Long id);
    public Employer update(Employer employer);
    public Page<Employee> getAllEmployees(Employer employer , int page , int size);
}
