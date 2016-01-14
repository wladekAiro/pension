package com.wladek.pension.repository;

import com.wladek.pension.domain.pension.Employee;
import com.wladek.pension.domain.pension.Employer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by george on 12/18/15.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    Employee findByIdNumber(Long idNumber);
    public Page<Employee> findByEmployer(Employer employer , Pageable pageable);

}
