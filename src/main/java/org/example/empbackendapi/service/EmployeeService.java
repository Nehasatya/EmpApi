package org.example.empbackendapi.service;

import org.example.empbackendapi.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService{

    EmployeeDto createEmployee(EmployeeDto emp);

    EmployeeDto getEmployee(Long id);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto updateEmployee(Long id, EmployeeDto e);

    void deleteEmployee(Long id);
}
