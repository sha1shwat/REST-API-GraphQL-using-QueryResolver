package com.graphqlmutation.graphql.service.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphqlmutation.graphql.model.Employee;
import com.graphqlmutation.graphql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMutation implements GraphQLMutationResolver {

    @Autowired
    private EmployeeService employeeService;

    public Employee newEmployee(String name, String designation){

        Employee employee = new Employee();
        employee.setName(name);
        employee.setDesignation(designation);
        employeeService.save(employee);
        Employee employee1 = employeeService.findByName(name);
        return employee1;
    }


}
