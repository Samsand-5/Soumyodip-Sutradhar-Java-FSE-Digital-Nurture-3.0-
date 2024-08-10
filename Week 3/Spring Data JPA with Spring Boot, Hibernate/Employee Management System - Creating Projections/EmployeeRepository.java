package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Fetch specific fields of employees using a projection
    @Query("SELECT e.id as id, e.name as name, e.email as email, d.name as departmentName " +
           "FROM Employee e JOIN e.department d")
    List<EmployeeProjection> findAllEmployeeDetails();
}
