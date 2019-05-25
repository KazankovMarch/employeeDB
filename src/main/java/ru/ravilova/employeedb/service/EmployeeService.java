package ru.ravilova.employeedb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ravilova.employeedb.domain.Employee;
import ru.ravilova.employeedb.dto.EmployeeDto;
import ru.ravilova.employeedb.dto.SignIdDto;
import ru.ravilova.employeedb.repository.EmployeeRepository;
import ru.ravilova.employeedb.util.SignChecker;
import ru.ravilova.employeedb.util.SignMaker;

import java.util.Optional;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SignMaker signMaker;

    @Autowired
    private SignChecker signChecker;

    public EmployeeDto getBySignId(SignIdDto signIdDto) {
        if(signChecker.check(signIdDto)){
            Optional<Employee> optionalEmployee = employeeRepository.findById(signIdDto.getId());
            if(optionalEmployee.isPresent()){
                System.out.println("FOUND");
                Employee employee = optionalEmployee.get();
                return EmployeeDto.builder()
                        .firstName(employee.getFirstName())
                        .lastName(employee.getLastName())
                        .id(employee.getId())
                        .position(employee.getPosition())
                        .photo(employee.getPhoto())
                        .build();
            }
        }
        return null;
    }

    public SignIdDto save(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        if(employeeDto.getId()!=null){
            Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDto.getId());
            if(optionalEmployee.isPresent()){
                employee = optionalEmployee.get();
            }
        }
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setPosition(employeeDto.getPosition());
        employeeRepository.save(employee);
        return SignIdDto.builder()
                .signature(signMaker.make(employee.getId()))
                .id(employee.getId())
                .build();
    }
}
