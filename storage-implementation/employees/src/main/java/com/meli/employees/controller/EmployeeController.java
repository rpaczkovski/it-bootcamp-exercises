package com.meli.employees.controller;

import com.meli.employees.domain.Employee;
import com.meli.employees.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService service;

    @PostMapping
    public @ResponseBody String create(@RequestBody Employee employee) {
        service.create(employee);
        return "The employee was created successfully";
    }

    @GetMapping
    public @ResponseBody List<Employee> getAll(@RequestParam(required = false) String name) {
        return service.findAllBy(name);
    }

    @PutMapping("{id}")
    public @ResponseBody String update(@PathVariable String id, @RequestBody Employee employee) {
            service.update(id, employee);
            return "The employee was updated successfully";
    }

}
