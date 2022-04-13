package com.meli.employees.service;

import com.meli.employees.domain.Employee;
import com.meli.employees.exception.NotFoundEmployee;
import com.meli.employees.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository repository;

    @Override
    public List<Employee> findAllBy(String name) {
        if(name != null) {
            return repository.findAllByFirstName(name);
        }

        List<Employee> employees = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(employees::add);
        return employees;
    }


    @Override
    public void create(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void update(String id, Employee employee) {
        Optional<Employee> optionalEmployee = repository.findById(id);
        optionalEmployee.orElseThrow(() -> new NotFoundEmployee("Not found employee with id "+id));
        Employee employeeUpdated = optionalEmployee.get();

        employeeUpdated.setFirstName(employee.getFirstName());
        employeeUpdated.setLastName(employee.getLastName());
        employeeUpdated.setAge(employee.getAge());
        employeeUpdated.setCity(employee.getCity());
        employeeUpdated.setState(employee.getState());

        repository.save(employeeUpdated);
    }
}
