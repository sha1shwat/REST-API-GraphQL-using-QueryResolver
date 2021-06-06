package com.graphqlmutation.graphql.service.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqlmutation.graphql.model.Employee;
import com.graphqlmutation.graphql.service.EmployeeService;
import com.graphqlmutation.graphql.utility.QueryParamWrapper;
import javassist.bytecode.analysis.Executor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Slf4j
public class EmployeeQuery implements GraphQLQueryResolver {

  @Autowired
  EmployeeService employeeService;

  private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

  QueryParamWrapper queryParamWrapper = new QueryParamWrapper();

  public CompletableFuture<List<Employee>> allEmployees(){
      log.info("Data fetching for id ");
      return CompletableFuture.supplyAsync(()->{return employeeService.findAll();});
  }

  public CompletableFuture<List<Employee>> allEmployeesWithFilter(String filter){

   Integer id = queryParamWrapper.getObjectFromJson(filter, Employee.class).getEmployeeId();


      return CompletableFuture.supplyAsync(()->{return Arrays.asList(employeeService.findById(id).get());},executorService);
  }

  public CompletableFuture<Long> countEmployees(){
      return CompletableFuture.supplyAsync(()->{return employeeService.count();},executorService);
  }

  public Optional<Employee> getEmployee(int id){
      return employeeService.findById(id);
  }


}
