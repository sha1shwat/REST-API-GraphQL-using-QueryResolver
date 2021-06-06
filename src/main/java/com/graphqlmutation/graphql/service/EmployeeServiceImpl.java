package com.graphqlmutation.graphql.service;

import com.graphqlmutation.graphql.model.Employee;
import com.graphqlmutation.graphql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void save(Employee employeeRequest){

        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setDesignation(employeeRequest.getDesignation());
        employeeRepository.save(employee);
    }

    public List<Employee> findAll(){
        return (List<Employee>) employeeRepository.findAll();
    }

    public long count(){
        return employeeRepository.count();
    }

    public Optional<Employee> findById(int id){
        return employeeRepository.findById(id);
    }

    public Employee findByName(String name){
        return employeeRepository.findByName(name);
    }

}
