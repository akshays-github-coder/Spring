package com.cwa.controller;

import com.cwa.api.EmployeesApi;
import com.cwa.dto.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController
        implements EmployeesApi {

    @Override
    public ResponseEntity<Employee> employeesIdGet(Integer id) {

        Employee employee = new Employee();

        employee.setId(id);
        employee.setName("Akshay");
        employee.setEmail("akshay@test.com");

        return ResponseEntity.ok(employee);
    }
}
