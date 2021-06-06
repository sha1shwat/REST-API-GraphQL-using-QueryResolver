package com.graphqlmutation.graphql.repository;

import com.graphqlmutation.graphql.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    Employee findByName(String name);
}
