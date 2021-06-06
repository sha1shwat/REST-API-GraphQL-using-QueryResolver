package com.graphqlmutation.graphql.service.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqlmutation.graphql.model.Employee;
import com.graphqlmutation.graphql.model.Users;
import com.graphqlmutation.graphql.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class UserQuery implements GraphQLResolver<Employee> {

    @Autowired
    UserRepository userRepository;

    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public CompletableFuture<Users> users(Employee employee){

        log.info("Data fetching for id {}",employee.getEmployeeId());
        return  CompletableFuture.supplyAsync(() -> {return userRepository.findById(employee.getEmployeeId()).get();},executorService);
    }

}
