package com.graphqlmutation.graphql.controller;

import com.graphqlmutation.graphql.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.graphqlmutation.graphql.service.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<Iterable<Employee>> getAllEmployees(){

        Iterable<Employee> employees = employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);

    }

    @GetMapping("/{name}")
    public ResponseEntity<Employee> findByName(@PathVariable String name){

        Employee employees = employeeService.findByName(name);
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Map<String,String >> addEmployee(@RequestBody Employee employeeRe){

        Map<String,String> response = new HashMap<>();
        employeeService.save(employeeRe);
        response.put("message","Employee added succ");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
