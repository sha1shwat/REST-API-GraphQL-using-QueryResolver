package com.graphqlmutation.graphql.repository;

import com.graphqlmutation.graphql.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users,Integer> {
}
