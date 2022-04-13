package com.meli.employees.repository;

import com.meli.employees.domain.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {
    List<Employee> findAllByFirstName(String name);
}
