package org.example.empbackendapi.service.impl;

import lombok.AllArgsConstructor;
import org.example.empbackendapi.dto.EmployeeDto;
import org.example.empbackendapi.entity.Employee;
import org.example.empbackendapi.exceptions.ResourceNotFound;
import org.example.empbackendapi.repository.EmployeeRepository;
import org.example.empbackendapi.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.empbackendapi.Mapper.EmployeeMapper.mapToEmployee;
import static org.example.empbackendapi.Mapper.EmployeeMapper.mapToEmployeeDto;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto e) {

        Employee emp = mapToEmployee(e);
        Employee savedEmp = employeeRepository.save(emp);
        return mapToEmployeeDto(savedEmp);
    }

    @Override
    public EmployeeDto getEmployee(Long id) {

        Employee e = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("The Employee with given id is not found: "+id));
        return mapToEmployeeDto(e);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> eList = employeeRepository.findAll();
        return eList.stream().map((emp) -> mapToEmployeeDto(emp)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto e) {

        Employee emp = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("The Employee with givn is is not found "+id));

        emp.setFirstName(e.getFirstName());
        emp.setLastName(e.getLastName());
        emp.setEmail(e.getEmail());

        Employee updatedEmployee = employeeRepository.save(emp);
        return mapToEmployeeDto(emp);
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee e = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFound("The given employee with id "+id+" does not exist"));

        employeeRepository.delete(e);

    }
}
