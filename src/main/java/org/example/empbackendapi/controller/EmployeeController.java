package org.example.empbackendapi.controller;

import lombok.AllArgsConstructor;
import org.example.empbackendapi.dto.EmployeeDto;
import org.example.empbackendapi.entity.Employee;
import org.example.empbackendapi.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.example.empbackendapi.Mapper.EmployeeMapper.mapToEmployee;
import static org.example.empbackendapi.Mapper.EmployeeMapper.mapToEmployeeDto;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){

        EmployeeDto savedEmp = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmp,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id){

        EmployeeDto emp = employeeService.getEmployee(id);
        return ResponseEntity.ok(emp);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee()
    {
        List<EmployeeDto> empList = employeeService.getAllEmployee();
        return ResponseEntity.ok(empList);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto e)
    {
        EmployeeDto emp = employeeService.updateEmployee(id,e);
        return new ResponseEntity<>(emp,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id)
    {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee with id "+ id + " successfully deleted");
    }

}
