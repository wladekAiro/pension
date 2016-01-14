package com.wladek.pension.service;

import com.wladek.pension.domain.pension.Employee;
import com.wladek.pension.domain.pension.Employer;
import com.wladek.pension.repository.EmployeeRepository;
import com.wladek.pension.repository.EmployerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wladek on 1/13/16.
 */
@Service
public class EmployerServiceImpl implements EmployerService {
    @Autowired
    private EmployerRepo employerRepo;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employer create(Employer employer) {
        return employerRepo.save(employer);
    }

    @Override
    public Employer findOne(Long id) {
        return employerRepo.findOne(id);
    }

    @Override
    public List<Employer> findAll() {
        return employerRepo.findAll();
    }

    @Override
    public boolean delete(Long id) {
        employerRepo.delete(id);
        return true;
    }

    @Override
    public Employer update(Employer employer) {
        /*
         Implements update logic
         */
        Employer employerInDb = findOne(employer.getId());
        employerInDb.setEmployer_id(employer.getEmployer_id());
        employerInDb.setEmployerNumber(employer.getEmployerNumber());
        employerInDb.setName(employer.getName());

        return employerRepo.save(employerInDb);
    }

    @Override
    public Page<Employee> getAllEmployees(Employer employer, int page, int size) {
        page = page - 1;
        PageRequest pageRequest = new PageRequest(page , size);
        return employeeRepository.findByEmployer(employer , pageRequest);
    }
}
