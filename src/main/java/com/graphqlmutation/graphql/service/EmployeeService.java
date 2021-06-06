package com.graphqlmutation.graphql.service;

import com.graphqlmutation.graphql.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    void save(Employee employee);
    List<Employee> findAll();
    Employee findByName(String name);
    long count();
    Optional<Employee> findById(int id);
}
