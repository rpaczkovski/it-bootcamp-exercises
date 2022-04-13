package com.meli.employees.service;

import com.meli.employees.domain.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllBy(String name);
    void create(Employee employee);
    void update(String id, Employee employee);
}
