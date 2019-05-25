package ru.ravilova.employeedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ravilova.employeedb.dto.EmployeeDto;
import ru.ravilova.employeedb.dto.SignIdDto;
import ru.ravilova.employeedb.service.EmployeeService;

@RestController()
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/get")
    public ResponseEntity<EmployeeDto> getById(@RequestBody SignIdDto signIdDto){
        System.out.println("for " + signIdDto);
        EmployeeDto resp = employeeService.getBySignId(signIdDto);
        System.out.println("resp " + resp);
        return ResponseEntity.ok(resp);
    }

    @PostMapping()
    public SignIdDto post(@RequestBody EmployeeDto employeeDto){
        return employeeService.save(employeeDto);
    }

}
