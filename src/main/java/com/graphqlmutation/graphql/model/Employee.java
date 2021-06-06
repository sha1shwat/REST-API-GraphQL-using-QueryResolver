package com.graphqlmutation.graphql.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column(name = "id")
  private Integer employeeId;
  private String name;
  private String designation;
  @OneToOne
  @JoinColumn(name = "id")
  Users user;

  @Override
  public String toString(){
    return "Employee{" +
            "id=" + employeeId +
            ", name='" + name + '\'' +
            ", designation='" + designation +
            '}';
  }

}
