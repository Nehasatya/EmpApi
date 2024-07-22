package org.example.empbackendapi.Mapper;

import org.example.empbackendapi.dto.EmployeeDto;
import org.example.empbackendapi.entity.Employee;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeDto e){
        return new Employee(
                e.getId(),
                e.getFirstName(),
                e.getLastName(),
                e.getEmail()
        );
    }

    public static EmployeeDto mapToEmployeeDto(Employee e){
        return new EmployeeDto(
                e.getId(),
                e.getFirstName(),
                e.getLastName(),
                e.getEmail()
        );
    }
}
